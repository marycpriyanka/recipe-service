package com.example.recipe.controller;

import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {
    @Autowired
    RecipeRepository recipeRepo;

    @PostMapping("/recipes")
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe addRecipe(@RequestBody @Valid Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    @GetMapping("/recipes")
    @ResponseStatus(HttpStatus.OK)
    public List<Recipe> getAllRecipes() {
        return recipeRepo.findAll();
    }

    @GetMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Recipe getRecipe(@PathVariable int id) {
        Optional<Recipe> recipe = recipeRepo.findById(id);

        if (recipe.isPresent()) {
            return recipe.get();
        } else {
            return null;
        }
    }

    @GetMapping("/recipes/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<Recipe> getRecipesByCategory(@PathVariable String category) {
        return recipeRepo.findAllRecipesByCategory(category);
    }

    @PutMapping("/recipes")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRecipe(@RequestBody @Valid Recipe recipe) {
        recipeRepo.save(recipe);
    }

    @DeleteMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable int id) {
        recipeRepo.deleteById(id);
    }
}
