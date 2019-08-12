package com.example.k43sj.tugas_uas_akb_if3_10116110.model;

/*
 * 10 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

import com.example.k43sj.tugas_uas_akb_if3_10116110.presenter.LoginPresenter;

public class User {
    private String username, password;
    private LoginPresenter presenter;

    public User(LoginPresenter presenter){
        this.presenter=presenter;
    }
}
