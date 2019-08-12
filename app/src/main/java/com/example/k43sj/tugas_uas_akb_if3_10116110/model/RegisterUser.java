package com.example.k43sj.tugas_uas_akb_if3_10116110.model;

/*
 * 12 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

import android.text.TextUtils;

import com.example.k43sj.tugas_uas_akb_if3_10116110.presenter.RegisterPresenter;

public class RegisterUser {
    private RegisterPresenter presenter;

    public RegisterUser(RegisterPresenter presenter){
        this.presenter=presenter;
    }


    public void validateRegister(String email, String password, String name, String password2) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(TextUtils.isEmpty(email))
            presenter.onErrorRegister("Please Enter Email");
        else if(TextUtils.isEmpty(password))
            presenter.onErrorRegister("Please Enter Password");
        else if(!email.trim().matches(emailPattern))
            presenter.onErrorRegister("Please enter valid email");
        else if(email.length()<4)
            presenter.onErrorRegister("Email Must be at least 4 character long !");
        else if(password.length()<6)
            presenter.onErrorRegister("Password Must be at least 4 character long !");
        else if(!password.equals(password2))
            presenter.onErrorRegister("The Confirmation password confirmation doesn't match");
        else
            presenter.onSuccess();
    }

}
