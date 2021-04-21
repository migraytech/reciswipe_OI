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

import static com.reciswipe.recipe.helpers.Logger.log;


@RequestMapping(name = "/recipe")
@RestController
public class RecipeController extends AbstractController {


    @Autowired
    public RecipeService recipeService;

    @Autowired
    public RecipeValidator recipeValidator;

   //TODO
   // create endsPoints for this service get the all recipes,  update recipe, delete recipes and create recipes.

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
                    result.setMessage("recipe is created successfully");
                    return new ResponseEntity<>(result, HttpStatus.OK);
                } else {
                    result.setResult(false);
                    result.setMessage("Failed creating this recipe.");
                    result.setErrorCode(ErrorCode.FAILED_CREATING_RECIPE);
                    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
                }
            }
        }
        catch (Exception exception){
            return new ResponseEntity<>(handlerMessageException(exception,HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(handlerMessageException(new Exception(),HttpStatus.EXPECTATION_FAILED), HttpStatus.EXPECTATION_FAILED);
    }
//    @GetMapping(value = "/get-recipe", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<JsonResult> readRecipe(){
//        log(getClass(),"Start to read all Recipes ./n ");
//
//        try {
//
//        }
//        catch (Exception exception){
//            return new ResponseEntity<>(handlerMessageException(exception,HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(handlerMessageException(new Exception(),HttpStatus.EXPECTATION_FAILED), HttpStatus.EXPECTATION_FAILED);
//    }

//    @DeleteMapping(value = "/delete-recipe", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<JsonResult> deleteRecipe(@RequestBody String json){
//        log(getClass(),"Start to delete Recipe ./n ");
//        try {
//           ///
//
//        }
//        catch (Exception exception){
//            return new ResponseEntity<>(handlerMessageException(exception,HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(handlerMessageException(new Exception(),HttpStatus.EXPECTATION_FAILED), HttpStatus.EXPECTATION_FAILED);
//    }






    //TODO
    // RabbitMQ opzetten met de auth op het moment wanneer de user is ingelogd.


    //TODO
    // Create new class or microservice that contains his favorite recipes.
}
