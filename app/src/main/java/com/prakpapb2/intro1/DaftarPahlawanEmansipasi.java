package com.prakpapb2.intro1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import static com.prakpapb2.intro1.Biografi.EXTRA_PAHLAWAN;
import static com.prakpapb2.utils.DataPahlawan.getListDataPahlawan;

public class DaftarPahlawanEmansipasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_pahlawan_emansipasi);

        ImageButton ibBack = findViewById(R.id.ib_back);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ImageView gambarpahlawan = findViewById(R.id.gambarpahlawan);
        gambarpahlawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarPahlawanEmansipasi.this, Biografi.class);
                intent.putExtra(EXTRA_PAHLAWAN, getListDataPahlawan().get(1));
                startActivity(intent);
            }
        });

    }
}
