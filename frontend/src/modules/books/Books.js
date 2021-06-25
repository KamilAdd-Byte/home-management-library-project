import React, {useContext, useEffect, useState} from 'react';

import './Books.css';
import {BooksContext} from "./BooksProvider";
import Button from "../../components/Button";
import ConfirmationDialog from "../../components/ConfirmationDialog";
import Search from "../../components/Search";
import Categories from "../../components/Categories";

const Books = () => {
    const {books, fetchBooks, borrowBook, returnBook, sortColumn, deleteBook} = useContext(BooksContext)
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

    const setStatusColor = (status) => status === 'AVAILABLE' ? 'status__available' : 'status__notAvailable';

    return (
        <>
            <div className="books__filters">
                <Search />
                <Categories />
            </div>
            <table>
                <thead>
                <tr>
                    <th onClick={() => onSort('id')}>
                        Id
                        <img alt="id" src={process.env.PUBLIC_URL + '/sortDown.svg'} />
                    </th>
                    <th onClick={() => onSort('title')}>
                        Title
                        <img alt="title" src={process.env.PUBLIC_URL + '/sortDown.svg'} />
                    </th>
                    <th onClick={() => onSort('author')}>
                        Author
                        <img alt="author" src={process.env.PUBLIC_URL + '/sortDown.svg'} />
                    </th>
                    <th onClick={() => onSort('status')}>
                        Status
                        <img alt="status" src={process.env.PUBLIC_URL + '/sortDown.svg'} />
                    </th>
                    <th onClick={() => onSort('description')}>
                        Description
                        <img alt="description" src={process.env.PUBLIC_URL + '/sortDown.svg'} />
                    </th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {books.map(book => (
                    <tr key={book.id}>
                        <td>{book.id}</td>
                        <td>{book.title}</td>
                        <td>{book.author}</td>
                        <td className={setStatusColor(book.status)}>{book.status}</td>
                        <td>{book.description}</td>
                        <td>
                            {book.status ==='AVAILABLE' ?
                                <Button text="Borrow" method={() => borrowBook(book.id)}/> :
                                <Button text="Return" method={() => returnBook(book.id)}/>
                            }
                            <Button href={`/edit/${book.id}`} text="Edit" />
                            <Button text="Delete" method={() => onDelete(book.id)} />
                        </td>
                    </tr>
                ))}

                </tbody>
            </table>
            <ConfirmationDialog
                text="Are you sure to delete this book?"
                method={onModalConfirm}
                showState={isModalVisible}
                onClose={onModalClose}
            />
        </>
    )
}

export default Books;
