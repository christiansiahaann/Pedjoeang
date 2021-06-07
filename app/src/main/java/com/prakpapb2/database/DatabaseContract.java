package com.prakpapb2.database;

import android.provider.BaseColumns;

public class DatabaseContract {

    static String TABLE_NAME = "Pahlawan";
    static final class PahlawanColumns implements BaseColumns {
        static String ID = "id";
        static String NAME = "title";
        static String DESCRIPTION = "description";
        static String PHOTO = "photo";
    }
}
