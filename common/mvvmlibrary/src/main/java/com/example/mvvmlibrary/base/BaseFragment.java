package com.example.mvvmlibrary.base;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmlibrary.observer.FragmentLifecycleObserver;
import com.example.mvvmlibrary.widget.loadingdrawable.LoadingDialog;
import com.example.networkrequest.base.BaseActionEvent;
import com.example.networkrequest.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseFragment<T extends BaseViewModel> extends Fragment {

    protected T viewModel;
    public LoadingDialog loadingDialog = null;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (viewModel == null) {
            viewModel = getViewModel();
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initViewModelEvent();
        getLifecycle().addObserver(new FragmentLifecycleObserver(getActivity().getApplicationContext()));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract T getViewModel();

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

    protected List<ViewModel> initViewModelList() {
        return null;
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
                        }
                    }
                });
            }
        }
    }

    protected void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog.Builder(getContext())
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewModel.mRepository.dispose();
    }
}
