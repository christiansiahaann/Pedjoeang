package com.prakpapb2.helper;

import android.database.Cursor;

import com.prakpapb2.utils.Pahlawan;

import java.util.ArrayList;

public class MappingHelper {

    static String ID = "id";
    static String NAME = "title";
    static String DESCRIPTION = "description";
    static String PHOTO = "photo";

    public static ArrayList<Pahlawan> mapCursorToArrayList(Cursor notesCursor) {
        ArrayList<Pahlawan> notesList = new ArrayList<>();

        while (notesCursor.moveToNext()) {
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(ID));
            String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(NAME));
            String description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DESCRIPTION));
            String photo = notesCursor.getString(notesCursor.getColumnIndexOrThrow(PHOTO));
            notesList.add(new Pahlawan(id, photo, title, description));
        }

        return notesList;
    }
}
