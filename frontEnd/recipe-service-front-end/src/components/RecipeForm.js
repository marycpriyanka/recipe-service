import { useState } from "react";

const RecipeForm = ({ showForm }) => {
    const [recipe, setRecipe] = useState({title: "", servings: 0, prepTime: "", cookTime: "", category: ""});

    const handleChange = (event) => {
        const clone = { ...recipe };
        clone[event.target.name] = event.target.value;
        setRecipe(clone);
    }

    const handleSubmit = (event) => {
        event.preventDefault();

        const init = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json",
            },
            body: JSON.stringify(recipe)
        };

        fetch("http://localhost:8080/recipes", init)
            .then(response => response.json())
            .then(result => {
                console.log(result);
            })
            .catch(err => console.log(err));
    }

    return (
        <div>
            <h1>Add Recipe</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="title">Title</label>
                    <input type="text" id="title" name="title" value={recipe.title} onChange={handleChange}></input>
                </div>
                <div>
                    <label htmlFor="servings">Servings</label>
                    <input type="number" id="servings" name="servings" value={recipe.servings} onChange={handleChange}></input>
                </div>
                <div>
                    <label htmlFor="prepTime">Preparation Time</label>
                    <input type="text" id="prepTime" name="prepTime" value={recipe.prepTime} onChange={handleChange}></input>
                </div>
                <div>
                    <label htmlFor="cookTime">Cooking Time</label>
                    <input type="text" id="cookTime" name="cookTime" value={recipe.cookTime} onChange={handleChange}></input>
                </div>
                <div>
                    <label htmlFor="category">Category</label>
                    <input type="text" id="category" name="category" value={recipe.category} onChange={handleChange}></input>
                </div>
                <div>
                    <button type="submit">Add</button>
                    <button type="button">Cancel</button>
                </div>
            </form>
        </div>
    );
};

export default RecipeForm;