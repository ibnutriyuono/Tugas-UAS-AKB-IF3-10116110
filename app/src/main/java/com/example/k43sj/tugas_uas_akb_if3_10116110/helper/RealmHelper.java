package com.example.k43sj.tugas_uas_akb_if3_10116110.helper;

/*
 * 12 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

import android.util.Log;

import com.example.k43sj.tugas_uas_akb_if3_10116110.model.Mahasiswa;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {

    Realm realm;

    public  RealmHelper(Realm realm){
        this.realm = realm;
    }

    // untuk menyimpan data
    public void save(final Mahasiswa mahasiswaModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Created", "Database was created");
                    Number currentIdNum = realm.where(Mahasiswa.class).max("id");
                    int nextId;
                    if (currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    mahasiswaModel.setId(nextId);
                    Mahasiswa model = realm.copyToRealm(mahasiswaModel);
                }else{
                    Log.e("ppppp", "execute: Database not Exist");
                }
            }
        });
    }

    // untuk memanggil semua data
    public List<Mahasiswa> getAllMahasiswa(){
        RealmResults<Mahasiswa> results = realm.where(Mahasiswa.class).findAll();
        return results;
    }

    // untuk meng-update data
    public void update(final Integer id, final Integer nim, final String nama){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Mahasiswa model = realm.where(Mahasiswa.class)
                        .equalTo("id", id)
                        .findFirst();
                model.setNim(nim);
                model.setNama(nama);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("pppp", "onSuccess: Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }

    // untuk menghapus data
    public void delete(Integer id){
        final RealmResults<Mahasiswa> model = realm.where(Mahasiswa.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }

}