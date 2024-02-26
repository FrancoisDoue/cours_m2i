import React, { useContext } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import ContactContext from '../context/ContactContext';

const ContactDisplay = () => {
    const navigate = useNavigate()

    const {contactList} = useContext(ContactContext)

    return (
        <div>
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Email</th>
                        <th>Numéro de téléphone</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                        {!!contactList.length && contactList.map(c => 
                        <tr key={c.id}>
                            <td>{c.id}</td>
                            <td>{c.firstname}</td>
                            <td>{c.lastname}</td>
                            <td>{c.email}</td>
                            <td>{c.tel}</td>
                            <td>
                                <button onClick={() => navigate(`/contact/edit/${c.id}?mode=edit`)}>Edit</button>
                                <button 
                                    onClick={() => navigate(`/contact/edit/${c.id}?mode=delete`)}
                                    style={{backgroundColor: 'darkred'}}
                                >
                                    Delete
                                </button>
                            </td>
                        </tr>
                        )}   
                </tbody>
                <tfoot>
                    <tr>
                        <th colSpan={6}>
                            <button onClick={() => navigate('/contact/edit/')}>Ajouter un contact</button>
                        </th>
                    </tr>
                </tfoot>
            </table>
            <div>
            </div>
        </div>
    );
}

export default ContactDisplay;
