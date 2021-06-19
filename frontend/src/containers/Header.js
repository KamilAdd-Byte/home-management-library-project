import React from 'react';

import './Header.css';
import Button from "../components/Button";
import {Link} from "react-router-dom";

const Header = () => {

        const addBook = () => {};

        return (
            <header>
                    <div className="header__main">
                            <img alt="logo" src={process.env.PUBLIC_URL + '/logo.png'} />
                            <Link to="/">Home Management Library Project</Link>
                    </div>
                    <Button href="/add" text="Add book" method={addBook} />
            </header>)
}

export default Header
