import React, {createContext, useMemo, useState} from 'react'

export const CategoriesContext = createContext({
    categories: []
})

const CategoriesProvider = ({children}) => {
    const [categories, setCategories] = useState([])

    const fetchCategories = async () => {
        const response = await fetch('https://react-app-spio.herokuapp.com/categories');
        const fetchedCategories = await response.json();
        setCategories(fetchedCategories)
    }

    const value = useMemo(() => ({
        categories,
        setCategories,
        fetchCategories,
    }), [categories])

    return (
        <CategoriesContext.Provider value={value}>
            {children}
        </CategoriesContext.Provider>
    )
}

export default CategoriesProvider;
