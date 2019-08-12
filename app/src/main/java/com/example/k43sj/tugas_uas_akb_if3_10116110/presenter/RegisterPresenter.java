package com.example.k43sj.tugas_uas_akb_if3_10116110.presenter;

/*
 * 12 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

public interface RegisterPresenter {
    void onHandleRegister(String email, String password, String name, String password2);
    void onSuccess();
    void onErrorRegister(String message);
}
