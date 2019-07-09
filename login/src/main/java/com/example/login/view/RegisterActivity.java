package com.example.login.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.login.R;
import com.example.login.viewmodel.RegisterViewModel;
import com.example.mvvmlibrary.base.BaseActivity;
import com.example.networkrequest.arouter.Constance;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

@Route(path = Constance.ACTIVITY_URL_REGISTER)
public class RegisterActivity extends BaseActivity<RegisterViewModel> {

    @Override
    protected RegisterViewModel getViewModel() {
        return ViewModelProviders.of(this).get(RegisterViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView tv_lr = ((TextView) findViewById(R.id.tv_register));
        tv_lr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(Constance.ACTIVITY_URL_LOGIN).navigation();
            }
        });

    }
}
