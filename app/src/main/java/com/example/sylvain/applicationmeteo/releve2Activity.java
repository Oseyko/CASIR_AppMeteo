package com.example.sylvain.applicationmeteo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class releve2Activity extends ActionBarActivity {
    SharedPreferences preferences ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_releve2);
        this.preferences = getSharedPreferences(Variables.VAR_NOM,0);

        /*releveList test = new releveList();

        test.releveList = new ArrayList<Releve>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateString= "10-10-2015";
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        test.releveList.add(new Releve(date,15,39,7));
        dateString= "18-01-2016";
        date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        test.releveList.add(new Releve(date,22,52,6));
        dateString= "22-01-2016";
        date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        test.releveList.add(new Releve(date,35,68,8));
        dateString= "24-01-2016";
        date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        test.releveList.add(new Releve(date,56,55,4));*/
        ListView tr = (ListView) findViewById(R.id.releveList);
        tr.setAdapter(new releveActivityAdapter(this,releveList.releveList));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_releve2, menu);
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
