package com.example.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    static final String DB_NAME = "University";
    static final int DB_VERSION = 3;

    String TABLE_NAME = "studenci";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "ZDJECIE INTEGER, "
                + "NAZWISKO TEXT, "
                + "IMIE TEXT, "
                + "DATAUR TEXT,"
                + "WYDZIAL TEXT, "
                + "SREDNIA REAL);");
    }

    public boolean addRecord(SQLiteDatabase db, int zd, String nazwisko, String imie, String dataur, String wydzial, double srednia) {
        ContentValues value = new ContentValues();
        value.put("ZDJECIE", zd);
        value.put("NAZWISKO", nazwisko);
        value.put("IMIE", imie);
        value.put("DATAUR", dataur);
        value.put("WYDZIAL", wydzial);
        value.put("SREDNIA", srednia);
        int x = (int) db.insert(TABLE_NAME, null, value);

        if (x == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean removeRecord(SQLiteDatabase db, Integer id) {
        int x = (int) db.delete(TABLE_NAME, "_id = ?", new String[] {id.toString()});

        if (x == -1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        resetDatabase(db);
    }

    public void resetDatabase(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}