package com.example.funkym0nk3y.testdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FunkyM0nk3y on 8/1/15.
 */
public class PersonaDAO {
  private SQLiteDatabase db;
  private MyModel dbHelper;
  private String[] allColumns = {MyModel.COLUMN_ID, MyModel.COLUMN_NOMBRE};

  public PersonaDAO (Context context) {
    this.dbHelper = new MyModel(context);
  }

  public void open() {
    db = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public Persona createPersona (String nombre) {
    ContentValues contentValues = new ContentValues();
    contentValues.put(MyModel.COLUMN_NOMBRE, nombre);

    long id = db.insert(MyModel.TABLE_PERSONA, null, contentValues);
    Cursor cursor = db.query(MyModel.TABLE_PERSONA, allColumns, MyModel.COLUMN_ID + "=" + id, null, null, null, null);
    cursor.moveToFirst();
    Persona persona = cursorToPerson(cursor);
    cursor.close();

    return persona;
  }

  public Persona cursorToPerson (Cursor cursor) {
    Persona persona = new Persona();
    persona.setId(cursor.getLong(cursor.getColumnIndex(MyModel.COLUMN_ID)));
    persona.setNombre(cursor.getString(cursor.getColumnIndex(MyModel.COLUMN_NOMBRE)));

    return persona;
  };

  public void deletePersona (Persona persona) {
    long id = persona.getId();
    db.delete(MyModel.TABLE_PERSONA, MyModel.COLUMN_ID + "=" + id, null);
  }

  public List<Persona> getAllPersona() {
    List<Persona> listPersona = new ArrayList<Persona>();
    Cursor cursor = db.query(MyModel.TABLE_PERSONA, allColumns, null, null, null, null, null);
    cursor.moveToFirst();

    while ( !cursor.isAfterLast() ) {
      Persona persona = cursorToPerson(cursor);
      listPersona.add(persona);
      cursor.moveToNext();
    }

    cursor.close();

    return listPersona;
  }
}
