package com.example.seedapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataManager {

    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public DataManager(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Table1에 대한 CRUD 작업
    public long insertIntoTable1(String name, int age) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.TABLE_1_COLUMN_NAME, name);
        values.put(DBHelper.TABLE_1_COLUMN_AGE, age);
        return database.insert(DBHelper.TABLE_1_NAME, null, values);
    }

    public Cursor fetchAllFromTable1() {
        String[] columns = new String[] {
                DBHelper.TABLE_1_COLUMN_ID,
                DBHelper.TABLE_1_COLUMN_NAME,
                DBHelper.TABLE_1_COLUMN_AGE
        };
        Cursor cursor = database.query(DBHelper.TABLE_1_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public boolean updateTable1(long id, String name, int age) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.TABLE_1_COLUMN_NAME, name);
        values.put(DBHelper.TABLE_1_COLUMN_AGE, age);
        return database.update(DBHelper.TABLE_1_NAME, values, DBHelper.TABLE_1_COLUMN_ID + "=" + id, null) > 0;
    }

    public boolean deleteFromTable1(long id) {
        return database.delete(DBHelper.TABLE_1_NAME, DBHelper.TABLE_1_COLUMN_ID + "=" + id, null) > 0;
    }

    // Table2에 대한 CRUD 작업
    public long insertIntoTable2(String title, String description) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.TABLE_2_COLUMN_TITLE, title);
        values.put(DBHelper.TABLE_2_COLUMN_DESCRIPTION, description);
        return database.insert(DBHelper.TABLE_2_NAME, null, values);
    }

    public Cursor fetchAllFromTable2() {
        String[] columns = new String[] {
                DBHelper.TABLE_2_COLUMN_ID,
                DBHelper.TABLE_2_COLUMN_TITLE,
                DBHelper.TABLE_2_COLUMN_DESCRIPTION
        };
        Cursor cursor = database.query(DBHelper.TABLE_2_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public boolean updateTable2(long id, String title, String description) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.TABLE_2_COLUMN_TITLE, title);
        values.put(DBHelper.TABLE_2_COLUMN_DESCRIPTION, description);
        return database.update(DBHelper.TABLE_2_NAME, values, DBHelper.TABLE_2_COLUMN_ID + "=" + id, null) > 0;
    }

    public boolean deleteFromTable2(long id) {
        return database.delete(DBHelper.TABLE_2_NAME, DBHelper.TABLE_2_COLUMN_ID + "=" + id, null) > 0;
    }
}