package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;



public class Hindi extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> hindiArrayList = new ArrayList<Word>();

        hindiArrayList.add(new Word(getString(R.string.numbers), R.drawable.numbers));
        hindiArrayList.add(new Word(getString(R.string.family_members), R.drawable.family ));
        hindiArrayList.add(new Word(getString(R.string.colors), R.drawable.colors));
        hindiArrayList.add(new Word(getString(R.string.phrases), R.drawable.phrases));

        MenuWordArrayAdapter  menuItemAdapter = new
                MenuWordArrayAdapter(this, hindiArrayList, R.color.color_blue);

        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent numbersIntent = new Intent(Hindi.this, HindiNumbers.class);
                        startActivity(numbersIntent);
                        break;
                    case 1:
                        Intent familyIntent = new Intent(Hindi.this, HindiFamily.class);
                        startActivity(familyIntent);
                        break;
                    case 2:
                        Intent colorIntent = new Intent(Hindi.this, HindiColors.class);
                        startActivity(colorIntent);
                        break;
                    case 3:
                        Intent phrasesIntent = new Intent(Hindi.this, HindiPhrases.class);
                        startActivity(phrasesIntent);
                        break;
                }
            }
        });
    }
}
