package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;



public class DuringIndependence extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> duringArrayList = new ArrayList<Word>();

        duringArrayList.add(new Word(getString(R.string.mahatma_gandhi), R.drawable.gandhi2));
        duringArrayList.add(new Word(getString(R.string.bhagath_singh), R.drawable.bhagath_icon));
        duringArrayList.add(new Word(getString(R.string.babasaheb_ambedkar), R.drawable.ambedkar));
        duringArrayList.add(new Word(getString(R.string.sardar_vallabhai), R.drawable.sardar_patel));
        duringArrayList.add(new Word(getString(R.string.subhas), R.drawable.subhas));
        duringArrayList.add(new Word(getString(R.string.lakshmi), R.drawable.laxmi_bai));
        duringArrayList.add(new Word(getString(R.string.nehru), R.drawable.nehru));
        duringArrayList.add(new Word(getString(R.string.lal_bhadur), R.drawable.lal_bahadur_shastri));

        MenuWordArrayAdapter menuItemAdapter = new
                MenuWordArrayAdapter(this, duringArrayList, R.color.color_base);


        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch( position )
                {
                    case 0:  Intent gandhiIntent = new Intent(DuringIndependence.this, Gandhi.class);
                        startActivity(gandhiIntent);
                        break;
                    case 1:  Intent bhagatIntent = new Intent(DuringIndependence.this, BhagatSingh.class);
                        startActivity(bhagatIntent);
                        break;
                    case 2:  Intent ambedkarIntent = new Intent(DuringIndependence.this, Ambedkar.class);
                        startActivity(ambedkarIntent);
                        break;
                    case 3:  Intent sardariIntent = new Intent(DuringIndependence.this, SardarPatel.class);
                        startActivity(sardariIntent);
                        break;
                    case 4:  Intent subhasIntent = new Intent(DuringIndependence.this, SubhasChandra.class);
                        startActivity(subhasIntent);
                        break;
                    case 5:  Intent lakshmiIntent = new Intent(DuringIndependence.this, LakshmiBai.class);
                        startActivity(lakshmiIntent);
                        break;

                    case 6:  Intent nehruIntent = new Intent(DuringIndependence.this, Nehru.class);
                        startActivity(nehruIntent);
                        break;
                    case 7:  Intent lalBhadurIntent = new Intent(DuringIndependence.this, LalBhadur.class);
                        startActivity(lalBhadurIntent);
                        break;
                }
            }

        });



    }
}
