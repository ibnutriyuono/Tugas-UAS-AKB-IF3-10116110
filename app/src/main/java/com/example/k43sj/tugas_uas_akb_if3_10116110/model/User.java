package com.example.k43sj.tugas_uas_akb_if3_10116110.model;

/*
 * 10 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

import android.text.TextUtils;
import android.util.Patterns;

import com.example.k43sj.tugas_uas_akb_if3_10116110.presenter.LoginPresenter;

public class User {
    private LoginPresenter presenter;

    public User(LoginPresenter presenter){
        this.presenter=presenter;
    }

    public void validateUser(String email, String password , String dataUsername, String dataPassword) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(TextUtils.isEmpty(email))
            presenter.onError("Please Enter Username !");
        else if(TextUtils.isEmpty(password))
            presenter.onError("Please Enter Password");
        else if(!email.trim().matches(emailPattern))
            presenter.onError("Please enter valid email");
//        else if(!dataUsername.equals(email))
//            presenter.onError("Wrong Username !");
//        else if(!dataPassword.equals(password))
//            presenter.onError("Wrong Password !");
        else
            presenter.onSuccess();
    }
}
