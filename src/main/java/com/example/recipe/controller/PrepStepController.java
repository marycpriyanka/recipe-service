package com.example.recipe.controller;

import com.example.recipe.model.PrepStep;
import com.example.recipe.repository.PrepStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PrepStepController {

    @Autowired
    PrepStepRepository repo;

    @PostMapping("/prepsteps")
    @ResponseStatus(HttpStatus.CREATED)
    public PrepStep addPrepStep(@RequestBody @Valid PrepStep prepStep) {
        return repo.save(prepStep);
    }

    @GetMapping("/prepsteps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PrepStep getPrepStep(@PathVariable int id) {
        Optional<PrepStep> prepStep = repo.findById(id);

        if (prepStep.isPresent()) {
            return prepStep.get();
        } else {
            return null;
        }
    }

    @GetMapping("/prepsteps/recipe/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<PrepStep> getPrepStepsByRecipe(@PathVariable int id) {
        return repo.findAllPrepStepsByRecipeId(id);
    }

    @PutMapping("/prepsteps")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePrepStep(@RequestBody @Valid PrepStep prepStep) {
        repo.save(prepStep);
    }

    @DeleteMapping("/prepsteps/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePrepStep(@PathVariable int id) {
        repo.deleteById(id);
    }
}
