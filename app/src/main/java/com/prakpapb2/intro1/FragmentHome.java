package com.prakpapb2.intro1;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
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
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.prakpapb2.kuis.FragmentKuisKotlin;
import com.prakpapb2.notif.Datasource;
import com.prakpapb2.notif.HariBesar;
import com.prakpapb2.notif.ReminderBroadcast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.function.Consumer;

import static android.content.Context.ALARM_SERVICE;

public class FragmentHome extends Fragment implements androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener, PopupMenu.OnMenuItemClickListener {

    //Attribut untuk menampung list haribesar
    private ArrayList<HariBesar> listHariBesar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.beranda, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
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
                ((BottomNavigationView) getActivity().findViewById(R.id.bottom_navigation_menu)).setSelectedItemId(R.id.menu_favorit);
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
//                replaceFragment(new FragmentKuis());
                replaceFragment(new FragmentKuisKotlin());
            }
        });

        //ambil data dari datasoruce dan masukkan dalam listHariBesar
        listHariBesar = new Datasource().loadListHari();

        createNotificationChannel();

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

    //Function membuat channel notifikasi
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(){
        //set nama notifikasinya
        String name = "Hari Besar Reminder";
        String description = "Reminder Hari Besar";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        //id disini harus sama dengan id yang ada di class ReminderBroadcast
        NotificationChannel channel = new NotificationChannel("notifyHariBesar",name,importance);
        channel.setDescription(description);

        NotificationManager notificationManager = (NotificationManager) requireActivity().getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    //Function untuk set notifikasi
    private void setNotification(HariBesar hariBesar, int code){
        //intent untuk pass data ke reminder broadcast
        Intent intent = new Intent(requireContext(), ReminderBroadcast.class);
        intent.putExtra("date", hariBesar.getDate());
        intent.putExtra("monthName",hariBesar.getMonthName());
        intent.putExtra("name", hariBesar.getName());
        intent.putExtra("image", hariBesar.getImage());

        PendingIntent pendingIntent = PendingIntent.getBroadcast(requireContext(), code, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) requireActivity().getSystemService(ALARM_SERVICE);

        //Calendar untuk menentukan waktu kapan notifikasi muncul
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, hariBesar.getMonth()-1, hariBesar.getDate(), 07, 01);//hourofday dan minute untuk menentukan pada jam berapa notifikasi muncul

        //conditional ketika tanggal hari besar belum lewat, maka baru set notif nya
        if (calendar.getTimeInMillis() >= System.currentTimeMillis()){
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_language:
                Intent languageIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(languageIntent);
                return true;
            case R.id.action_notification:
                //ini buat bikin notif untuk setiap hari besar saat menu notif di klik
                listHariBesar.forEach((new Consumer<HariBesar>() {
                    @Override
                    public void accept(HariBesar hariBesar) {
                        FragmentHome.this.setNotification(hariBesar, listHariBesar.indexOf(hariBesar));
                    }
                }));
                Toast.makeText(requireContext(),"Notifikasi Berhasil Dibuat", Toast.LENGTH_LONG).show();
                return true;

            default:
                return false;
        }
    }
}
