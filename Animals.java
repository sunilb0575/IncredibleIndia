package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;



public class Animals extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.word_list);


    final ArrayList<Word> animalsLeadersArrayList = new ArrayList<Word>();

    animalsLeadersArrayList.add(new Word(getString(R.string.elephants), R.drawable.elephant_icon));
    animalsLeadersArrayList.add(new Word(getString(R.string.begal_tiger), R.drawable.tiger_icon));
    animalsLeadersArrayList.add(new Word(getString(R.string.lion), R.drawable.lio_icon));
    animalsLeadersArrayList.add(new Word(getString(R.string.bear), R.drawable.bear));
    animalsLeadersArrayList.add(new Word(getString(R.string.leopard), R.drawable.leopard_icon));
    animalsLeadersArrayList.add(new Word(getString(R.string.langur), R.drawable.langur));
    animalsLeadersArrayList.add(new Word(getString(R.string.peacock), R.drawable.peacock2));
    animalsLeadersArrayList.add(new Word(getString(R.string.cobra), R.drawable.cobra_icon));

    MenuWordArrayAdapter menuItemAdapter = new
            MenuWordArrayAdapter(this, animalsLeadersArrayList, R.color.color_teal);


    ListView listView = (ListView) findViewById(R.id.word_list);

    listView.setAdapter(menuItemAdapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch( position )
            {
                case 0:  Intent elephantIntent = new Intent(Animals.this, Elephant.class);
                    startActivity(elephantIntent);
                    break;
                case 1:  Intent tigerIntent = new Intent(Animals.this, Tiger.class);
                    startActivity(tigerIntent);
                    break;
                case 2:  Intent lionIntent = new Intent(Animals.this, Lion.class);
                    startActivity(lionIntent);
                    break;
                case 3:  Intent bearIntent = new Intent(Animals.this, Bear.class);
                    startActivity(bearIntent);
                    break;
                case 4:  Intent leapordIntent = new Intent(Animals.this, Leapord.class);
                    startActivity(leapordIntent);
                    break;
                case 5:  Intent langurIntent = new Intent(Animals.this, Langur.class);
                    startActivity(langurIntent);
                    break;
                case 6:  Intent peacockIntent = new Intent(Animals.this, Peacock.class);
                    startActivity(peacockIntent);
                    break;
                case 7:  Intent cobraIntent = new Intent(Animals.this, Cobra.class);
                    startActivity(cobraIntent);
                    break;
            }
        }

    });



}
}


