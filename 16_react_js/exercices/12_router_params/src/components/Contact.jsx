import React, { useEffect, useState } from 'react';
import { Outlet, Link } from 'react-router-dom';
import ContactContext from '../context/ContactContext';

const Contact = () => {

    const [contactList, setContactList] = useState([])
    const [counter, setCounter] = useState(1)

    useEffect(() => {
        console.log('Change contact list => ', contactList)

    }, [contactList])

    return (
        <>
        <div>
            <h2>Liste des contacts</h2>
            <Link to={'/'}>Retour à l'accueil</Link>
            <hr />
        </div>
        <ContactContext.Provider value={{contactList, setContactList, counter, setCounter}}>

            <Outlet />

        </ContactContext.Provider>
        </>
    );
}

export default Contact;
