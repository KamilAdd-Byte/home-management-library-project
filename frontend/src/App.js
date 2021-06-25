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
import CategoriesProvider from "./modules/categories/CategoriesProvider";

const App = () => (
    <React.Fragment>
        {/* <CategoriesProvider> */}
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
        {/* </CategoriesProvider> */}
    </React.Fragment>
)


export default App;
