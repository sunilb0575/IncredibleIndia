package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;



public class Languages extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> languagesArrayList = new ArrayList<Word>();

        languagesArrayList.add(new Word(getString(R.string.hindi), R.drawable.hindi));
        languagesArrayList.add(new Word(getString(R.string.telugu), R.drawable.telugu));
        languagesArrayList.add(new Word(getString(R.string.bengali), R.drawable.bengali));
        languagesArrayList.add(new Word(getString(R.string.gujrati), R.drawable.gujrati));
        languagesArrayList.add(new Word(getString(R.string.kannada), R.drawable.kannada));
        languagesArrayList.add(new Word(getString(R.string.malayalam), R.drawable.malyalam));
        languagesArrayList.add(new Word(getString(R.string.marathi), R.drawable.marthi));
        languagesArrayList.add(new Word(getString(R.string.tamil), R.drawable.tamil));
        languagesArrayList.add(new Word(getString(R.string.urdu), R.drawable.urdu));
        languagesArrayList.add(new Word(getString(R.string.odia), R.drawable.odia));
        languagesArrayList.add(new Word(getString(R.string.punjabi), R.drawable.punjabi));
        languagesArrayList.add(new Word(getString(R.string.assamese), R.drawable.assamese));




        MenuWordArrayAdapter menuItemAdapter = new
                MenuWordArrayAdapter(this, languagesArrayList, R.color.color_blue);

        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch( position )
                {
                    case 0:  Intent hindiIntent = new Intent(Languages.this, Hindi.class);
                        startActivity(hindiIntent);
                        break;
                    case 1:  Intent teluguIntent = new Intent(Languages.this, Telugu.class);
                        startActivity(teluguIntent);
                        break;
                    case 2:  Intent bengaliIntent = new Intent(Languages.this, Bengali.class);
                        startActivity(bengaliIntent);
                        break;
                    case 3:  Intent gujrathiIntent = new Intent(Languages.this, Gujrathi.class);
                        startActivity(gujrathiIntent);
                        break;
                    case 4:  Intent kannadaIntent = new Intent(Languages.this, Kannada.class);
                        startActivity(kannadaIntent);
                        break;
                    case 5:  Intent malyalamIntent = new Intent(Languages.this, Malyalam.class);
                        startActivity(malyalamIntent);
                        break;
                    case 6:  Intent marathiIntent = new Intent(Languages.this, Marathi.class);
                        startActivity(marathiIntent);
                        break;
                    case 7:  Intent tamilIntent = new Intent(Languages.this, Tamil.class);
                        startActivity(tamilIntent);
                        break;
                    case 8:  Intent urduIntent = new Intent(Languages.this, Urdu.class);
                        startActivity(urduIntent);
                        break;
                    case 9:  Intent odiaIntent = new Intent(Languages.this, Odia.class);
                        startActivity(odiaIntent);
                        break;
                    case 10:  Intent punjabiIntent = new Intent(Languages.this, Punjabi.class);
                        startActivity(punjabiIntent);
                        break;
                    case 11:  Intent assameseIntent = new Intent(Languages.this, Assamese.class);
                        startActivity(assameseIntent);
                        break;
                }
            }

        });


    }
}
