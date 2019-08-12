package com.example.k43sj.tugas_uas_akb_if3_10116110;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.k43sj.tugas_uas_akb_if3_10116110.presenter.Login;
import com.example.k43sj.tugas_uas_akb_if3_10116110.presenter.LoginPresenter;
import com.example.k43sj.tugas_uas_akb_if3_10116110.view.LoginView;


/*
 * 12 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

public class LoginActivity extends AppCompatActivity implements LoginView {
    private TextView register;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    EditText textEditEmail, textEditPassword;
    Button btnLogin;

    LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = (TextView) findViewById(R.id.link_signup);
        textEditEmail = (EditText) findViewById(R.id.input_email);
        textEditPassword = (EditText) findViewById(R.id.input_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        presenter = new Login(this);
        sharedPreferences = getSharedPreferences("Register", Context.MODE_PRIVATE);
        final String email = sharedPreferences.getString("email", null);
        final String password = sharedPreferences.getString("password", null);
        textEditEmail.setText(email);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail = textEditEmail.getText().toString();
                String strPassword = textEditPassword.getText().toString();
                presenter.onLogin(strEmail,strPassword,email,password);
            }
        });
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
