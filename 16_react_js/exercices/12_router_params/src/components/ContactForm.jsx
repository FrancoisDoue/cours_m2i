import React from 'react';
import { useNavigate, useParams, useSearchParams } from 'react-router-dom';
import AddForm from './form/AddForm';
import DeleteForm from './form/DeleteForm';
import EditForm from './form/EditForm';

const ContactForm = () => {
    const navigateTo = useNavigate()
    const { id } = useParams()
    const [searchParams] = useSearchParams()
    const mode = searchParams.get('mode')

    console.log(id, mode)

    return (
        <div>
            {/* La ternaire de la propreté */}
        {!id ? 
            <AddForm/> : 
            (mode === 'delete' ? 
                <DeleteForm id={id}/> : 
                <AddForm id={id}/>
            )
        }
        <div>
            <button onClick={() => navigateTo('/contact')}>Retour à la liste des contacts</button>
        </div>
        </div>
    );
}

export default ContactForm;
