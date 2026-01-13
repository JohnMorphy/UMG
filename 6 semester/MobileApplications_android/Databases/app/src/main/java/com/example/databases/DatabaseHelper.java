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

    public boolean addRecord(int zd, String nazwisko, String imie, String dataur, String wydzial, double srednia) {
        SQLiteDatabase db = this.getReadableDatabase();
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

    public boolean updateRecord(int id, String surname, String name, String birthDate, String department, double average) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAZWISKO", surname);
        values.put("IMIE", name);
        values.put("DATAUR", birthDate);
        values.put("WYDZIAL", department);
        values.put("SREDNIA", average);

        int rowsAffected = db.update(TABLE_NAME, values, "_id = ?", new String[]{String.valueOf(id)});
        db.close();

        return rowsAffected > 0;
    }

    public boolean removeRecord(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME, "_id = ?", new String[]{String.valueOf(id)});
        db.close();
        return result != -1;
    }

    public Cursor selectStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public boolean isDatabaseEmpty() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        boolean isEmpty = cursor.getCount() == 0;
        cursor.close();
        return isEmpty;
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