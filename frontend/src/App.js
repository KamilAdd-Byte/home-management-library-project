import React from 'react';
import Header from './containers/Header';
import Home from './containers/Home';
import Footer from './containers/Footer';

const App = () => (
    <React.Fragment>
        <Header />
        <Home>
            Hello Home
        </Home>
        <Footer />
    </React.Fragment>
)


export default App;
