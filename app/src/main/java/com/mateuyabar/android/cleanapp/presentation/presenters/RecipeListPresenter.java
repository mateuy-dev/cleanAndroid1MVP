package com.mateuyabar.android.cleanapp.presentation.presenters;


import com.mateuyabar.android.cleanapp.domain.models.Recipe;
import com.mateuyabar.android.cleanapp.domain.usecases.RecipeUseCases;
import com.mateuyabar.android.cleanbase.presentation.presenters.BasePresenter;

import java.util.List;

public class RecipeListPresenter  extends BasePresenter {
    ViewRenderer view;
    RecipeUseCases recipeUseCases = new RecipeUseCases();

    public void initialize(ViewRenderer view){
        this.view = view;
        loadRecipiesList();
    }

    private void loadRecipiesList(){
        view.render(recipeUseCases.getRecipes());
    }

    /**
     * Called by the view. It displays the recipie given.
     * @param recipe
     */
    public void displayRecipe(Recipe recipe){
        view.render(recipe);
    }

    public interface ViewRenderer{
        /**
         * Renders the list to the screen
         * @param recipeList
         */
        public void render(List<Recipe> recipeList);

        /**
         * Renders a single recipie detail view (or performs navigation)
         * @param recipe
         */
        public void render(Recipe recipe);
    }
}
