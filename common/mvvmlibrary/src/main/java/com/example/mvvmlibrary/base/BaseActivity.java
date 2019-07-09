package com.example.mvvmlibrary.base;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mvvmlibrary.R;
import com.example.mvvmlibrary.observer.ActivityLifecycleObserver;
import com.example.mvvmlibrary.widget.loading.ProgressLoadingDialog;
import com.example.mvvmlibrary.widget.loadingdrawable.LoadingDialog;
import com.example.networkrequest.base.BaseActionEvent;
import com.example.networkrequest.utils.ToastUtil;
import com.example.networkrequest.utils.status.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {

    protected T viewModel;

    protected abstract T getViewModel();

    public LoadingDialog loadingDialog = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (viewModel == null) {
            viewModel = getViewModel();
        }
        initViewModelEvent();
        getLifecycle().addObserver(new ActivityLifecycleObserver(getApplicationContext()));
        StatusBarUtil.setWindowStatusBarColor(BaseActivity.this, R.color.white);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    protected List<ViewModel> initViewModelList() {
        return null;
    }

    private void initViewModelEvent() {
        List<ViewModel> viewModelList = initViewModelList();
        if (viewModelList != null && viewModelList.size() > 0) {
            observeEvent(viewModelList);
        } else {
            viewModel = getViewModel();
            if (viewModel != null) {
                List<ViewModel> modelList = new ArrayList<>();
                modelList.add(viewModel);
                observeEvent(modelList);
            }
        }
    }

    private void observeEvent(List<ViewModel> viewModelList) {
        for (ViewModel viewModel : viewModelList) {
            if (viewModel instanceof IViewModelAction) {
                IViewModelAction viewModelAction = (IViewModelAction) viewModel;
                viewModelAction.getActionLiveData().observe(this, baseActionEvent -> {
                    if (baseActionEvent != null) {
                        switch (baseActionEvent.getAction()) {
                            case BaseActionEvent.SHOW_LOADING_DIALOG: {
                                showLoading();
                                break;
                            }
                            case BaseActionEvent.DISMISS_LOADING_DIALOG: {
                                dismissLoading();
                                break;
                            }
                            case BaseActionEvent.SHOW_TOAST: {
                                ToastUtil.showToast(baseActionEvent.getMessage());
                                break;
                            }
                            case BaseActionEvent.FINISH: {
                                finish();
                                break;
                            }
                            case BaseActionEvent.FINISH_WITH_RESULT_OK: {
                                setResult(RESULT_OK);
                                finish();
                                break;
                            }
                        }
                    }
                });
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.mRepository.dispose();
        dismissLoading();
    }

    protected void showLoading() {

        if(loadingDialog == null) {
            loadingDialog = new LoadingDialog.Builder(this)
                    .setCancelOutside(false)
                    .setCancelable(false)
                    .create();
            loadingDialog.show();
        }

    }

    protected void dismissLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }
}
