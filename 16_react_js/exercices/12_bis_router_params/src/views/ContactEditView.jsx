import React, { useRef, useState } from 'react';
import {useParams, useNavigate, useSearchParams, useOutletContext} from 'react-router-dom'

const ContactEditView = () => {
    const { idContact } = useParams()
    const navigate = useNavigate()
    const [searchParams] = useSearchParams()
    const mode = searchParams.get('mode') || 'add'
    
    const [contactList, setContactList] = useOutletContext()
    const [contact] = useState(
        idContact ? contactList.find(c => c.id == idContact): {}
    )

    const fname = useRef()
    const lname = useRef()
    const email = useRef()
    const phone = useRef()

    const addMode = () => {
        const newContact = {
            id: `${Date.now()}`,
            firstname: fname.current.value,
            lastname: lname.current.value,
            email: email.current.value,
            phone: phone.current.value,
        }
        setContactList([...contactList, newContact])
    }

    const deleteMode = () => setContactList(prevList => prevList.filter(c => c == contact))

    const editMode = () => {
        const editedContactList = [...contactList]
        const editedContact = {
            id: contact.id,
            firstname: fname.current.value,
            lastname: lname.current.value,
            email: email.current.value,
            phone: phone.current.value,
        }
        const i = contactList.findIndex(c => c.id == idContact)
        editedContactList[i] = editedContact
        setContactList(editedContactList)
    }
    
    const handleSubmit = (e) => {
        e.preventDefault()
        if (mode == 'add') addMode()
        if (mode == 'delete' && !!idContact) deleteMode()
        if (mode == 'edit' && !!idContact) editMode()
        console.log('On handleSubmit')
        navigate('/contacts')
    }

    console.log(contact)

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="fname">Prénom</label>
                    <input 
                        type="text" 
                        id='fname' 
                        name='fname' 
                        ref={fname} 
                        defaultValue={mode != 'add' ? contact?.firstname:''} 
                        readOnly={mode == 'delete'}
                    />
                </div>
                <div>
                    <label htmlFor="lname">Nom</label>
                    <input 
                        type="text" 
                        id='lname' 
                        name='lname' 
                        ref={lname} 
                        defaultValue={mode != 'add' ? contact?.lastname:''}
                        readOnly={mode == 'delete'}
                    />
                </div>
                <div>
                    <label htmlFor="email">Email</label>
                    <input 
                        type="text" 
                        id='email' 
                        name='email' 
                        ref={email} 
                        defaultValue={mode != 'add' ? contact?.email:''} 
                        readOnly={mode == 'delete'}
                    />
                </div>
                <div>
                    <label htmlFor="phone">Téléphone</label>
                    <input 
                        type="text" 
                        id='phone' 
                        name='phone' 
                        ref={phone} 
                        defaultValue={mode != 'add' ? contact?.phone:''} 
                        readOnly={mode == 'delete'}
                    />
                </div>
                <div>
                    <button type='submit'>
                        {mode == 'add' ? 
                            'Ajouter contact':
                            mode == 'delete' ?
                                'Supprimer contact':
                                'Editer contact'
                        }
                    </button>
                </div>
            </form>
        </div>
    );
};

export default ContactEditView;