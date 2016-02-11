package com.example.sylvain.applicationmeteo;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sylvain on 10/02/2016.
 */
public class listActivityAdapter implements ListAdapter {


    ArrayList<Station> listStation ;
    Context context ;

    public listActivityAdapter(ArrayList<Station> listStation,Context context){
        this.listStation = listStation ;
        this.context = context ;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return stationList.stationList.size();
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(stationList.stationList.get(position).getIdStation());
    }

    @Override
    public Object getItem(int position) {
        return stationList.stationList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView  == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.activity_item_list, parent, false);
        }
        Station runningStation =(Station)getItem(position) ;

        TextView textViewStation = (TextView) convertView.findViewById(R.id.idStation);
        Button buttonFavorite = (Button) convertView.findViewById(R.id.buttonAddFavorite);
        Button buttonDetail = (Button) convertView.findViewById(R.id.expandButton);

        buttonDetail.setTag(runningStation.getIdStation());
        textViewStation.setText(runningStation.getLibelleStation());
        textViewStation.setTag(runningStation.getIdStation());
        buttonFavorite.setTag(runningStation.getIdStation());


        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}


