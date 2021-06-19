import {createContext, useEffect, useMemo, useState} from "react";

export const BooksContext = createContext({
    totalCount: 0,
    books: []
})

const BooksProvider = ({children}) => {
    const [books, setBooks] = useState([])
    const fetchBooks = async () => {
        const response = await fetch('http://localhost:8080/books');
        const books = await response.json();
        setBooks(books)
    }

    const deleteBook = async (id) => {
        const newBooksList = books.filter(book => book.id !== id);

        try {
            await fetch(`http://localhost:8080/books/${id}`, {
                method: 'DELETE',
            })
            setBooks(newBooksList)
        } catch (error) {
            console.log(error);
        }
    }

    const addBook = async (book) => {
        try {
            const response = await fetch('http://localhost:8080/book', {
                method: 'POST',
                body: JSON.stringify(book),
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json'
                }
            })
            const newBook = await response.json();


            setBooks([
                ...books,
                newBook
            ])
        } catch(error){
            console.log(error);
        }
    }

    const editBook = async (book) => {
        const index = books.map(book => book.id).indexOf(book.id);
        const deepCopy = JSON.parse(JSON.stringify(books));
        deepCopy[index] = book;
        try {
            await fetch(`http://localhost:8080/books/${book.id}`, {
                method: 'PUT',
                body: JSON.stringify(book)
            })

            setBooks(deepCopy)
        } catch(error){
            console.log(error);
        }
    }

    useEffect(() => {
        fetchBooks();
    }, [])

    const value = useMemo(() => ({
        books,
        setBooks,
        addBook,
        editBook,
        deleteBook,
        totalCount: books.length
    }), [books])

    return (
        <BooksContext.Provider value={value}>
            {children}
        </BooksContext.Provider>
    )
}

export default BooksProvider;
