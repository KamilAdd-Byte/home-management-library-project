import {createContext, useEffect, useMemo, useState} from "react";

export const BooksContext = createContext({
    totalCount: 0,
    books: []
})

const BooksProvider = ({children}) => {
    const [books, setBooks] = useState([])
    const fetchBooks = () => {
        fetch('http://localhost:8080/books')
            .then(response => response.json())
            .then(data => console.log(data));
    }

    useEffect(() => {
        fetchBooks();
    }, [])

    const value = useMemo(() => ({
        books,
        setBooks,
        totalCount: books.length
    }), [books])

    return (
        <BooksContext.Provider value={value}>
            {children}
        </BooksContext.Provider>
    )
}

export default BooksProvider;
