package com.example.k43sj.tugas_uas_akb_if3_10116110.model;

/*
 * 10 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Mahasiswa extends RealmObject {

    @PrimaryKey
    private int id;

    private int nim;

    private String nama,kelas,telephone,email,instagram;

    public Mahasiswa(int nim, String nama, String kelas, String telephone, String email, String instagram){
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.telephone = telephone;
        this.email = email;
        this.instagram = instagram;
    }

    public int getId() {
        return id;
    }

    public int getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
