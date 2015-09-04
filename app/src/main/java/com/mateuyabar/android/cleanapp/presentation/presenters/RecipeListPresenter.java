package com.mateuyabar.android.cleanapp.presentation.presenters;


import com.mateuyabar.android.cleanapp.domain.models.Recipe;
import com.mateuyabar.android.cleanapp.domain.usecases.RecipeUseCases;
import com.mateuyabar.android.cleanbase.presentation.presenters.Presenter;

import java.util.List;

public class RecipeListPresenter  implements Presenter{
    ViewRenderer view;
    RecipeUseCases recipeUseCases = new RecipeUseCases();

    public void initialize(ViewRenderer view){
        this.view = view;
        loadRecipiesList();
    }

    private void loadRecipiesList(){
        view.render(recipeUseCases.getRecipes());
    }

    public void recipeClicked(Recipe recipe){
        view.render(recipe);
    }

    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void destroy() {}

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
