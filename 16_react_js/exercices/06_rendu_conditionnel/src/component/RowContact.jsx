import React from 'react';

const RowContact = ({contact}) => {
    return (
        <tr>
            <td>{contact.lastname}</td>
            <td>{contact.firstname}</td>
            <td>{contact.phone}</td>
        </tr>
    );
}

export default RowContact;
