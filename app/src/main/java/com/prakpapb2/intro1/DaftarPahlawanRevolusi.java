package com.prakpapb2.intro1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import static com.prakpapb2.intro1.Biografi.EXTRA_PAHLAWAN;
import static com.prakpapb2.utils.DataPahlawan.getListDataPahlawan;

public class DaftarPahlawanRevolusi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_pahlawan_revolusi);

        ImageButton ibBack = findViewById(R.id.ib_back);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ImageView gambarpahlawan1 = findViewById(R.id.gambarpahlawan1);

        gambarpahlawan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPahlawanRevolusi.this, Biografi.class);
                intent.putExtra(EXTRA_PAHLAWAN, getListDataPahlawan().get(14));
                startActivity(intent);
            }
        });

        ImageView gambarpahlawan2 = findViewById(R.id.gambarpahlawan2);
        gambarpahlawan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPahlawanRevolusi.this, Biografi.class);
                intent.putExtra(EXTRA_PAHLAWAN, getListDataPahlawan().get(15));
                startActivity(intent);
            }
        });

        ImageView gambarpahlawan3 = findViewById(R.id.gambarpahlawan3);
        gambarpahlawan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPahlawanRevolusi.this, Biografi.class);
                intent.putExtra(EXTRA_PAHLAWAN, getListDataPahlawan().get(16));
                startActivity(intent);
            }
        });

        ImageView gambarpahlawan4 = findViewById(R.id.gambarpahlawan4);
        gambarpahlawan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPahlawanRevolusi.this, Biografi.class);
                intent.putExtra(EXTRA_PAHLAWAN, getListDataPahlawan().get(17));
                startActivity(intent);
            }
        });

        ImageView gambarpahlawan5 = findViewById(R.id.gambarpahlawan5);
        gambarpahlawan5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPahlawanRevolusi.this, Biografi.class);
                intent.putExtra(EXTRA_PAHLAWAN, getListDataPahlawan().get(18));
                startActivity(intent);
            }
        });

        ImageView gambarpahlawan6 = findViewById(R.id.gambarpahlawan6);
        gambarpahlawan6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPahlawanRevolusi.this, Biografi.class);
                intent.putExtra(EXTRA_PAHLAWAN, getListDataPahlawan().get(19));
                startActivity(intent);
            }
        });

        ImageView gambarpahlawan7 = findViewById(R.id.gambarpahlawan7);
        gambarpahlawan7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPahlawanRevolusi.this, Biografi.class);
                intent.putExtra(EXTRA_PAHLAWAN, getListDataPahlawan().get(20));
                startActivity(intent);
            }
        });

    }
}