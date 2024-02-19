import React from 'react';

const TableNames = () => {
    const nameList = [
        {lname: 'Doué', fname: 'François', age: 29},
        {lname: 'Delafosse', fname: 'Florian', age: 30},
        {lname: 'Messuve', fname: 'Alexandre', age: 26},
    ]

    return (
        <table>
            <thead>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Age</th>
            </thead>
            <tbody>
                {nameList.map((line, i) => 
                    <tr key={i}>
                        <td>{line.lname}</td>
                        <td>{line.fname}</td>
                        <td>{line.age}</td>
                    </tr>
                    )}
            </tbody>
        </table>
    );
}

export default TableNames;
