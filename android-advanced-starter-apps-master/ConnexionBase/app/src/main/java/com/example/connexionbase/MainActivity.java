package com.example.connexionbase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ClasseBase std = new ClasseBase(this.getApplicationContext());
        SQLiteDatabase db =std.getWritableDatabase();
        //insertion sur la base
        String insert1="insert into student(id,name) values ('1','jo')";
       // db.execSQL(insert1);
        String insert2="insert into student(id,name) values ('2','jo')";
       // db.execSQL(insert2);
//another method
       // ContentValues cv =new ContentValues();
       // cv.put("id","30");
       // cv.put("name","ade");
       // db.insert("student",null,cv);
        //selection
        Cursor cur = db.query("student",null,null,null,null,null,null);
        cur.moveToFirst();
        while (!cur.isAfterLast()){
            Log.i(":MAINACTIVITY","id "+cur.getString(0)+ " name "+cur.getString(1));
            cur.moveToNext();
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
