package com.example.k43sj.tugas_uas_akb_if3_10116110.model;

/*
 * 10 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

import android.text.TextUtils;

import com.example.k43sj.tugas_uas_akb_if3_10116110.presenter.LoginPresenter;

public class User {
    private LoginPresenter presenter;

    public User(LoginPresenter presenter){
        this.presenter=presenter;
    }

    public void validateUser(String username, String password , String dataUsername, String dataPassword) {

        if(TextUtils.isEmpty(username))
            presenter.onError("Please Enter Username !");
        else if(TextUtils.isEmpty(password))
            presenter.onError("Please Enter Password");
        else if(!dataUsername.equals(username))
            presenter.onError("Wrong Username !");
        else if(!dataPassword.equals(password))
            presenter.onError("Wrong Password !");
        else
            presenter.onSuccess();
    }
}
