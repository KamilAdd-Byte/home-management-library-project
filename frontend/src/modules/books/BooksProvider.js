import {createContext, useMemo, useState} from "react";

export const BooksContext = createContext({
    totalCount: 0,
    books: []
})

const BooksProvider = ({children}) => {
    const [books, setBooks] = useState([])
    const [initialBooks, setInitialBooks] = useState([])
    const fetchBooks = async () => {
        const response = await fetch('https://react-app-spio.herokuapp.com/books');
        const books = await response.json();
        setBooks(books)
        setInitialBooks(books);
    }

    const getBook = async (id) => {
        const response = await fetch(`https://react-app-spio.herokuapp.com/books/${id}`);
        return await response.json();
    }

    const deleteBook = async (id) => {
        const newBooksList = books.filter(book => book.id !== id);

        try {
            await fetch(`https://react-app-spio.herokuapp.com/books/${id}`, {
                method: 'DELETE',
            })
            setBooks(newBooksList);
            setInitialBooks(books);
        } catch (error) {
            console.log(error);
        }
    }

    const addBook = async (book) => {
        try {
            const response = await fetch('https://react-app-spio.herokuapp.com/book', {
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

            setInitialBooks(books);
        } catch(error){
            console.log(error);
        }
    }

    const editBook = async (book) => {
        const index = books.map(book => book.id).indexOf(book.id);

        try {

            const response = await fetch(`https://react-app-spio.herokuapp.com/book`, {

                method: 'PUT',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(book)
            })
            const newBook = await response.json();
            const deepCopy = JSON.parse(JSON.stringify(books));

            deepCopy[index] = newBook;

            setBooks(deepCopy);

            setInitialBooks(books);
        } catch(error){
            console.log(error);
        }
    }

    const sortBooksByColumn = (columnName) => {
        const deepCopy = JSON.parse(JSON.stringify(books));
        setBooks([]);
        const sorted =  deepCopy.sort((a, b) => a[columnName] > b[columnName] ? 1 : -1)

        setBooks(sorted);
    }

    const filterByName = (value) => {
        const deepCopy = JSON.parse(JSON.stringify(books));

        if(value.length > 3){
            setBooks(deepCopy.filter(book => book.title.includes(value)))
        }else{
            setBooks(initialBooks);
        }
    }

    const borrowBook = async (id) => {
        try {
            const response = await fetch(`https://react-app-spio.herokuapp.com/book/${id}/borrowed`, {
                method: 'PUT',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({firsName: 'Jan', lastName: 'Kowalski'})
            })
            const newBook = await response.json();

            window.location.reload();

            console.log(newBook);
        } catch(error){
            console.log(error);
        }
    }

    const returnBook = async (id) => {
        try {
            const response = await fetch(`https://react-app-spio.herokuapp.com/book/${id}/available`, {
                method: 'PUT',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({firsName: 'Jan', lastName: 'Kowalski'})
            })
            const newBook = await response.json();

            window.location.reload();

            console.log(newBook);
        } catch(error){
            console.log(error);
        }
    }


    const value = useMemo(() => ({
        books,
        setBooks,
        fetchBooks,
        getBook,
        addBook,
        editBook,
        deleteBook,
        filterByName,
        borrowBook,
        returnBook,
        sortColumn: sortBooksByColumn,
        totalCount: books.length
    }), [books])

    return (
        <BooksContext.Provider value={value}>
            {children}
        </BooksContext.Provider>
    )
}

export default BooksProvider;
