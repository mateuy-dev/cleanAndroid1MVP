package com.mateuyabar.android.cleanapp.presentation.presenters;

import com.mateuyabar.android.cleanapp.domain.models.Recipe;
import com.mateuyabar.android.cleanapp.domain.usecases.RecipeUseCases;
import com.mateuyabar.android.cleanbase.presentation.presenters.Presenter;


public class ShowRecipeDetailPresenter implements Presenter{
    ViewRenderer view;
    int recipeId;
    RecipeUseCases recipeUseCases = new RecipeUseCases();


    public void initialize(ViewRenderer view, int recipeId){
        this.view = view;
        this.recipeId = recipeId;
        loadRecipe();
    }

    private void loadRecipe() {
        Recipe recipe = recipeUseCases.getRecipe(recipeId);
        view.render(recipe);
    }


    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void destroy() {
    }

    public static interface ViewRenderer {
        public void render(Recipe recipie);
    }
}
