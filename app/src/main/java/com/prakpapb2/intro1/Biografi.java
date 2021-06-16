package com.prakpapb2.intro1;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.prakpapb2.database.PahlawanHelper;
import com.prakpapb2.helper.MappingHelper;
import com.prakpapb2.utils.Pahlawan;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Biografi extends AppCompatActivity {
    private boolean isFavorite = false;
    static String ID = "id";
    static String NAME = "title";
    static String DESCRIPTION = "description";
    static String PHOTO = "photo";

    private PahlawanHelper pahlawanHelper;
    private Pahlawan pahlawan;
    public static final String EXTRA_PAHLAWAN = "extra_pahlawan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biografi);
        final ImageButton IB2 = findViewById(R.id.favorit);

        pahlawan = getIntent().getParcelableExtra(EXTRA_PAHLAWAN);
        TextView tvName = findViewById(R.id.tv_name);
        tvName.setText(pahlawan.getNamaPahlawan());
        TextView tvDesc = findViewById(R.id.tv_desc);
        tvDesc.setText(pahlawan.getDeskripsiPahlawan());
        ImageView imageView = findViewById(R.id.gambarpahlawan);
        Picasso.get()
                .load(pahlawan.getPhotoPahlawan())
                .resize(450, 450)
                .into(imageView);

        pahlawanHelper = PahlawanHelper.getInstance(this);
        pahlawanHelper.open();

        Cursor dataCursor = pahlawanHelper.queryAll();
        ArrayList<Pahlawan> listPahlawan = MappingHelper.mapCursorToArrayList(dataCursor);

        ArrayList<Integer> listId = new ArrayList<>();
        for (int i = 0; i < listPahlawan.size(); i++) {
            listId.add(listPahlawan.get(i).getId());
        }

        isFavorite = listId.contains(pahlawan.getId());
        setFavorite(IB2, isFavorite);

        IB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFavorite) {
                    isFavorite = false;
                    setFavorite(IB2, isFavorite);
                    int delete = pahlawanHelper.deleteById(String.valueOf(pahlawan.getId()));
                    if (delete > 0) {
                        Toast.makeText(Biografi.this, "Berhasil hapus Favorite", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Biografi.this, "Gagal hapus favorite", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    isFavorite = true;
                    setFavorite(IB2, isFavorite);
                    ContentValues values = new ContentValues();
                    values.put(ID, pahlawan.getId());
                    values.put(NAME, pahlawan.getNamaPahlawan());
                    values.put(DESCRIPTION, pahlawan.getDeskripsiPahlawan());
                    values.put(PHOTO, pahlawan.getPhotoPahlawan());

                    long result = pahlawanHelper.insert(values);

                    if (result > 0) {
                        Toast.makeText(Biografi.this, "Success menambah", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Biografi.this, "Gagal Menambah favorite", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        ImageButton ibBack = findViewById(R.id.ib_back);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void setFavorite(ImageButton IB2, Boolean isFavorite) {
        if (isFavorite) {
            IB2.setImageResource(R.drawable.ic_baseline_favorite_24);
        } else {
            IB2.setImageResource(R.drawable.ic_baseline_favorite_24_2);
        }
    }
}
