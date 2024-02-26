import React, { useContext } from 'react';
import ContactContext from '../../context/ContactContext';
import { useNavigate } from 'react-router-dom';

const DeleteForm = ({id}) => {

    const navigateTo = useNavigate()
    const {contactList, setContactList} = useContext(ContactContext)

    const contact = contactList.find(c => c.id === +id)
    const deleteContact = () => {
        setContactList(prevContact => prevContact.filter(c => c != contact))
        navigateTo('/contact')
    }

    return (
        <div>
            <h3>êtes vous sûr de vouloir supprimer {contact.firstname} {contact.lastname}</h3>
            <div>
                <button
                    style={{backgroundColor: 'darkred'}}
                    onClick={() => navigateTo('/contact')}
                >
                    Annuler
                </button>
                <button
                    style={{backgroundColor: 'orange', color: 'black'}}
                    onClick={deleteContact}
                >
                    Confirmer
                </button>
            </div>
            <hr />
        </div>
    );
}

export default DeleteForm;
