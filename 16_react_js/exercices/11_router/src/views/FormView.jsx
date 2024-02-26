import React from 'react';

const FormView = () => {
    return (
        <div>
            <h2>Form page</h2>
            <hr />
            <form action="">
                <label htmlFor="">Nom</label>
                <input type="text" />
                <label htmlFor="">Prénom</label>
                <input type="text" />
            </form>
        </div>
    );
}

export default FormView;
