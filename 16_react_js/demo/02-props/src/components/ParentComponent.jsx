import React from 'react';
import ChildComponent from './ChildComponent';

const ParentComponent = () => {
    let maVariable = 'Georges'
    const sayHelloFromParent = (name) => {
        return alert(`${name} dit bonjour. Et cela du parent.\nC'est totalement fou.\nC'est dingue.`)
    }
    return (
        <div>
            <h1>Parent component</h1>
            <ChildComponent
                toto={maVariable}
                funcSayHello={sayHelloFromParent}
            />
        </div>
    );
}

export default ParentComponent;
