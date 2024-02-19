import React from 'react';

const TableLine = (props) => {
    const { rowValue } = props
    console.log(rowValue)

    // for

    return (
        <tr>
           <td>{rowValue.index}</td>
           <td>{rowValue.val1}</td>
           <td>{rowValue.val2}</td>
        </tr>
    );
}

export default TableLine;
