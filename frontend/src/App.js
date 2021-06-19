import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
} from 'react-router-dom';
import Header from './containers/Header';
import Home from './containers/Home';
import Footer from './containers/Footer';
import Books from "./modules/books/Books";
import Book from "./modules/books/Book";
import BooksProvider from "./modules/books/BooksProvider";

const App = () => (
    <React.Fragment>
        <BooksProvider>
            <Router>
                <Header />
                    <Home>
                    <Switch>
                            <Route exact path={["/add", "/edit/:id"]}>
                                <Book />
                            </Route>
                            <Route exact path="/">
                                <Books />
                            </Route>
                    </Switch>
                    </Home>
                <Footer />
            </Router>
        </BooksProvider>
    </React.Fragment>
)


export default App;
