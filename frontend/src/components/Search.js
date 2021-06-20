import React, {useContext} from "react";
import {BooksContext} from "../modules/books/BooksProvider";

import './Search.css';

const Search = () => {
    const {filterByName}  = useContext(BooksContext)


    return (
        <div className="search__handler">
            <label htmlFor="searchField">Search book by title</label>
            <input id="searchField" placeholder="type at least 3 letters..." type="text" onChange={(e) =>  filterByName(e.target.value)} />
        </div>
    )
}

export default Search;
