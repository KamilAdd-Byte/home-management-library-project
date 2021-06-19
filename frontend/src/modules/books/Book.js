import { withRouter } from 'react-router-dom';

import Button from "../../components/Button";

import './Book.css';
import React, {useContext, useState} from "react";
import {BooksContext} from "./BooksProvider";

const Book = ({history}) => {
    const {addBook} = useContext(BooksContext)

    const [book, setBook] = useState({
        title: '',
        author: '',
        description: '',
        status: 'AVAILABLE'
    });

    const handleChange = (e) => {
        const name = e.target.name;
        setBook({
            ...book,
            [name]: e.target.value
        })
    }

    const handleSave = () => {
        try{
            addBook(book);
            history.push('/')
        }catch(error) {
            console.log(error);
        }
    }

    return (
        <form>
            <input name="title" type="text" value={book.title} onChange={handleChange} placeholder="Title" />
            <input name="author" type="text" value={book.author} onChange={handleChange} placeholder="Author" />
            <input name="description" type="text" value={book.description} onChange={handleChange} placeholder="Description" />
            <div className="form__button">
                <Button text="Save" method={handleSave} />
            </div>
        </form>
    )
}

export default withRouter(Book)
