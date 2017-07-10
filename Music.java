package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class Music extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> musicArrayList = new ArrayList<Word>();

        musicArrayList.add(new Word(getString(R.string.ar_reheman), R.drawable.arrehaman));
        musicArrayList.add(new Word(getString(R.string.lata_mangeskar), R.drawable.lata_mangeshkar));
        musicArrayList.add(new Word(getString(R.string.ilyaraja), R.drawable.ilayaraja));
        musicArrayList.add(new Word(getString(R.string.rdburmun), R.drawable.rdburmun));

        MenuWordArrayAdapter menuItemAdapter = new
                MenuWordArrayAdapter(this, musicArrayList, R.color.color_grey);


        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch( position )
                {
                    case 0:  Intent arRehmanIntent = new Intent(Music.this, ArRehman.class);
                        startActivity(arRehmanIntent);
                        break;
                    case 1:  Intent lataIntent = new Intent(Music.this, LataMangeshkar.class);
                        startActivity(lataIntent);
                        break;
                    case 2:  Intent ilyarajaIntent = new Intent(Music.this, Ilyaraja.class);
                        startActivity(ilyarajaIntent);
                        break;
                    case 3:  Intent rdburmanIntent = new Intent(Music.this, RdBurmun.class);
                        startActivity(rdburmanIntent);
                        break;
                }
            }

        });



    }
}
