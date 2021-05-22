package com.prakpapb2.intro1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Biografi extends AppCompatActivity {
private boolean IsFavorit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biografi);
        ImageButton IB2 = findViewById(R.id.favorit);
        IB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IsFavorit = !IsFavorit;
                if (IsFavorit) {
                    
                }
            }
        });

    }
}
