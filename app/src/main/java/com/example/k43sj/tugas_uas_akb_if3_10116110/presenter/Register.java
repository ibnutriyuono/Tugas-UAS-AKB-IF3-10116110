package com.example.k43sj.tugas_uas_akb_if3_10116110.presenter;

/*
 * 12 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

import com.example.k43sj.tugas_uas_akb_if3_10116110.model.RegisterUser;
import com.example.k43sj.tugas_uas_akb_if3_10116110.view.RegisterView;

public class Register implements RegisterPresenter{
    RegisterView view;
    RegisterUser model;

    public Register(RegisterView view) {
        this.view = view;
        this.model = new RegisterUser(this);
    }

    @Override
    public void onHandleRegister(String email, String password, String name, String password2) {
        model.validateRegister(email,password, name, password2);
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
    }

    @Override
    public void onErrorRegister(String message) {
        view.onErrorRegister(message);
    }
}
