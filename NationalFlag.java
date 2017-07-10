package com.incredibleindia.android.incredibleindia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class NationalFlag extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description_view);


        //ScrollView (parent layout)(activity_item_description) inside which another
        // child(linear layout)(activity_item_description) is inflated or added
        ScrollView itemDescView = (ScrollView) findViewById(R.id.activity_item_description_view);

        //add or inflate the child layout(activity_item_description)
        View view = getLayoutInflater().inflate(R.layout.activity_item_description, itemDescView,false);


        //set item Image
        ImageView itemDescImage = (ImageView) view.findViewById(R.id.item_des_image);
        itemDescImage.setImageResource(R.drawable.flag);

        //set title for the item, position: below image
        TextView itemTitleText = (TextView) view.findViewById(R.id.item_des_title_textview);
        itemTitleText.setText(R.string.flag);


        //set item breif description, position: below title
        TextView itemDescText = (TextView) view.findViewById(R.id.item_des_textview);
        itemDescText.setText(R.string.national_flag_description);



        //add the view to the activity_item_description_view
        itemDescView.addView(view);



    }
}
