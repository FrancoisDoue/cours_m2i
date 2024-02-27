import React, { useContext, useEffect, useRef, useState } from 'react';
import ContactContext from '../../context/ContactContext';
import { useNavigate } from 'react-router-dom';

const AddForm = ({id}) => {
    
    const navigateTo = useNavigate()
    const { contactList, setContactList } = useContext(ContactContext)
    const contact = (!!id) ? contactList.find(c => c.id = id): {}
    console.log(contact == {} && !!id)


    const fname = useRef()
    const lname = useRef()
    const email = useRef()
    const tel = useRef()

    const handleSubmit = (e) => {
        e.preventDefault()
        if (!!id) {
            // console.log(tel.current.value)
            // setContact({...contact,
            //     // id: contact.id,
            //     firstname: fname.current.value,
            //     lastname:lname.current.value,
            //     email: email.current.value,
            //     tel: tel.current.value,
            // })
            // console.log(contact)
            // useEffect(
                setContactList(prevList => {
                    // console.log(contact)
                    let i = prevList.findIndex(c => c.id == id)
                    console.log(i)
                    // findedContact = {...contact}
                    // console.log(findedContact)
                    prevList[i] = {...contact,
                        // id: contact.id,
                        firstname: fname.current.value,
                        lastname:lname.current.value,
                        email: email.current.value,
                        tel: tel.current.value,
                    }
                    console.log(contact)
                    // console.log(prevList)
                    return [...prevList]
                }
            )
            // , [contact])
            
            
            
        } else {
            // const contactId =  counter
            setContactList([...contactList, {
                // id: counter,
                id: Date.now(),
                firstname: fname.current.value,
                lastname:lname.current.value,
                email: email.current.value,
                tel: tel.current.value,
            }])
            // setCounter(counter + 1)
        }

        // navigateTo('/contact')
    }

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="lname">Nom</label>
                <input type="text" id='lname' defaultValue={ contact?.lastname || ''} ref={lname}/>
            </div>
            <div>
                <label htmlFor="fname">Prénom</label>
                <input type="text" id='fname' defaultValue={ contact?.firstname || ''} ref={fname} />
            </div>
            <div>
                <label htmlFor="email">Email</label>
                <input type="text" id='email' defaultValue={ contact?.email || ''} ref={email} />
            </div>
            <div>
                <label htmlFor="tel">Tel</label>
                <input type="text" id='tel' defaultValue={ contact?.tel || ''} ref={tel} />
            </div>
            <button type='submit'>submit</button>
        </form>
    );
}

export default AddForm;
