package com.parth.recipebook.recipelistservice.services;

import com.parth.recipebook.recipelistservice.dao.RecipeRepository;
import com.parth.recipebook.recipelistservice.models.UserRecipeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public UserRecipeList getRecipeList(String userId){
        return this.recipeRepository.findByUserId(userId);
    }

    public void saveUserRecipeList(UserRecipeList userRecipeList) {
    }
}
