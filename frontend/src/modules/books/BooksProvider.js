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

    const deleteBook = (id) => {
        const newBooksList = books.filter(book => book.id !== id);
        setBooks(newBooksList)
    }

    const addBook = async (book) => {
        try {
            await fetch('http://localhost:8080/book', {
                method: 'POST',
                body: JSON.stringify(book)
            })

            setBooks([
                ...books,
                book
            ])
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
        totalCount: books.length
    }), [books])

    return (
        <BooksContext.Provider value={value}>
            {children}
        </BooksContext.Provider>
    )
}

export default BooksProvider;
