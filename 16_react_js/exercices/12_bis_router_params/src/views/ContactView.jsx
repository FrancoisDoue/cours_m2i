import React from 'react';
import { useNavigate, useOutletContext } from 'react-router-dom';

const ContactView = () => {
    const [contactList] = useOutletContext()
    const navigate = useNavigate()

    return (
        <div>
            <h2>Contact list</h2>
            <table style={{width: '100%'}}>
                <thead>
                    <tr>
                        {/* <th>#</th> */}
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {!!contactList.length && contactList.map( (c) =>
                        <tr key={c.id}>
                            {/* <td>{c.id}</td> */}
                            <td>{c.firstname}</td>
                            <td>{c.lastname}</td>
                            <td>{c.email}</td>
                            <td>{c.phone}</td>
                            <td>
                                <button onClick={() => navigate(`/contacts/edit/${c.id}?mode=edit`)}>Editer</button>
                                <button onClick={() => navigate(`/contacts/edit/${c.id}?mode=delete`)}>Supprimer</button>
                            </td>
                        </tr>
                    )}

                </tbody>
                <tfoot>
                    <tr>
                        <td colSpan={5}>
                            <button onClick={() => navigate('/contacts/edit')}>Add contact</button>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </div>
    );
};

export default ContactView;