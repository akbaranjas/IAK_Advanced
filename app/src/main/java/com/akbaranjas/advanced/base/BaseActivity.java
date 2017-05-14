package com.akbaranjas.advanced.base;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by akbaranjas on 13/05/17.
 */

public class BaseActivity extends AppCompatActivity {
    protected void bind(int layout){
        setContentView(layout);
        ButterKnife.bind(this);
    }

    protected void showToast(String msg){
        Toast.makeText(this, msg
                , Toast.LENGTH_SHORT).show();
    }

    protected void nextActivity(Context context){
    }
}
