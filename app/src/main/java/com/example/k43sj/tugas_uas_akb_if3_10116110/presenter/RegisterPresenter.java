package com.example.k43sj.tugas_uas_akb_if3_10116110.presenter;

/*
 * 12 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

public interface RegisterPresenter {
    void onHandleRegister(String username, String password);
    void onSuccess();
    void onError(String message);
}
