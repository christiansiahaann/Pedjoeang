package com.prakpapb2.intro1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentJenisPahlawan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentJenisPahlawan2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentJenisPahlawan2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentJenisPahlawan.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentJenisPahlawan2 newInstance(String param1, String param2) {
        FragmentJenisPahlawan2 fragment = new FragmentJenisPahlawan2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jenis_pahlawan2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonKemerdekaanNasional = view.findViewById(R.id.button_kemerdekaan_nasional);
        buttonKemerdekaanNasional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DaftarPahlawanKemerdekaan.class);
                startActivity(intent);
            }
        });

        Button buttonKebangkitanNasional = view.findViewById(R.id.button_kebangkitan_nasional);
        buttonKebangkitanNasional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DaftarPahlawanKebangkitan.class);
                startActivity(intent);
            }
        });


        Button buttonRevolusi = view.findViewById(R.id.button_revolusi);
        buttonRevolusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DaftarPahlawanRevolusi.class);
                startActivity(intent);
            }
        });

        Button buttonEmansipasiWanita = view.findViewById(R.id.button_emansipasi_wanita);
        buttonEmansipasiWanita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DaftarPahlawanEmansipasi.class);
                startActivity(intent);
            }
        });

    }
}