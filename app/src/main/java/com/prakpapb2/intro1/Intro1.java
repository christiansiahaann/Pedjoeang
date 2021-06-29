package com.prakpapb2.intro1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro1 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);

        Button buttonIntro1 = findViewById(R.id.button_intro1);
        buttonIntro1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_intro1:
                Intent moveIntent = new Intent(Intro1.this, Intro2.class);
                startActivity(moveIntent);
                break;
        }
    }
}