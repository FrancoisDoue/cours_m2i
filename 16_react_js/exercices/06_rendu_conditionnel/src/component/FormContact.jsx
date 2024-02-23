import React, { useState } from 'react';

const FormContact = ({cb}) => {
    const [lastname, setLastname] = useState('')
    const [firstname, setFirstname] = useState('')
    const [phone, setPhone] = useState('')

    const sendContact = () => {
      if (!lastname || !firstname || !phone) return;
      const newContact = {lastname: lastname, firstname: firstname, phone: phone }
      cb(newContact)
      setLastname('')
      setFirstname('')
      setPhone('')
    }

    return (
        <>
        <div>
          <label htmlFor="lastname">Nom</label>
          <input type="text" name="lastname" id="lastname" value={lastname} onInput={(e) => setLastname(e.target.value)}/>
        </div>
        <div>
          <label htmlFor="firstname">Prénom</label>
          <input type="text" name="firstname" id="firstname" value={firstname} onInput={(e) => setFirstname(e.target.value)}/>
        </div>
        <div>
          <label htmlFor="phone">Téléphone</label>
          <input type="text" name="phone" id="phone" value={phone} onInput={(e) => setPhone(e.target.value)}/>
        </div>
        <button onClick={sendContact}>Ajouter contact</button>
        </>
    );
}

export default FormContact;