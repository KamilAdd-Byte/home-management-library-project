import React from 'react';

import './Button.css';
import {Link} from "react-router-dom";

const Button = ({text, method, href = null}) => (
    <button
        type="button"
        onClick={method}
        className="button"
    >
        {href ? (
            <Link to={href} >
                {text}
            </Link>
        ) : text}

    </button>
)

export default Button;
