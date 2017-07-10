package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;



public class Religion extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> religionLeadersArrayList = new ArrayList<Word>();

        religionLeadersArrayList.add(new Word(getString(R.string.hinduism), R.drawable.aum));
        religionLeadersArrayList.add(new Word(getString(R.string.islam), R.drawable.islam_icon));
        religionLeadersArrayList.add(new Word(getString(R.string.christianity), R.drawable.jesus_icon));
        religionLeadersArrayList.add(new Word(getString(R.string.buddhism), R.drawable.buddhism_icon));
        religionLeadersArrayList.add(new Word(getString(R.string.jainism), R.drawable.jainism));
        religionLeadersArrayList.add(new Word(getString(R.string.sikhism), R.drawable.sikh_icon));

        MenuWordArrayAdapter menuItemAdapter = new
                MenuWordArrayAdapter(this, religionLeadersArrayList, R.color.color_red);


        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch( position )
                {
                    case 0:  Intent hinduIntent = new Intent(Religion.this, Hinduism.class);
                        startActivity(hinduIntent);
                        break;
                    case 1:  Intent islamIntent = new Intent(Religion.this, Islam.class);
                        startActivity(islamIntent);
                        break;
                    case 2:  Intent chrisIntent = new Intent(Religion.this, Christianity.class);
                        startActivity(chrisIntent);
                        break;
                    case 3:  Intent buddhismIntent = new Intent(Religion.this, Buddhism.class);
                        startActivity(buddhismIntent);
                        break;
                    case 4:  Intent jainIntent = new Intent(Religion.this, Jainism.class);
                        startActivity(jainIntent);
                        break;
                    case 5:  Intent sikhIntent = new Intent(Religion.this, Sikhism.class);
                        startActivity(sikhIntent);
                        break;
                }
            }

        });



    }
}

