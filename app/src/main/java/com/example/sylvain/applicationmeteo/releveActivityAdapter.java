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
 * Created by Sylvain on 11/02/2016.
 */
public class releveActivityAdapter implements ListAdapter {

    ArrayList<Releve> listReleve;
    Context context;

    public releveActivityAdapter(Context context, ArrayList<Releve> listReleve) {
        this.context = context;
        this.listReleve = listReleve;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return releveList.releveList.size();
    }

    @Override
    public Object getItem(int position) {
        return releveList.releveList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(String.valueOf(releveList.releveList.get(position).getDateReleve()));

    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView  == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.activity_item_releve, parent, false);
        }
        Releve runningReleve =(Releve)getItem(position) ;

        TextView textViewDate = (TextView) convertView.findViewById(R.id.dateItem);
        textViewDate.setText("Date : "+String.valueOf(runningReleve.getDateReleve()));
        TextView textViewT1 = (TextView) convertView.findViewById(R.id.t1Item);
        textViewT1.setText("Température 1 : "+String.valueOf(runningReleve.getTemperatureOne()));
        TextView textViewT2 = (TextView) convertView.findViewById(R.id.t2Item);
        textViewT2.setText("Température 2 : "+String.valueOf(runningReleve.getTemperatureTwo()));
        TextView textViewPressure = (TextView) convertView.findViewById(R.id.pressureItem);
        textViewPressure.setText("Pression : "+String.valueOf(runningReleve.getPressure()));


        return convertView;
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
}
