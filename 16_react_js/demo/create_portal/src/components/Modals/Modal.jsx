import React from 'react';
import {createPortal} from 'react-dom'; 
import classes from './Modal.module.css'

const Modal = ({children, close}) => {
    return createPortal(
        <div  className={classes.modal}>
            <div className={classes.modalContent}>
                {children}
                <button onClick={close}>#fermeTaModal</button>
            </div>
        </div>,
        document.body
    );
}

export default Modal;
