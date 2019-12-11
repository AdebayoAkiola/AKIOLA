package com.example.connexionbase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClasseBase extends SQLiteOpenHelper {
    private static final String DATABASENAME="student1.db";
    private static final int DATABASEVERSION=1;
    public ClasseBase(Context context){
        super(context,DATABASENAME,null,DATABASEVERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student(id INTEGER primary key,name text)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}

