package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class PresentLeaders extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.word_list);


    final ArrayList<Word> presentLeadersArrayList = new ArrayList<Word>();

    presentLeadersArrayList.add(new Word(getString(R.string.modi), R.drawable.modi));
    presentLeadersArrayList.add(new Word(getString(R.string.rajnath), R.drawable.rajnath));
    presentLeadersArrayList.add(new Word(getString(R.string.sushma_swaraj), R.drawable.sushma_swaraj));
    presentLeadersArrayList.add(new Word(getString(R.string.arun), R.drawable.arun_jaitley));
    presentLeadersArrayList.add(new Word(getString(R.string.venkai), R.drawable.venkaiah));
    presentLeadersArrayList.add(new Word(getString(R.string.nitin_gadkari), R.drawable.nitin_gadkari));
    presentLeadersArrayList.add(new Word(getString(R.string.smriti), R.drawable.smriti));

    MenuWordArrayAdapter menuItemAdapter = new
            MenuWordArrayAdapter(this, presentLeadersArrayList, R.color.color_base);


    ListView listView = (ListView) findViewById(R.id.word_list);

    listView.setAdapter(menuItemAdapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch( position )
            {
                case 0:  Intent modiIntent = new Intent(PresentLeaders.this, Modi.class);
                    startActivity(modiIntent);
                    break;
                case 1:  Intent rajnathIntent = new Intent(PresentLeaders.this, Rajnath.class);
                    startActivity(rajnathIntent);
                    break;
                case 2:  Intent sushmaIntent = new Intent(PresentLeaders.this, Sushma.class);
                    startActivity(sushmaIntent);
                    break;
                    case 3:  Intent arunIntent = new Intent(PresentLeaders.this, Arun.class);
                        startActivity(arunIntent);
                        break;
                case 4:  Intent venkaiIntent = new Intent(PresentLeaders.this, Venkai.class);
                    startActivity(venkaiIntent);
                    break;
                case 5:  Intent nitinIntent = new Intent(PresentLeaders.this, Nitin.class);
                    startActivity(nitinIntent);
                    break;
                case 6:  Intent smritiIntent = new Intent(PresentLeaders.this, Smriti.class);
                    startActivity(smritiIntent);
                    break;
            }
        }

    });



}
}
