package com.example.k43sj.tugas_uas_akb_if3_10116110.presenter;

/*
 * 10 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

import com.example.k43sj.tugas_uas_akb_if3_10116110.model.User;
import com.example.k43sj.tugas_uas_akb_if3_10116110.view.LoginView;

public class Login implements LoginPresenter {
    private LoginView view;
    private User model;

    public Login(LoginView view){
        this.view=view;
        this.model=new User(this);
    }

    @Override
    public void onLogin(String username, String password, String dataUser, String dataPass) {
        model.validateUser(username,password,dataUser,dataPass);
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
    }

    @Override
    public void onError(String message) {
        view.onError(message);
    }
}
