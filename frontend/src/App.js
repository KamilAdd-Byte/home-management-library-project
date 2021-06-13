import React from 'react';
import Header from './containers/Header';
import Home from './containers/Home';
import Footer from './containers/Footer';
import Books from "./modules/books/Books";

const App = () => (
    <React.Fragment>
        <Header />
        <Home>
            <Books />
        </Home>
        <Footer />
    </React.Fragment>
)


export default App;
