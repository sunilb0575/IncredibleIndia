package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Geography extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> geoArrayList = new ArrayList<Word>();

        geoArrayList.add(new Word(getString(R.string.location), R.drawable.location));
        geoArrayList.add(new Word(getString(R.string.states), R.drawable.states));
        geoArrayList.add(new Word(getString(R.string.ut), R.drawable.ut));

        MenuWordArrayAdapter menuItemAdapter = new
                MenuWordArrayAdapter(this, geoArrayList, R.color.color_geography);


        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch( position )
                {
                    case 0:  Intent locationIntent = new Intent(Geography.this, Area.class);
                        startActivity(locationIntent);
                        break;
                    case 1:  Intent statesIntent = new Intent(Geography.this, StatesActivity.class);
                        startActivity(statesIntent);
                        break;
                    case 2:  Intent utIntent = new Intent(Geography.this, UtActivity.class);
                        startActivity(utIntent);
                        break;
//                    case 3:  Intent shivajiIntent = new Intent(ExploreIndia.this, Shivaji.class);
//                        startActivity(shivajiIntent);
//                        break;
                }
            }

        });



    }
}



