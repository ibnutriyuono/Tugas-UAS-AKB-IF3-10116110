package com.example.k43sj.tugas_uas_akb_if3_10116110;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

/*
 * 10 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SharedPreferences app_preferences = PreferenceManager
                .getDefaultSharedPreferences(SplashScreen.this);
        SharedPreferences.Editor editor = app_preferences.edit();
        Boolean isFirstTime = app_preferences.getBoolean("isFirstTime", true);
        if (isFirstTime) {
            editor.putBoolean("isFirstTime", false);
            editor.commit();
            Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    startActivity(new Intent(SplashScreen.this,WelcomeScreen.class));
                    finish();
                }
            },3000);
        }else{
            Toast.makeText(this, "Sudah Login", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    startActivity(new Intent(SplashScreen.this,MainActivity.class));
                    finish();
                }
            },3000);
        }

    }
}
