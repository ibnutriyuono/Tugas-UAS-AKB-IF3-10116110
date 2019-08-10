package com.example.k43sj.tugas_uas_akb_if3_10116110.presenter;

/*
 * 10 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

public interface LoginPresenter {
    void onLogin(String username, String password, String dataUser, String dataPass);
    void onSuccess();
    void onError(String message);
}
