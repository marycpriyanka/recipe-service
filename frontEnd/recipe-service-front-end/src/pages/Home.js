import { useEffect, useState } from "react";
import Recipe from "../components/Recipe";
import RecipeForm from "../components/RecipeForm";

const Home = () => {
    const [recipes, setRecipes] = useState([]);
    const [showForm, setShowForm] = useState(false);

    useEffect(() => {
        getAllRecipes();
    }) 

    const getAllRecipes= () => {
        fetch("http://localhost:8080/recipes")
            .then((response) => response.json())
            .then((result) => setRecipes(result))
            .catch((err) => console.log(err));
    }

    const handleAddRecipe = (event) => {
        setShowForm(true);
    }

    if (showForm) {
        return <RecipeForm></RecipeForm>;
    }

    return (
        <div>
            <h1>Recipes</h1>
            <button type="button" onClick={handleAddRecipe}>Add Recipe</button>

            <table>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Servings</th>
                        <th>Preparation Time</th>
                        <th>Cooking Time</th>
                        <th>Category</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {recipes.map((recipe) => (
                        <Recipe key={recipe.recipeId} recipe={recipe}></Recipe>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default Home;