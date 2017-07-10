package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;



public class Food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> foodArrayList = new ArrayList<Word>();

        foodArrayList.add(new Word(getString(R.string.biryani), R.drawable.biryani));
        foodArrayList.add(new Word(getString(R.string.dal), R.drawable.daal));
        foodArrayList.add(new Word(getString(R.string.naan), R.drawable.naan));
        foodArrayList.add(new Word(getString(R.string.butter_chicken), R.drawable.butter_chicken));
        foodArrayList.add(new Word(getString(R.string.tandoori_chicken), R.drawable.tandoori_chicken));
        foodArrayList.add(new Word(getString(R.string.chutney), R.drawable.chutney));
        foodArrayList.add(new Word(getString(R.string.dosa), R.drawable.dosa));
        foodArrayList.add(new Word(getString(R.string.chana_masala), R.drawable.chana_masala));
        foodArrayList.add(new Word(getString(R.string.chicken_tikka_masala), R.drawable.chicken_tikka_masala));
        foodArrayList.add(new Word(getString(R.string.samosa), R.drawable.samosa));
        foodArrayList.add(new Word(getString(R.string.pani_puri), R.drawable.pani_puri));
        foodArrayList.add(new Word(getString(R.string.gulab_jamun), R.drawable.gulab_jamun));



        MenuWordArrayAdapter menuItemAdapter = new
                MenuWordArrayAdapter(this, foodArrayList, R.color.color_lime);


        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(menuItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch( position )
                {
                    case 0:  Intent biryaniIntent = new Intent(Food.this, Biryani.class);
                        startActivity(biryaniIntent);
                        break;
                    case 1:  Intent dalIntent = new Intent(Food.this, Dal.class);
                        startActivity(dalIntent);
                        break;
                    case 2:  Intent naanIntent = new Intent(Food.this, Naan.class);
                        startActivity(naanIntent);
                        break;
                    case 3:  Intent butterChickenIntent = new Intent(Food.this, ButterChicken.class);
                        startActivity(butterChickenIntent);
                        break;
                    case 4:  Intent tandooriChickenIntent = new Intent(Food.this, TandooriChicken.class);
                        startActivity(tandooriChickenIntent);
                        break;
                    case 5:  Intent chutneyIntent = new Intent(Food.this, Chutney.class);
                        startActivity(chutneyIntent);
                        break;
                    case 6:  Intent dosaIntent = new Intent(Food.this, Dosa.class);
                        startActivity(dosaIntent);
                        break;
                    case 7:  Intent chanaMasalaIntent = new Intent(Food.this, ChanaMasala.class);
                        startActivity(chanaMasalaIntent);
                        break;
                    case 8:  Intent chickenTikkaMasalaIntent = new Intent(Food.this, ChickenTikkaMasala.class);
                        startActivity(chickenTikkaMasalaIntent);
                        break;
                    case 9:  Intent samosaIntent = new Intent(Food.this, Samosa.class);
                        startActivity(samosaIntent);
                        break;
                    case 10:  Intent paniPuriIntent = new Intent(Food.this, PaniPuri.class);
                        startActivity(paniPuriIntent);
                        break;
                    case 11:  Intent gulabJamunIntent = new Intent(Food.this, GulabJamun.class);
                        startActivity(gulabJamunIntent);
                        break;
                }
            }

        });



    }
}
