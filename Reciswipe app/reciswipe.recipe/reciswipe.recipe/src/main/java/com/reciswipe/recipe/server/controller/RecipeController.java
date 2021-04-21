package com.reciswipe.recipe.server.controller;

import com.reciswipe.recipe.IntegrationTesting.service.RecipeService;
import com.reciswipe.recipe.helpers.ErrorCode;
import com.reciswipe.recipe.helpers.JsonLogic;
import com.reciswipe.recipe.helpers.JsonResult;
import com.reciswipe.recipe.server.domain.Recipe;
import com.reciswipe.recipe.validator.RecipeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.reciswipe.recipe.helpers.Logger.log;


@RequestMapping(name = "/recipe")
@RestController
public class RecipeController extends AbstractController {


    @Autowired
    public RecipeService recipeService;

    @Autowired
    public RecipeValidator recipeValidator;

    @Override
    public JsonResult handlerMessageException(Exception e, HttpStatus httpStatus) {
        return super.handlerMessageException(e, httpStatus);
    }
    @PostMapping(value = "/create-recipe", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonResult> createRecipe(@RequestBody String json){
        log(getClass(),"Start to create Recipe ./n ");
        try {
            Recipe recipe = (Recipe) JsonLogic.getObject(Recipe.class, json);
            if((recipeValidator.validRecipe(recipe))) {
                Recipe createdRecipe = recipeService.create(recipe);
                if (createdRecipe != null) {
                    result.setResult(true);
                    result.setItem(createdRecipe);
                    result.setMessage("recipe is created successfully...");
                    return new ResponseEntity<>(result, HttpStatus.OK);
                } else {
                    result.setResult(false);
                    result.setMessage("Failed creating this recipe...");
                    result.setErrorCode(ErrorCode.FAILED_CREATING_RECIPE);
                    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
                }
            }
            log(getClass(), "Failed create the Recipe......");
            return new ResponseEntity<>(handlerMessageException(new Exception(),HttpStatus.EXPECTATION_FAILED), HttpStatus.EXPECTATION_FAILED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(handlerMessageException(exception,HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping(value = "/get-recipe", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonResult> readAllRecipe() {
        log(getClass(), "Start to read all Recipes ./n ");
        try {
            List<Recipe> recipeList = recipeService.read();
            if(!recipeList.isEmpty()) {
                result.setResult(true);
                return new ResponseEntity<>(result,HttpStatus.OK);
            }
            else {
                result.setResult(false);
                result.setMessage("Failed to get a profile.");
                result.setErrorCode(ErrorCode.FAILED_GET_ALL_RECIPES);
                return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception exception) {
            log(getClass(), "Failed getting the recipes......");
            return new ResponseEntity<>(handlerMessageException(exception, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
     }

    @PutMapping(value = "/update-recipe", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonResult> updateProfile(@RequestBody String json) {

        log(getClass(), "Update the Profile....");
        try {
            Recipe recipe = (Recipe) JsonLogic.getObject(Recipe.class, json);
            if (recipeValidator.validRecipe(recipe)) {
                Recipe updatedProfile = recipeService.update(recipe);
                if (updatedProfile != null) {
                    result.setResult(true);
                    result.setItem(updatedProfile);
                    result.setMessage("Recipe is successfully updated");
                    return new ResponseEntity<>(result, HttpStatus.OK);
                } else {
                    result.setResult(false);
                    result.setMessage("Failed update this recipe.");
                    result.setErrorCode(ErrorCode.FAILED_UPDATE_RECIPE);
                    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
                }
            }
            log(getClass(), "Failed update this recipe......");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

        }   catch (Exception exception){
            return new ResponseEntity<>(handlerMessageException(exception,HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping(value = "/delete-recipe", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonResult> deleteRecipe(@RequestBody String json){
        log(getClass(),"Start to delete Recipe ./n ");
        try {
            Recipe recipe = (Recipe) JsonLogic.getObject(getClass(),json);
            if(recipeService.delete(recipe)) {
                result.setResult(true);
                return new ResponseEntity<>(result,HttpStatus.OK);
            }
            else{
                result.setResult(false);
                result.setMessage("Failed to get a profile.");
                result.setErrorCode(ErrorCode.FAILED_GET_ALL_RECIPES);
                return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception exception){
            return new ResponseEntity<>(handlerMessageException(exception,HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
        }
    }



    //TODO
    // RabbitMQ opzetten met de auth op het moment wanneer de user is ingelogd.


    //TODO
    // Create new class or microservice that contains his favorite recipes.
}
