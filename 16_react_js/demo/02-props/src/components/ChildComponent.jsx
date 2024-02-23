import React from 'react';

const ChildComponent = (props) => {
    const { toto, funcSayHello } = props
    // const toto = props.toto
    // const hello = props.funcSayHello
    const sayHello = () => {
        return console.log(`${toto} dit bonjour. Wééé`)
    }
    return (
        <div>
            <h3>ChildComponent</h3>
            <button onClick={sayHello}>{toto} dit bonjour.</button>
            <button onClick={() => funcSayHello(toto)}> Dit bonjour du parent</button>
        </div>
    );
}

export default ChildComponent;
