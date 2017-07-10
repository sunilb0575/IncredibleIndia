package com.incredibleindia.android.incredibleindia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExploreIndia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> exploreArrayList = new ArrayList<Word>();

        exploreArrayList.add(new Word(getString(R.string.history), R.drawable.warrior));
        exploreArrayList.add(new Word(getString(R.string.Geography), R.drawable.geo));
        exploreArrayList.add(new Word(getString(R.string.climate), R.drawable.climate));
        exploreArrayList.add(new Word(getString(R.string.religion), R.drawable.religion2));
        exploreArrayList.add(new Word(getString(R.string.animals), R.drawable.animal));
        exploreArrayList.add(new Word(getString(R.string.languages), R.drawable.languages2));
        exploreArrayList.add(new Word(getString(R.string.food), R.drawable.thali));
        exploreArrayList.add(new Word(getString(R.string.entertainemt), R.drawable.entertain));
        exploreArrayList.add(new Word(getString(R.string.world_Inspiration), R.drawable.yoga3));

        MenuWordArrayAdapter menuItemAdapter = new
                MenuWordArrayAdapter(this, exploreArrayList, R.color.color_base);


        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch( position )
                {
                    case 0:  Intent historyIntent = new Intent(ExploreIndia.this, HistoryActivity.class);
                        startActivity(historyIntent);
                        break;
                    case 1:  Intent geoIntent = new Intent(ExploreIndia.this, Geography.class);
                        startActivity(geoIntent);
                        break;
                    case 2:  Intent climateIntent = new Intent(ExploreIndia.this, Climate.class);
                        startActivity(climateIntent);
                        break;
                    case 3:  Intent religionIntent = new Intent(ExploreIndia.this, Religion.class);
                        startActivity(religionIntent);
                        break;
                    case 4:  Intent animalsIntent = new Intent(ExploreIndia.this, Animals.class);
                        startActivity(animalsIntent);
                        break;
                    case 5:  Intent languagesIntent = new Intent(ExploreIndia.this, Languages.class);
                        startActivity(languagesIntent);

                        Context context = getApplicationContext();
                        CharSequence text = "Learn Basic Hindi pronunciation";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        break;
                    case 6:  Intent foodIntent = new Intent(ExploreIndia.this, Food.class);
                        startActivity(foodIntent);
                        break;
                    case 7:  Intent entertainmentIntent = new Intent(ExploreIndia.this, Entertainment.class);
                        startActivity(entertainmentIntent);
                        break;
                    case 8:  Intent inspirationIntent = new Intent(ExploreIndia.this, Yoga.class);
                        startActivity(inspirationIntent);
                        break;
                }
            }

        });



    }
}
