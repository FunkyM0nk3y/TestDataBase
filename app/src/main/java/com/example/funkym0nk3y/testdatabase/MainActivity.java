package com.example.funkym0nk3y.testdatabase;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends ListActivity {

  private EditText textInput;
  private PersonaDAO datasource;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    datasource = new PersonaDAO(this);
    datasource.open();
    textInput = (EditText) findViewById(R.id.textInput);

    List<Persona> listPersona = new ArrayList<Persona>();
    listPersona = this.datasource.getAllPersona();
    ArrayAdapter<Persona> arrayAdapter = new ArrayAdapter<Persona>(this,android.R.layout.simple_list_item_1, listPersona);
    setListAdapter(arrayAdapter);
  }

  public void onClickButton (View view) {
    ArrayAdapter<Persona> arrayAdapter = (ArrayAdapter<Persona>) getListAdapter();

    switch ( view.getId() ) {
      case R.id.add:
        //String[] nombres = {"Juan", "Pedro", "Mauricio", "Monica", "Roberto"};
        //int nextInt = new Random().nextInt(nombres.length - 1);
        //Persona p = datasource.createPersona(nombres[nextInt]);
        Persona p = datasource.createPersona(this.textInput.getText().toString());
        arrayAdapter.add(p);

        break;
      case  R.id.delete:
        if ( arrayAdapter.getCount() > 0 ) {
          p = (Persona) getListAdapter().getItem(0);
          datasource.deletePersona(p);
          arrayAdapter.remove(p);
        }

        break;
    }
    arrayAdapter.notifyDataSetChanged();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if ( id == R.id.action_settings ) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onRestart() {
    super.onRestart();
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }
}
