import { withRouter } from 'react-router-dom';

import Button from "../../components/Button";

import './Book.css';
import React, {useContext, useEffect, useState} from "react";
import {BooksContext} from "./BooksProvider";

const Book = ({history, match}) => {
    const {addBook, editBook, getBook} = useContext(BooksContext)

    const [book, setBook] = useState({
        title: '',
        author: '',
        description: '',
        status: 'AVAILABLE'
    });

    const fetchBook = async () => {
        const fetchedBook = await getBook(match.params.id);
        setBook(fetchedBook);
        return fetchedBook;
    }

    useEffect(() => {
        if(match.params.id){
            fetchBook();
        }
    }, [])

    const handleChange = (e) => {
        const name = e.target.name;
        setBook({
            ...book,
            [name]: e.target.value
        })
    }

    const handleSave = () => {
        try{
            // if(match.params.id){
            //     editBook(book)
            // }else{
                addBook(book);
            // }
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
