package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> historyArrayList = new ArrayList<Word>();

        historyArrayList.add(new Word(getString(R.string.flag), R.drawable.flag2));
        historyArrayList.add(new Word(getString(R.string.national_anthem), R.drawable.national_anthem));
        historyArrayList.add(new Word(getString(R.string.leaders), R.drawable.leaders));


        MenuWordArrayAdapter menuItemAdapter = new
                MenuWordArrayAdapter(this, historyArrayList, R.color.color_base);



        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch( position )
                {
                    case 0:  Intent nationalIntent = new Intent(HistoryActivity.this, NationalFlag.class);
                        startActivity(nationalIntent);
                        break;
                    case 1:  Intent anthemIntent = new Intent(HistoryActivity.this, NationalAnthem.class);
                        startActivity(anthemIntent);
                        break;
                    case 2:  Intent leadersIntent = new Intent(HistoryActivity.this, Leaders.class);
                        startActivity(leadersIntent);
                        break;
//                    case 3:  Intent shivajiIntent = new Intent(ExploreIndia.this, Shivaji.class);
//                        startActivity(shivajiIntent);
//                        break;
                }
            }

        });




    }
}
