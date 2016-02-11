package com.example.sylvain.applicationmeteo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


public class listActivity extends ActionBarActivity {
    SharedPreferences preferences ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        this.preferences = getSharedPreferences(Variables.VAR_NOM,0);

        ListView lv = (ListView) findViewById(R.id.stationList);
        lv.setAdapter(new listActivityAdapter(stationList.stationList, this));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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



    public void changeFavorite(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Variables.VAR_ID_FAVORITE_STATION, (String)view.getTag());
        editor.apply();
        Toast.makeText(this,"Vous avez bien définie la station "+(String)view.getTag()+" comme favorite", Toast.LENGTH_SHORT).show();
    }
    public void goToDetail(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("id", (String)view.getTag());
        this.startActivity(intent);
    }
}
