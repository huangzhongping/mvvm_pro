package com.example.main.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.main.R;
import com.example.main.event.MainEvent;
import com.example.main.viewmodel.MainViewModel;
import com.example.mvvmlibrary.base.BaseActivity;
import com.example.mvvmlibrary.base.BaseViewModel;
import com.example.mvvmlibrary.widget.loadingdrawable.LoadingDialog;
import com.example.networkrequest.arouter.Constance;
import com.example.networkrequest.liveeventbus.LiveEventBus;

@Route(path = Constance.ACTIVITY_URL_MAIN)
public class MainActivity extends BaseActivity<MainViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARouter.getInstance().inject(this);

        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getUserInfo("17521316212");
//                ARouter.getInstance().build(Constance.ACTIVITY_URL_SECOND).navigation();
            }
        });


        viewModel.getBooleanMutableLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                btn1.setText("Boolean");
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(Constance.ACTIVITY_URL_LOGIN).navigation();
            }
        });
    }

    @Override
    protected MainViewModel getViewModel() {
        return ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);
    }

}
