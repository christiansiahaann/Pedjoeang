package com.prakpapb2.utils;

import java.util.ArrayList;
import java.util.Locale;

public class DataPahlawan {

    public static ArrayList<Pahlawan> getListDataPahlawan() {
        ArrayList<Pahlawan> list = new ArrayList<>();

        String deviceLocale = Locale.getDefault().getCountry();
        if (deviceLocale.equals("ID")) {
            for (int position = 0; position< DataPahlawanId.namaPahlawan.length; position++){
                Pahlawan pahlawan = new Pahlawan();
                pahlawan.setId(position+1);
                pahlawan.setDeskripsiPahlawan(DataPahlawanId.deskripsiPahlawan[position]);
                pahlawan.setNamaPahlawan(DataPahlawanId.namaPahlawan[position]);
                pahlawan.setPhotoPahlawan(DataPahlawanId.photoPahlawan[position]);
                list.add(pahlawan);
            }
        } else {
            for (int position = 0; position< DataPahlawanEn.namaPahlawan.length; position++){
                Pahlawan pahlawan = new Pahlawan();
                pahlawan.setId(position+1);
                pahlawan.setDeskripsiPahlawan(DataPahlawanEn.deskripsiPahlawan[position]);
                pahlawan.setNamaPahlawan(DataPahlawanEn.namaPahlawan[position]);
                pahlawan.setPhotoPahlawan(DataPahlawanEn.photoPahlawan[position]);
                list.add(pahlawan);
            }
        }
        return list;
    }
}
