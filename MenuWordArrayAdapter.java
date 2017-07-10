package com.incredibleindia.android.incredibleindia;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MenuWordArrayAdapter extends ArrayAdapter<Word> {

    //background color
    private int mColorResourceID;

    public MenuWordArrayAdapter (Activity context, ArrayList<Word> words, int colorResourceId){


        super(context, 0, words);
        mColorResourceID = colorResourceId;

    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
//        return super.getView(position, convertView, parent);
// Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_menu_item_lists, parent, false);
        }


        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the word_list layout with the ID textView_default_word
        TextView textViewItemName = (TextView) listItemView.findViewById(R.id.item_name_textview);
        // Get the word description from the current Word object and
        // set this text on the textViewWordDescription
        textViewItemName.setText(currentWord.getmWordDescription());


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageViewItemImage = (ImageView) listItemView.findViewById(R.id.item_image_imageview);
        // Get the image resource ID from the current word object and
        // set the image to iconView


        imageViewItemImage.setImageResource(currentWord.getmImageResourceId());



        //setting the theme color for the list item

        View textContainer = listItemView.findViewById(R.id.activity_menu_item_lists);
        //find the color which need to be applied for the particular category
        int color = ActivityCompat.getColor(getContext(), mColorResourceID);
        //set the background color for the text container
        textContainer.setBackgroundColor(color);



        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }

}
