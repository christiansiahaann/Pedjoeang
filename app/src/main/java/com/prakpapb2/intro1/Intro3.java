package com.prakpapb2.intro1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro3 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro3);

        Button buttonIntro3 = findViewById(R.id.button_intro3);
        buttonIntro3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_intro3:
                Intent moveIntent = new Intent(Intro3.this, MainActivity.class);
                startActivity(moveIntent);
                break;
        }
    }
}