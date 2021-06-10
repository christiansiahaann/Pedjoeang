package com.prakpapb2.intro1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MulaiKuis extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai_kuis);

        Button buttonMulaiKuis = findViewById(R.id.button_mulai_kuis);
        buttonMulaiKuis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_mulai_kuis:
                Intent moveIntent = new Intent(MulaiKuis.this, Kuis1.class);
                startActivity(moveIntent);
                break;
        }
    }
}