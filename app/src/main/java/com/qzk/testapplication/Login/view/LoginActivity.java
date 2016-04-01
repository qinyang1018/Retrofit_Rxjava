package com.qzk.testapplication.Login.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.qzk.testapplication.Login.present.ILoginPresenter;
import com.qzk.testapplication.Login.present.LoginPresent;
import com.qzk.testapplication.R;

public class LoginActivity extends Activity implements View.OnClickListener,ILoginView {


    private Activity mActivity = LoginActivity.this;
    private EditText userName;
    private EditText passWord;
    private Button login;
    private TextView response;
    private ProgressBar progress_bar;
    private ILoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loginPresenter = new LoginPresent(this);
    }
    private void initView() {
        userName = (EditText) findViewById(R.id.userName);
        passWord = (EditText) findViewById(R.id.passWord);
        login = (Button) findViewById(R.id.login);
        response = (TextView) findViewById(R.id.response);
        progress_bar = (ProgressBar)findViewById(R.id.progress_bar);
        login.setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        progress_bar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress_bar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(String msg) {
        Toast.makeText(mActivity,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccessed() {
        Toast.makeText(mActivity,"LoginSuccess",Toast.LENGTH_LONG).show();
        loginPresenter.mobileCheck(userName.getText().toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                loginPresenter.login(userName.getText().toString(),passWord.getText().toString());
                break;
        }
    }


}