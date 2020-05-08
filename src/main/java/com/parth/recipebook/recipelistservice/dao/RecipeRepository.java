package com.parth.recipebook.recipelistservice.dao;

import com.parth.recipebook.recipelistservice.models.UserRecipeList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends MongoRepository<UserRecipeList, String> {

    UserRecipeList findByUserId(String userId);
}
