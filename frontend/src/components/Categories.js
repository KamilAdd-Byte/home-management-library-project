import './Categories.css';
import {useContext, useEffect} from "react";
import {CategoriesContext} from "../modules/categories/CategoriesProvider";

const Categories = () => {
    const {categories, fetchCategories} = useContext(CategoriesContext);

    useEffect(() => {
        fetchCategories();
    }, []);

    return (
        <div className="categories__handler">
            <label>Categories</label>
            <select>
                {categories.map(category => (<option value={category.name}>{category.name}</option>))}
            </select>
        </div>

    )
}

export default Categories;
