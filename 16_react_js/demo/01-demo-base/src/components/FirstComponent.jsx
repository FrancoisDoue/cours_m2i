import React from 'react';
import classes from './FirstComponent.module.css'
import TableRow from './TableRow';

const FirstComponent = () => {
    let nameList = ['Florian', 'Mohamed', 'François']
    let alex = 'Alexandre'
    const catchPhrase = () => {
        return `La tête à l'envers d'${alex}, c'est la tête à l'endroit d'${alex}`
    }
    return ( 
        <>
        <div className={classes.div} >{catchPhrase()}</div>
        {/* <div>
            <ul>
                {nameList.map((name, i) => <li key={i}>{name}</li>)}
            </ul>
            <p className={classes.red}>vous jugent</p>
        </div> */}
        <table>
            <thead>
                <th>Col A</th>
                <th>Col B</th>
                <th>Col C</th>
            </thead>
            <tbody>
                <tr>
                    <TableRow />
                </tr>
            </tbody>
        </table>
        </>
    );
}

 
export default FirstComponent;