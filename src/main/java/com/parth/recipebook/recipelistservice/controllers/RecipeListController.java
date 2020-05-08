package com.parth.recipebook.recipelistservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parth.recipebook.recipelistservice.models.UserRecipeList;
import com.parth.recipebook.recipelistservice.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeListController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/recipes/{userId}")
    public ResponseEntity<?> getRecipes(@PathVariable("userId") String userId){
        if(userId == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Request require a valid user Id");
        }
        else {
            try{
                UserRecipeList userRecipeList = this.recipeService.getRecipeList(userId);
                if(userRecipeList == null){
                    return ResponseEntity
                            .status(HttpStatus.OK)
                            .body("Recipes not found");
                }
                else {
                    return ResponseEntity
                            .status(HttpStatus.OK)
                            .body(mapper.writeValueAsString(userRecipeList));
                }
            }catch (Exception ex){
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error while parsing data.");
            }
        }
    }


    @RequestMapping(value = "/userIngredients", method = RequestMethod.POST)
    public ResponseEntity<?> getShoppingList(@RequestBody UserRecipeList userRecipeList){
        if(userRecipeList == null){
            return ResponseEntity.status(HttpStatus.OK).body("Nothing to save");
        }
        this.recipeService.saveUserRecipeList(userRecipeList);
        return ResponseEntity.status(HttpStatus.OK).body("Recipe list saved for " + userRecipeList.getUserId());
    }
}
