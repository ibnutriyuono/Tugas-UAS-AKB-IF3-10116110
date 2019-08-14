package com.example.k43sj.tugas_uas_akb_if3_10116110;

import com.example.k43sj.tugas_uas_akb_if3_10116110.helper.RealmHelper;
import com.example.k43sj.tugas_uas_akb_if3_10116110.model.MahasiswaModel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class DataTemanActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnsimpan, btntampil;
    EditText nim,nama;
    String snama;
    Integer snim;
    Realm realm;
    RealmHelper realmHelper;
    MahasiswaModel mahasisawaModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_teman);
        btnsimpan = findViewById(R.id.btnSimpan);
        btntampil = findViewById(R.id.btnTampil);
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);
        Realm.init(DataTemanActivity.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        btnsimpan.setOnClickListener(this);
        btntampil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnsimpan) {
            snim = Integer.parseInt(nim.getText().toString());
            snama = nama.getText().toString();

            if (!snim.equals("") && !snama.isEmpty()) {
                mahasisawaModel = new MahasiswaModel();
                mahasisawaModel.setNim(snim);
                mahasisawaModel.setNama(snama);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(mahasisawaModel);

                Toast.makeText(DataTemanActivity.this, "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                nim.setText("");
                nama.setText("");

            } else {
                Toast.makeText(DataTemanActivity.this, "Terdapat inputan kosong", Toast.LENGTH_SHORT).show();
            }
        }else  if (v== btntampil){
            startActivity(new Intent(DataTemanActivity.this, MahasiswaActivity.class));
        }
    }
}
