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



public class WordArrayAdapter extends ArrayAdapter<Word>{

    //varaibe for color for each category
    private int mColorResourceId;

    public WordArrayAdapter (Activity context, ArrayList<Word> words, int colorResourceId){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a two TextView.
        // Because this is a custom adapter for one TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        //In the third argument is the arraylist object in which the words are saved

        super(context, 0, words);
        mColorResourceId = colorResourceId;

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
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the word_list layout with the ID textView_default_word
        TextView textViewWordDescription = (TextView) listItemView.findViewById(R.id.textView_word_description);
        // Get the word description from the current Word object and
        // set this text on the textViewWordDescription
        textViewWordDescription.setText(currentWord.getmWordDescription());

        // Find the TextView in the word_list layout with the ID textView_lang_word
        TextView textViewLangWord = (TextView) listItemView.findViewById(R.id.textView_lang_word);
        // Get the lang word from the current Word object and
        // set this text on the textViewLangWord
        textViewLangWord.setText(currentWord.getmLangWord());




        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current word object and
        // set the image to iconView

        if (currentWord.hasImage()) {
            iconView.setImageResource(currentWord.getmImageResourceId());
            iconView.setVisibility(View.VISIBLE);

        }
        else {
            iconView.setVisibility(View.GONE);
        }


        //setting the theme color for the list item

        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color which need to be applied for the particular category
        int color = ActivityCompat.getColor(getContext(), mColorResourceId);
        //set the background color for the text container
        textContainer.setBackgroundColor(color);



        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }




}
