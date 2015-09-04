package com.mateuyabar.android.cleanapp.presentation.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.mateuyabar.android.cleanapp.R;
import com.mateuyabar.android.cleanapp.presentation.view.fragments.ShowRecipeDetailFragment;

/**
 * Created by mateuyabar on 3/09/15.
 */
public class Navigator {
    public void show(FragmentActivity activity, int recipeId){
        Fragment fragment = ShowRecipeDetailFragment.getInstance(recipeId);
        changeFragment(activity, fragment);
    }

    public void changeFragment(FragmentActivity activity, Fragment newFragment){
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment).commit();//addToBackStack(null).
    }
}
