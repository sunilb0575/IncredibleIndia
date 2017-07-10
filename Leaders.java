package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Leaders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> leadersArrayList = new ArrayList<Word>();

        leadersArrayList.add(new Word(getString(R.string.during_independence), R.drawable.freedom_fighters));
        leadersArrayList.add(new Word(getString(R.string.present_leaders), R.drawable.gov_india));

        MenuWordArrayAdapter menuItemAdapter = new
                MenuWordArrayAdapter(this, leadersArrayList, R.color.color_base);


        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch( position )
                {
                    case 0:  Intent duringIntent = new Intent(Leaders.this, DuringIndependence.class);
                        startActivity(duringIntent);
                        break;
                    case 1:  Intent presentIntent = new Intent(Leaders.this, PresentLeaders.class);
                        startActivity(presentIntent);
                        break;
//                    case 2:  Intent foodIntent = new Intent(ExploreIndia.this, Food.class);
//                        startActivity(foodIntent);
//                        break;
//                    case 3:  Intent shivajiIntent = new Intent(ExploreIndia.this, Shivaji.class);
//                        startActivity(shivajiIntent);
//                        break;
                }
            }

        });



    }
}
