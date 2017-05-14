package com.akbaranjas.advanced.presenter.splash;

import android.os.Handler;

import com.akbaranjas.advanced.view.splash.SplashView;

/**
 * Created by akbaranjas on 13/05/17.
 */

public class SplashPresenterImp implements SplashPresenter{

    SplashView view;

    public SplashPresenterImp(SplashView view) {
        this.view = view;
    }

    @Override
    public void waitSplash(int duration) {
        new Handler().postDelayed(() -> {
            view.showAlert();
            view.openMain();
        }, duration);

    }
}
