package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Area extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> himalayasArrayList = new ArrayList<Word>();

        himalayasArrayList.add(new Word(getString(R.string.lat_lon), R.drawable.lat_long2));
        himalayasArrayList.add(new Word(getString(R.string.area_covered), R.drawable.area_covered));
        himalayasArrayList.add(new Word(getString(R.string.water_bodies), R.drawable.water_bodies));
        himalayasArrayList.add(new Word(getString(R.string.himalayas), R.drawable.himalayas));

        MenuWordArrayAdapter menuItemAdapter = new
                MenuWordArrayAdapter(this, himalayasArrayList, R.color.color_geography);


        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);

    }
}
