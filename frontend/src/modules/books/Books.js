import React, {useContext, useEffect} from 'react';

import './Books.css';
import {BooksContext} from "./BooksProvider";
import Button from "../../components/Button";

const Books = () => {
    const {books, fetchBooks, sortColumn, deleteBook} = useContext(BooksContext)

    const onDelete = (id) => deleteBook(id);

    useEffect(() => {
        fetchBooks();
    }, [])

    const onSort = (columnName) => sortColumn(columnName);

    return (
        <table>
            <thead>
            <tr>
                <th onClick={() => onSort('id')}>Id</th>
                <th onClick={() => onSort('title')}>Title</th>
                <th onClick={() => onSort('author')}>Author</th>
                <th onClick={() => onSort('status')}>Status</th>
                <th onClick={() => onSort('description')}>Description</th>
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
                        <Button href={`/edit/${book.id}`} text="Edit" />
                        <Button text="Delete" method={() => onDelete(book.id)} />
                    </td>
                </tr>
            ))}

            </tbody>
        </table>
    )
}

export default Books;
