package com.example.login.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.login.R;
import com.example.login.R2;
import com.example.login.viewmodel.LoginViewModel;
import com.example.mvvmlibrary.base.BaseActivity;
import com.example.networkrequest.arouter.Constance;
import com.example.networkrequest.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

@Route(path = Constance.ACTIVITY_URL_LOGIN)
public class LoginActivity extends BaseActivity<LoginViewModel> {

    @BindView(R2.id.toolbar_iv_cancel)
    ImageView toolbarIvCancel;
    @BindView(R2.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R2.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @BindView(R2.id.toolbar)
    Toolbar toolbar;
    @BindView(R2.id.login_et_username)
    EditText loginEtUsername;
    @BindView(R2.id.login_username_tip)
    TextView loginUsernameTip;
    @BindView(R2.id.login_et_password)
    EditText loginEtPassword;
    @BindView(R2.id.login_password_tip)
    TextView loginPasswordTip;
    @BindView(R2.id.login_btn_login)
    TextView btnLogin;

    private String username, password;

    @Override
    protected LoginViewModel getViewModel() {
        return ViewModelProviders.of(LoginActivity.this).get(LoginViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

    }

    private void initSubmit() {
        username = loginEtUsername.getText().toString();
        password = loginEtPassword.getText().toString();
        if (username.length() != 11) {
            ToastUtil.showToast(LoginActivity.this, getResources().getString(R.string.A_IZCX2C));
            return;
        }

        JSONObject requestData = new JSONObject();
        try {
            requestData.put("username", username);
            requestData.put("password", password);
            requestData.put("clientId", "hydrangea");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), requestData.toString());
        if (TextUtils.isEmpty(username) || username.length() != 11) {
            loginUsernameTip.setVisibility(View.VISIBLE);
            loginUsernameTip.setText(getResources().getString(R.string.A_34YLRS));
        } else if (TextUtils.isEmpty(password)) {
            loginPasswordTip.setVisibility(View.VISIBLE);
            loginPasswordTip.setText(getResources().getString(R.string.A_OVVODH));
        } else {
            loginUsernameTip.setVisibility(View.GONE);
            loginPasswordTip.setVisibility(View.GONE);
            viewModel.postLogin(requestBody);
        }
    }

    @OnClick({R2.id.toolbar_iv_cancel, R2.id.login_btn_login})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.toolbar_iv_cancel) {
            finish();
        } else if (i == R.id.login_btn_login) {
            initSubmit();
        }
    }
}
