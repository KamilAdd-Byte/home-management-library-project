import Button from "../../components/Button";

import './Book.css';

const Book = () => {
    const saveBook = () => {};
    return (
        <form>
            <input type="text" placeholder="Title" />
            <input type="text" placeholder="Author" />
            <input type="text" placeholder="Description" />
            <div className="form__button">
                <Button text="Save" method={saveBook} />
            </div>
        </form>
    )
}

export default Book;
