package com.example.k43sj.tugas_uas_akb_if3_10116110;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.k43sj.tugas_uas_akb_if3_10116110.presenter.Register;
import com.example.k43sj.tugas_uas_akb_if3_10116110.presenter.RegisterPresenter;
import com.example.k43sj.tugas_uas_akb_if3_10116110.view.RegisterView;


/*
 * 12 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

public class RegisterActivity extends AppCompatActivity implements RegisterView {
    private TextView login;
    TextView btnRegister;
    EditText textEditEmail, textEditPassword, textEditName, textEditPassword2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    RegisterPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        presenter = new Register(this);
        textEditName = (EditText) findViewById(R.id.input_name);
        textEditEmail = (EditText) findViewById(R.id.input_email);
        textEditPassword = (EditText) findViewById(R.id.input_password);
        textEditPassword2 = (EditText) findViewById(R.id.input_password2);
        btnRegister = (TextView) findViewById(R.id.btn_signup);

        sharedPreferences = getSharedPreferences("Register", Context.MODE_PRIVATE);

        login = (TextView) findViewById(R.id.link_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail = textEditEmail.getText().toString();
                String strPassword = textEditPassword.getText().toString();
                String strName = textEditName.getText().toString();
                String strPassword2 = textEditPassword2.getText().toString();
                presenter.onHandleRegister(strEmail,strPassword, strName, strPassword2);
            }
        });
    }

    @Override
    public void onSuccess() {
        String email = textEditEmail.getText().toString();
        String password = textEditPassword.getText().toString();
        editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.commit();

        Toast.makeText(this, "Berhasil Register", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onErrorRegister(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

}
