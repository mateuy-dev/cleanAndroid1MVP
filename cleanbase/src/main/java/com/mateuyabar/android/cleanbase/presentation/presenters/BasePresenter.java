package com.mateuyabar.android.cleanbase.presentation.presenters;

/**
 * Presenter that does not respond to anything. Use as a base.
 */
public class BasePresenter implements Presenter {
    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void destroy() {}
}
