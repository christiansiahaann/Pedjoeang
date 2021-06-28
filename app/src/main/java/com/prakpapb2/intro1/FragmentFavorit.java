package com.prakpapb2.intro1;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prakpapb2.database.PahlawanHelper;
import com.prakpapb2.helper.MappingHelper;
import com.prakpapb2.semuapahlawan.PahlawanAdapter;
import com.prakpapb2.utils.Pahlawan;

import java.util.ArrayList;

public class FragmentFavorit extends Fragment {
    private RecyclerView rvFavorite;
    ImageView favoritKosong;
    Cursor dataCursor;
    PahlawanHelper pahlawanHelper;
    ArrayList<Pahlawan> listPahlawan;
    TextView textViewFavoritKosong;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvFavorite = view.findViewById(R.id.rvfavorite);
        favoritKosong = view.findViewById(R.id.favoritKosong);
        pahlawanHelper = PahlawanHelper.getInstance(getContext());
        textViewFavoritKosong = view.findViewById(R.id.textViewFavoritKosong);

        loadData();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        pahlawanHelper.open();
        dataCursor = pahlawanHelper.queryAll();
        listPahlawan = MappingHelper.mapCursorToArrayList(dataCursor);
        if (listPahlawan.isEmpty()) {
            favoritKosong.setVisibility(View.VISIBLE);
            textViewFavoritKosong.setVisibility(View.VISIBLE);
            showRecyclerList(listPahlawan);
        } else {
            favoritKosong.setVisibility(View.INVISIBLE);
            textViewFavoritKosong.setVisibility(View.INVISIBLE);
            showRecyclerList(listPahlawan);
        }
    }


    private void showRecyclerList(ArrayList<Pahlawan> list) {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        rvFavorite.setNestedScrollingEnabled(true);
        rvFavorite.setLayoutManager(layoutManager);
        PahlawanAdapter listPlayerAdapter = new PahlawanAdapter();
        listPlayerAdapter.setCourses(list);
        rvFavorite.setAdapter(listPlayerAdapter);
    }

}
