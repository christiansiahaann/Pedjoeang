package com.prakpapb2.intro1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);

        Button buttonIntro2 = findViewById(R.id.button_intro2);
        buttonIntro2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_intro2:
                Intent moveIntent = new Intent(Intro2.this, Intro3.class);
                startActivity(moveIntent);
                break;
        }
    }
}