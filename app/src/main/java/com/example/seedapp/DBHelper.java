package com.example.seedapp;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 데이터베이스가 처음 생성될 때 호출됩니다.
        // 필요한 테이블 생성 SQL 문은 여기에 작성합니다.
        // 이미 테이블이 존재한다고 가정하면, 여기에 아무 것도 작성하지 않아도 됩니다.
        // -> 다시 만들어야할 상황이 생길 수 있으므로 예시코드 작성해놓는게 좋을듯
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 데이터베이스 업그레이드 시 호출됩니다.
        // 데이터베이스 버전이 증가하면 테이블 스키마를 변경하는 작업을 여기에 작성합니다.
        // 굳이 작성할 필요 없는 곳
    }

    // 데이터베이스 쓰기 가능한 연결을 얻는 메서드
    public SQLiteDatabase openWritableDatabase() {
        return this.getWritableDatabase();
    }

    // 데이터베이스 읽기 전용 연결을 얻는 메서드
    public SQLiteDatabase openReadableDatabase() {
        return this.getReadableDatabase();
    }
}