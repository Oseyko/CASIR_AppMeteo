package com.example.sylvain.applicationmeteo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends ActionBarActivity {
    SharedPreferences prefs ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.prefs = getSharedPreferences(Variables.VAR_NOM,0);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        if(id != null){
            displayStation(id);
        }else{
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(Variables.VAR_ID_STATION, "Alboussière") ;
            editor.apply();

            stationList.stationList = new ArrayList<Station>();
            stationList.stationList.add(new Station("Alboussière", "Station d'Albousière", "50", "75", "100"));
            stationList.stationList.get(0).toggleFavorite();
            stationList.stationList.add(new Station("Crussol", "Station de Crussol", "72", "58", "125"));
            stationList.stationList.add(new Station("AutreStation", "Une autre station", "25", "52", "239"));

            releveList.releveList = new ArrayList<Releve>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
            String dateString= "10-10-2015";
            Date date = null;
            try {
                date = sdf.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            releveList.releveList.add(new Releve(date,15,39,7));
            dateString= "24-01-2016";
            date = null;
            try {
                date = sdf.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            releveList.releveList.add(new Releve(date,22,52,6));
            dateString= "22-01-2016";
            date = null;
            try {
                date = sdf.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            releveList.releveList.add(new Releve(date,35,68,8));
            dateString= "18-01-2016";
            date = null;
            try {
                date = sdf.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            releveList.releveList.add(new Releve(date,28,98,3));


            displayStation(null);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        if(id != null){
            displayStation(id);
        }else {
            displayStation(null);
        }
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
    public void displayStation(String id){
        TextView textTitle = (TextView) findViewById(R.id.titreStation);
        TextView textLibelle = (TextView) findViewById(R.id.textLibelleStation);
        TextView textLatitudeStation = (TextView) findViewById(R.id.textLatitudeStation);
        TextView textLongitudeStation = (TextView) findViewById(R.id.textLongitudeStation);
        TextView textAltitudeStation = (TextView) findViewById(R.id.textAltitudeStation);
        TextView favoriteStation = (TextView) findViewById(R.id.favoriteStation);
        String idStation;
        if(id != null){
            idStation = id;
        }else{
            idStation = prefs.getString(Variables.VAR_ID_FAVORITE_STATION, "Alboussière") ;
        }
        Station theStation = stationList.getStationById(idStation);

        if(theStation != null){
            textTitle.setText(theStation.getIdStation());
            textLibelle.setText(theStation.getLibelleStation());
            textLatitudeStation.setText(theStation.getLatitudeStation());
            textLongitudeStation.setText(theStation.getLongitudeStation());
            textAltitudeStation.setText(theStation.getAltitudeStation());
            favoriteStation.setText(prefs.getString(Variables.VAR_ID_FAVORITE_STATION, "Alboussière"));
        }
    }

    public void goToList(View v){
        Intent intent = new Intent(this, listActivity.class);
        startActivity(intent);
    }
    public void goToReleve(View v){
        Intent intent = new Intent(this, releve2Activity.class);
        startActivity(intent);
    }
}
