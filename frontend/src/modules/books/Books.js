import React, {useContext} from 'react';

import './Books.css';
import {BooksContext} from "./BooksProvider";
import Button from "../../components/Button";

const Books = () => {
    const {books} = useContext(BooksContext)

    const editBook = () => {};
    const deleteBook = () => {};

    return (
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Author</th>
                <th>Status</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            {books.map(book => (
                <tr key={book.id}>
                    <td>{book.id}</td>
                    <td>{book.title}</td>
                    <td>{book.author}</td>
                    <td>{book.status}</td>
                    <td>{book.description}</td>
                    <td>
                        <Button href={`/edit/${book.id}`} text="Edit" method={editBook} />
                        <Button text="Delete" method={deleteBook} />
                    </td>
                </tr>
            ))}

            </tbody>
        </table>
    )
}

export default Books;
