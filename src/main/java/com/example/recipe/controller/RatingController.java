package com.example.recipe.controller;

import com.example.recipe.model.Rating;
import com.example.recipe.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class RatingController {
    @Autowired
    RatingRepository repo;

    @PostMapping("/ratings")
    @ResponseStatus(HttpStatus.CREATED)
    public Rating addRating(@RequestBody @Valid Rating rating) {
        return repo.save(rating);
    }

    @GetMapping("/ratings/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Rating getRating(@PathVariable int id) {
        Optional<Rating> rating = repo.findById(id);

        if (rating.isPresent()) {
            return rating.get();
        } else {
            return null;
        }
    }

    @GetMapping("/ratings/recipe/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Rating> getRatingsByRecipe(@PathVariable int id) {
        return repo.findAllRatingsByRecipeId(id);
    }

    @PutMapping("/ratings")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRating(@RequestBody @Valid Rating rating) {
        repo.save(rating);
    }

    @DeleteMapping("/ratings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRating(@PathVariable int id) {
        repo.deleteById(id);
    }
}
