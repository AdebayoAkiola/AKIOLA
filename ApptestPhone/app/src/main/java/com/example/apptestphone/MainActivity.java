package com.example.apptestphone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //appel
        Button btncall= findViewById(R.id.btnCALL);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent= new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+"778021516"));
                startActivity(intent);
            }
        });

        //sms
        Button btnsms = (Button)findViewById(R.id.btnSMS);
        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentsms= new Intent(Intent.ACTION_SENDTO);
                intentsms.setData(Uri.parse("sendto:"+Uri.encode("781637099")));
                intentsms.putExtra("sms_body","hi Bambey");
                startActivity(intentsms);
            }
        });

        //nouvelle activité
        Button btnNA= findViewById(R.id.btnactv);
        btnNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNA = new Intent(getApplicationContext(),newactivity.class);
                startActivity(intentNA);
            }
        });



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
         //activité help
        if(id==R.id.help){
            Intent intenthelp = new Intent(getApplicationContext(),help.class);
            startActivity(intenthelp);
        }

        return super.onOptionsItemSelected(item);
    }
}
