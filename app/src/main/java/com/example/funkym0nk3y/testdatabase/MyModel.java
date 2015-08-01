package com.example.funkym0nk3y.testdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by FunkyM0nk3y on 8/1/15.
 */
public class MyModel extends SQLiteOpenHelper {
  public static final String TABLE_PERSONA = "PERSONA";
  public static final String COLUMN_ID     = "id";
  public static final String COLUMN_NOMBRE = "nombre";

  private static final String DATABASE_NAME   = "usuarios.db";
  private static final int DATABASE_VERSION   = 1;
  private static final String DATABASE_CREATE = "create table "
          + TABLE_PERSONA + "(" + COLUMN_ID
          + " integer primary key autoincrement, " + COLUMN_NOMBRE
          + " text not null);";

  public MyModel(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP IF EXIST TABLE " + TABLE_PERSONA);
    onCreate(db);
  }
}
