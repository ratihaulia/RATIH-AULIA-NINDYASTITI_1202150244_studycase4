package com.example.brahmantyo.ratih_1202150244_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //membuat aktivitas pada button list nama
    public void lstnama(View view) {
        //untuk pindah ke layoout List Nama Mahasiswa
        Intent intent = new Intent(MainActivity.this, ListNamaMahasiswa.class);
        startActivity(intent);
    }
    //membuat aktivitas pada button pencarian gambar
    public void pencarigbr(View view) {
        //untuk pindah ke layout Pencari Gambar
        Intent intent = new Intent(MainActivity.this, PencariGambar.class);
        startActivity(intent);
    }
}
