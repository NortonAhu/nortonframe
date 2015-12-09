package com.bluecup.nortonframe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bluecup.core.ActionCallbackListener;
import com.bluecup.nortonframe.R;

/**
 * 注册
 * Created by YUHONG on 2015/12/9.
 * Email: hongyuahu@gmail.com
 */
public class RegisterActivity extends NBaseActivity {
    private EditText phoneEdit;
    private EditText codeEdit;
    private EditText passwordEdit;
    private Button sendCodeBtn;
    private Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        initViews();
    }

    @Override
    protected void initViews() {
        phoneEdit = (EditText) findViewById(R.id.edit_phone);
        codeEdit = (EditText) findViewById(R.id.edit_code);
        passwordEdit = (EditText) findViewById(R.id.edit_password);
        sendCodeBtn = (Button) findViewById(R.id.btn_send_code);
        registerBtn = (Button) findViewById(R.id.btn_register);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // 准备发送验证码
    public void toSendCode(View view) {
        String phoneNum = phoneEdit.getText().toString();
        sendCodeBtn.setEnabled(false);
        this.appAction.sendSmsCode(phoneNum, new ActionCallbackListener<Void>() {
            @Override
            public void onSuccess(Void data) {
                Toast.makeText(context, R.string.toast_code_has_sent, Toast.LENGTH_SHORT).show();
                sendCodeBtn.setEnabled(true);
            }

            @Override
            public void onFailure(String errorEvent, String message) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                sendCodeBtn.setEnabled(true);
            }
        });
    }
    // 准备注册
    public void toRegister(View view) {
        String phoneNum = phoneEdit.getText().toString();
        String code = codeEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        registerBtn.setEnabled(false);
        this.appAction.register(phoneNum, code, password, new ActionCallbackListener<Void>() {
            @Override
            public void onSuccess(Void data) {
                Toast.makeText(context, R.string.toast_register_success, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, CouponListActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(String errorEvent, String message) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                registerBtn.setEnabled(true);
            }
        });
    }
}
