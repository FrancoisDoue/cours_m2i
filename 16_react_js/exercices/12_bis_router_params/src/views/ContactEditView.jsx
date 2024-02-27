import React, { useRef } from 'react';

const ContactEditView = () => {
    const fname = useRef()
    const lname = useRef()
    const email = useRef()
    const phone = useRef()
    
    const handleSubmit = (e) => {
        e.preventDefault()
        console.log('On handleSubmit')
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="fname">Prénom</label>
                    <input type="text" id='fname' name='fname' ref={fname} />
                </div>
                <div>
                    <label htmlFor="lname">Nom</label>
                    <input type="text" id='lname' name='lname' ref={lname} />
                </div>
                <div>
                    <label htmlFor="email">Email</label>
                    <input type="text" id='email' name='email' ref={email} />
                </div>
                <div>
                    <label htmlFor="phone">Téléphone</label>
                    <input type="text" id='phone' name='phone' ref={phone} />
                </div>
                <div>
                    <button type='submit'>Ajouter contact</button>
                </div>
            </form>
        </div>
    );
};

export default ContactEditView;