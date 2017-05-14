package com.akbaranjas.advanced;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.akbaranjas.advanced.base.BaseActivity;
import com.akbaranjas.advanced.presenter.splash.SplashPresenter;
import com.akbaranjas.advanced.presenter.splash.SplashPresenterImp;
import com.akbaranjas.advanced.view.splash.SplashView;

public class SplashActivity extends BaseActivity implements SplashView {

    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_splash);
        splashPresenter = new SplashPresenterImp(this);
        splashPresenter.waitSplash(5000);
    }

    @Override
    public void showAlert() {
        showToast("Hai," +
                " Selamat Datang");
    }

    @Override
    public void openMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
