package com.mateuyabar.android.cleanapp.presentation.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mateuyabar.android.cleanapp.R;
import com.mateuyabar.android.cleanapp.domain.models.Recipe;
import com.mateuyabar.android.cleanapp.presentation.navigation.Navigator;
import com.mateuyabar.android.cleanapp.presentation.presenters.RecipeListPresenter;
import com.mateuyabar.android.cleanapp.presentation.view.adapters.RecipeListAdapter;
import com.mateuyabar.android.cleanbase.presentation.presenters.Presenter;
import com.mateuyabar.android.cleanbase.presentation.view.fragments.PresenterFragment;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListRecipesFragment extends PresenterFragment implements RecipeListPresenter.ViewRenderer{
    @InjectView(R.id.list_view)
    ListView listView;

    RecipeListAdapter adapter;
    RecipeListPresenter presenter = new RecipeListPresenter();

    public static ListRecipesFragment getInstance(){
        return new ListRecipesFragment();
    }

    public ListRecipesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.recipes_list_layout, container, false);
        ButterKnife.inject(this, rootView);

        adapter = new RecipeListAdapter(getContext());
        listView.setAdapter(adapter);
        presenter.initialize(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.recipeClicked(adapter.getItem(position));
            }
        });

        return rootView;
    }

    @Override
    public void render(List<Recipe> recipieList) {
        adapter.addAll(recipieList);
    }

    @Override
    public void render(Recipe recipe) {
        new Navigator().show(getActivity(), recipe.getId());
    }

    @Override
    public Presenter getPresenter() {
        return presenter;
    }
}
