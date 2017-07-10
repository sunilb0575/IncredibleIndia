package com.incredibleindia.android.incredibleindia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Entertainment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> entertainmentArrayList = new ArrayList<Word>();

        entertainmentArrayList.add(new Word(getString(R.string.music), R.drawable.music));
        entertainmentArrayList.add(new Word(getString(R.string.dance), R.drawable.dance));
        entertainmentArrayList.add(new Word(getString(R.string.cinema), R.drawable.cinema));

        MenuWordArrayAdapter menuItemAdapter = new
                MenuWordArrayAdapter(this, entertainmentArrayList, R.color.color_grey);


        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch( position )
                {
                    case 0:  Intent musicIntent = new Intent(Entertainment.this, Music.class);
                        startActivity(musicIntent);
                        break;
                    case 1:  Intent danceIntent = new Intent(Entertainment.this, Dance.class);
                        startActivity(danceIntent);
                        break;
                    case 2:  Intent cinemaIntent = new Intent(Entertainment.this, Cinema.class);
                        startActivity(cinemaIntent);
                        break;
                }
            }

        });



    }
}
