const Recipe = ({ recipe }) => {
    return (
        <tr key={recipe.recipeId}>
            <td>{recipe.title}</td>
            <td>{recipe.servings}</td>
            <td>{recipe.prepTime}</td>
            <td>{recipe.cookTime}</td>
            <td>{recipe.category}</td>
            <td>
                <button type="button">View/Edit Ingredients</button>
            </td>
        </tr>
    )
}

export default Recipe;