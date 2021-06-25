import Button from "./Button";
import {useEffect, useState} from "react";

import './ConfirmationDialog.css';

const ConfirmationDialog = ({text, method, showState, onClose}) => {
    const [isVisible, setIsVisible] = useState(showState)

    const onConfirm = () => {
        method();
        onClose();
    }

    useEffect(() => {
        setIsVisible(showState);
    }, [showState])

    if(!isVisible) return null;

    return isVisible && (
        <section className="confirmation__dialog">
            <div className="confirmation__box">
                <p>{text}</p>
                <div className="confirmation__buttons">
                    <Button method={onConfirm} text="Yes"/>
                    <Button method={onClose} text="No"/>
                </div>
            </div>
        </section>
    )
}

export default ConfirmationDialog;
