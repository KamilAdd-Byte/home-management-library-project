import Button from "../../components/Button";

import './Book.css';
import {useContext, useState} from "react";
import {BooksContext} from "./BooksProvider";

const Book = () => {
    const {addBook} = useContext(BooksContext)

    const [book, setBook] = useState({
        title: '',
        author: '',
        description: ''
    });

    const handleChange = (e) => {
        const name = e.target.name;
        setBook({
            ...book,
            [name]: e.target.value
        })

    }

    return (
        <form>
            <input name="title" type="text" value={book.title} onChange={handleChange} placeholder="Title" />
            <input name="author" type="text" value={book.author} onChange={handleChange} placeholder="Author" />
            <input name="description" type="text" value={book.description} onChange={handleChange} placeholder="Description" />
            <div className="form__button">
                <Button text="Save" method={() => addBook(book)} />
            </div>
        </form>
    )
}

export default Book;
