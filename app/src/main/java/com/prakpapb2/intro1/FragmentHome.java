package com.prakpapb2.intro1;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentHome extends Fragment implements androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener, PopupMenu.OnMenuItemClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.beranda, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton IB1 = view.findViewById(R.id.back);
        IB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
        Button butt1 = (Button) view.findViewById(R.id.button1);
        Button butt2 = (Button) view.findViewById(R.id.button2);
        Button butt3 = (Button) view.findViewById(R.id.button3);
        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentFavorit());
            }
        });
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentJenisPahlawan());
            }
        });
        butt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentKuis());
            }
        });
    }
    public  void showPopup(View v) {
        PopupMenu popup = new PopupMenu(getContext(), v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_main);
        popup.show();
    }

        private void replaceFragment(Fragment newFragment) {
            FragmentTransaction trasection = getFragmentManager().beginTransaction();

            if(!newFragment.isAdded()) {
                try {
                    //FragmentTransaction trasection =
                    getFragmentManager().beginTransaction();
                    trasection.replace(R.id.container_fragment, newFragment);
                    trasection.addToBackStack(null);
                    trasection.commit();
                } catch (Exception e) {
                    // TODO: handle exception
                    // AppConstants.printLog(e.getMessage());
                }

                }else {
                    trasection.show(newFragment);
                }
            }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_language:
                Intent languageIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(languageIntent);
                return true;
            default:
                return false;
        }
    }
}
