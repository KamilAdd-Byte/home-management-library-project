import React from 'react';

import './Header.css';

const Header = () => (
    <header>
        <img alt="logo" src={process.env.PUBLIC_URL + '/logo.png'} />
        <a href="/">Home Management Library Project</a>
    </header>
)

export default Header
