package com.mateuyabar.android.cleanapp.presentation.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mateuyabar.android.cleanapp.R;
import com.mateuyabar.android.cleanapp.domain.models.Recipe;
import com.mateuyabar.android.cleanapp.presentation.presenters.ShowRecipeDetailPresenter;
import com.mateuyabar.android.cleanapp.presentation.view.adapters.RecipeListAdapter;
import com.mateuyabar.android.cleanbase.presentation.presenters.Presenter;
import com.mateuyabar.android.cleanbase.presentation.view.fragments.PresenterFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShowRecipeDetailFragment extends PresenterFragment implements ShowRecipeDetailPresenter.ViewRenderer {
    public static final String RECIPE_ID = "recipe_id";

    @InjectView(R.id.recipe_title)
    TextView recipeTitle;

    RecipeListAdapter adapter;
    ShowRecipeDetailPresenter presenter = new ShowRecipeDetailPresenter();

    public static ShowRecipeDetailFragment getInstance(int recipeId){
        ShowRecipeDetailFragment result = new ShowRecipeDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(RECIPE_ID, recipeId);
        result.setArguments(bundle);
        return result;
    }

    public ShowRecipeDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.recipe_detail_layout, container, false);
        ButterKnife.inject(this, rootView);

        int recipeId = getArguments().getInt(RECIPE_ID);

        presenter.initialize(this, recipeId);

        return rootView;
    }

    @Override
    public void render(Recipe recipe) {
        recipeTitle.setText(recipe.getName());
    }

    @Override
    public Presenter getPresenter() {
        return presenter;
    }
}
