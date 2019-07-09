package com.example.login.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.login.R;
import com.example.login.R2;
import com.example.login.adapter.ChooseCompanyAdapter;
import com.example.login.model.RegisterCompanyEntity;
import com.example.login.viewmodel.ChooseCompanyViewModel;
import com.example.mvvmlibrary.base.BaseActivity;
import com.example.networkrequest.arouter.Constance;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@Route(path = Constance.ACTIVITY_URL_CHOOSE_COMPANY)
public class ChooseCompanyActivity extends BaseActivity<ChooseCompanyViewModel> {


    @BindView(R2.id.recyclerview)
    RecyclerView mRecyclerview;
    Unbinder unbinder;
    private ChooseCompanyAdapter mAdapter;
    private List<RegisterCompanyEntity> mList = new ArrayList<RegisterCompanyEntity>();

    @Override
    protected ChooseCompanyViewModel getViewModel() {
        return ViewModelProviders.of(this).get(ChooseCompanyViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_company);
        unbinder = ButterKnife.bind(this);
        initAdapter();
        initRequestData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void initRequestData() {
        viewModel.getCompanyList();
        viewModel.getCompany().observe(this, new Observer<List<RegisterCompanyEntity>>() {
            @Override
            public void onChanged(@Nullable List<RegisterCompanyEntity> registerCompanyEntities) {

                mList.clear();
                mList.addAll(registerCompanyEntities);
                Log.e("aaa", new Gson().toJson(registerCompanyEntities));
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initAdapter() {
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ChooseCompanyAdapter(mList);
        mRecyclerview.addOnItemTouchListener(new OnItemClickListener() {

            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

            }

        });
        mRecyclerview.setAdapter(mAdapter);
    }
}
