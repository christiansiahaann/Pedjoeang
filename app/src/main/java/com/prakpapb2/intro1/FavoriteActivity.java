package com.prakpapb2.intro1;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.prakpapb2.intro1.R;
import com.prakpapb2.database.PahlawanHelper;
import com.prakpapb2.helper.MappingHelper;
import com.prakpapb2.utils.Pahlawan;
//import com.example.stroll.model.Destinasi;
import com.prakpapb2.utils.Pahlawan;
//import com.example.stroll.ui.semuadestinasi.DestinasiAdapter;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    private RecyclerView rvFavorite;
    ImageView favoritKosong;
    Cursor dataCursor;
    PahlawanHelper pahlawanHelper;
    ArrayList<Pahlawan> listPahlawan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_favorit);

        rvFavorite = findViewById(R.id.rvfavorite);
        favoritKosong = findViewById(R.id.favoritKosong);
        pahlawanHelper = PahlawanHelper.getInstance(this);

        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }


    private void loadData() {
        pahlawanHelper.open();
        dataCursor = pahlawanHelper.queryAll();
        listPahlawan = MappingHelper.mapCursorToArrayList(dataCursor);
        if (listPahlawan.isEmpty()) {
            favoritKosong.setVisibility(View.VISIBLE);
            showRecyclerList(listPahlawan);
        } else {
            favoritKosong.setVisibility(View.INVISIBLE);
            showRecyclerList(listPahlawan);
        }
    }

    private void showRecyclerList(ArrayList<Pahlawan> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvFavorite.setNestedScrollingEnabled(true);
        rvFavorite.setLayoutManager(layoutManager);
//        DestinasiAdapter listPlayerAdapter = new DestinasiAdapter();
//        listPlayerAdapter.setCourses(list);
//        rvFavorite.setAdapter(listPlayerAdapter);
    }

}