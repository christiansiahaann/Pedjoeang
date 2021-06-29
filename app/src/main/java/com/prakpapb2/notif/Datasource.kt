package com.prakpapb2.notif

import com.prakpapb2.intro1.R
import java.util.*

class Datasource {
    fun loadListHari(): ArrayList<HariBesar> {
        return arrayListOf<HariBesar>(
            //ubah data hari besar disini
            HariBesar(14,2,"Februari", "Hari Peringatan Pembela Tanah Air (PETA)", R.drawable.hari_peta),
            HariBesar(11,3,"Maret", "Hari Surat Perintah 11 Maret", R.drawable.hari_supersemar),
            HariBesar(21 ,4,"April", "Hari Kartini", R.drawable.hari_kartini),
            HariBesar(2,5,"Mei", "Hari Pendidikan Nasional", R.drawable.hari_pendidikan),
            HariBesar(20,5,"Mei", "Hari Kebangkitan Nasional", R.drawable.hari_besar_merahputih),
            HariBesar(21,5,"Mei", "Hari Peringatan Reformasi", R.drawable.hari_besar_merahputih),
            HariBesar(27,6,"Juni", "Hari Lahirnya Pancasila", R.drawable.hari_besar_burunggaruda),
            HariBesar(10,8,"Agustus", "Hari Veteran Nasional", R.drawable.hari_veteran),
            HariBesar(17,8,"Agustus", "Hari Proklamasi Kemerdekaan Indonesia", R.drawable.hari_proklamasi),
            HariBesar(30,9,"September", "Hari Peringatan Pemberontakan G30S PKI", R.drawable.hari_g30s),
            HariBesar(1,10,"Oktober", "Hari Kesaktian Pancasila", R.drawable.hari_besar_burunggaruda),
            HariBesar(28,10,"Oktober", "Hari Sumpah Pemuda", R.drawable.hari_besar_merahputih),
            HariBesar(10,11,"November", "Hari Pahlawan", R.drawable.hari_pahlawan),

        )
    }
}