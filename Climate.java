package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;



public class Climate extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> climateArrayList = new ArrayList<Word>();

        climateArrayList.add(new Word(getString(R.string.winter), R.drawable.winter));
        climateArrayList.add(new Word(getString(R.string.summer), R.drawable.summer));
        climateArrayList.add(new Word(getString(R.string.monsoon), R.drawable.rain));
        climateArrayList.add(new Word(getString(R.string.post_monsoon), R.drawable.peacock2));

        MenuWordArrayAdapter menuItemAdapter = new
                MenuWordArrayAdapter(this, climateArrayList, R.color.color_green);


        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch( position )
                {
                    case 0:  Intent climateIntent = new Intent(Climate.this, Winter.class);
                        startActivity(climateIntent);
                        break;
                    case 1:  Intent summerIntent = new Intent(Climate.this, Summer.class);
                        startActivity(summerIntent);
                        break;
                    case 2:  Intent monsoonIntent = new Intent(Climate.this, Monsoon.class);
                        startActivity(monsoonIntent);
                        break;
                    case 3:  Intent postMonsoonIntent = new Intent(Climate.this, PostMonsoon.class);
                        startActivity(postMonsoonIntent);
                        break;
                }
            }

        });



    }
}


