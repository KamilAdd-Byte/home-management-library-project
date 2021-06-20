import React, {useContext, useEffect, useState} from 'react';

import './Books.css';
import {BooksContext} from "./BooksProvider";
import Button from "../../components/Button";
import ConfirmationDialog from "../../components/ConfirmationDialog";

const Books = () => {
    const {books, fetchBooks, sortColumn, deleteBook} = useContext(BooksContext)
    const [bookToRemove, setBookToRemove] = useState(null);
    const [isModalVisible, setIsModalVisible] = useState(false);

    const onDelete = (id) => {
        setBookToRemove(id);
        setIsModalVisible(true);
    }

    useEffect(() => {
        fetchBooks();
    }, [])

    const onSort = (columnName) => sortColumn(columnName);

    const onModalConfirm = () => {
        deleteBook(bookToRemove);
        setIsModalVisible(false);
        setBookToRemove(null);
    }

    const onModalClose = () => {
        setIsModalVisible(false);
        setBookToRemove(null);
    }

    return (
        <>
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
            <ConfirmationDialog
                text="Czy na pewno chcesz usunąć książkę?"
                method={onModalConfirm}
                showState={isModalVisible}
                onClose={onModalClose}
            />
        </>
    )
}

export default Books;
