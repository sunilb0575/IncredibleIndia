package com.incredibleindia.android.incredibleindia;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;



public class StatesActivity extends AppCompatActivity{

    private MediaPlayer mediaPlayer;

    //creating an object for the audio manager, in order to call a requestFocus method
    private AudioManager mAudioManager;



    /**
     +     * This listener gets triggered whenever the audio focus changes
     +     * (i.e., we gain or lose audio focus because of another app or device).
     +     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {

                        // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                        // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                        // our app is allowed to continue playing sound but at a lower volume. We'll treat
                        // both cases the same way because our app is playing short sound files.
                        //audio will be paused temporarily, if some other app ganed the audio focus
                        mediaPlayer.pause();
                        //when our app gains the audio focus back, audio
                        //will be played from the start
                        mediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        //if the audio focus is completely lost
                        // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                        releaseMediaPlayer();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                        mediaPlayer.start();
                    }
                }
            };

    //media player object is created, in order to listen for completion of the media
    //once comleted releaseMediaPlayer() method is called
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        //hide the play button
//        ImageView playIcon = (ImageView) findViewById(R.id.list_item_play);
//        playIcon.setVisibility(View.GONE);

        // Create and setup the {@link AudioManager} to request audio focus services
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //declaring ArrayList for states list
        final ArrayList<Word> statesArrayList = new ArrayList<Word>();



        statesArrayList.add(new Word(getString(R.string.hyderabad),getString(R.string.andhra), R.drawable.ic_ap, R.raw.andhra));
        statesArrayList.add(new Word(getString(R.string.itanagar),getString(R.string.arunachal), R.drawable.ic_ar, R.raw.arunachal));
        statesArrayList.add(new Word(getString(R.string.dispur),getString(R.string.assam), R.drawable.ic_as, R.raw.assam));
        statesArrayList.add(new Word(getString(R.string.patna), getString(R.string.bihar), R.drawable.ic_br, R.raw.bihar));
        statesArrayList.add(new Word(getString(R.string.raipur),getString(R.string.chattisgarh), R.drawable.ic_ct, R.raw.chattish));
        statesArrayList.add(new Word(getString(R.string.panaji), getString(R.string.goa), R.drawable.ic_ga, R.raw.goa));
        statesArrayList.add(new Word(getString(R.string.gandhinagar), getString(R.string.gujrat), R.drawable.ic_gj, R.raw.gujrat));
        statesArrayList.add(new Word(getString(R.string.chandigarh), getString(R.string.haryana), R.drawable.ic_hr, R.raw.haryana));
        statesArrayList.add(new Word(getString(R.string.shimla), getString(R.string.hp), R.drawable.ic_hp, R.raw.himachal));
        statesArrayList.add(new Word(getString(R.string.srinagar), getString(R.string.jnk), R.drawable.ic_jk, R.raw.kashimr));
        statesArrayList.add(new Word(getString(R.string.ranchi), getString(R.string.jharghand), R.drawable.ic_jh, R.raw.jharkhand));
        statesArrayList.add(new Word(getString(R.string.begaluru), getString(R.string.karnataka), R.drawable.ic_ka, R.raw.karnataka));
        statesArrayList.add(new Word(getString(R.string.thiruvanta), getString(R.string.kerala), R.drawable.ic_kl, R.raw.kerala));
        statesArrayList.add(new Word(getString(R.string.bhopal), getString(R.string.mp), R.drawable.ic_mp, R.raw.mp));
        statesArrayList.add(new Word(getString(R.string.mumbai), getString(R.string.mh), R.drawable.ic_mh, R.raw.mh));
        statesArrayList.add(new Word(getString(R.string.imphal), getString(R.string.manipur), R.drawable.ic_mn, R.raw.manipur));
        statesArrayList.add(new Word(getString(R.string.shilong), getString(R.string.meghalaya), R.drawable.ic_ml, R.raw.megha));
        statesArrayList.add(new Word(getString(R.string.aizawl), getString(R.string.mizoram), R.drawable.ic_mz, R.raw.mizorm));
        statesArrayList.add(new Word(getString(R.string.kohima), getString(R.string.nagaland), R.drawable.ic_nl, R.raw.nagaland));
        statesArrayList.add(new Word(getString(R.string.bhubaneshwar), getString(R.string.orissa), R.drawable.ic_or, R.raw.od));
        statesArrayList.add(new Word(getString(R.string.chandigarh), getString(R.string.punjab), R.drawable.ic_pb, R.raw.pb));
        statesArrayList.add(new Word(getString(R.string.jaipur), getString(R.string.rj), R.drawable.ic_rj, R.raw.rj));
        statesArrayList.add(new Word(getString(R.string.gangtok), getString(R.string.sikkim), R.drawable.ic_sk, R.raw.skkim));
        statesArrayList.add(new Word(getString(R.string.chennai), getString(R.string.tn), R.drawable.ic_tn, R.raw.tn));
        statesArrayList.add(new Word(getString(R.string.hyderabad), getString(R.string.tg), R.drawable.ic_tg, R.raw.tg));
        statesArrayList.add(new Word(getString(R.string.agartala), getString(R.string.tripura), R.drawable.ic_tr, R.raw.tripura));
        statesArrayList.add(new Word(getString(R.string.lucknow), getString(R.string.up), R.drawable.ic_up, R.raw.up));
        statesArrayList.add(new Word(getString(R.string.dehradun), getString(R.string.uttarakhand), R.drawable.ic_ut, R.raw.uttarakhnad));
        statesArrayList.add(new Word(getString(R.string.kolkata), getString(R.string.wb), R.drawable.ic_wb, R.raw.wb));



        WordArrayAdapter itemsAdapter =
                new WordArrayAdapter(this, statesArrayList, R.color.color_geography);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xmlout file.
        ListView listView = (ListView) findViewById(R.id.word_list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);


        //this will create on item click listener for the item of the list view

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            // Here the media player object is created
            @Override
            //onItemClick is an interface, hence we need to declare our own methods.
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //this will get each word stored in an each array of wordsArrayLists and store in word varaible of type Word(class)
                Word word = statesArrayList.get(position);

                //releaseMediaPlayer method is called here,because when a user tries to
                //play another audio before the present audio is completed
                releaseMediaPlayer();

                //here requestAudioFocus method is called, and
                //it is checked with boolean constant AUDIOFOCUS_REQUEST_GRANTED

                int audioFocusStatus = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(audioFocusStatus == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //As MediaPlayer is static it can be used as className.create
                    //third paramater: the position is sent to word class constructor,
                    //and from getaudioResourceId() method, the resource id of the particular audio file is returned
                    mediaPlayer = MediaPlayer.create(StatesActivity.this, word.getmAudioResourceID());
                    //this will play the audio
                    mediaPlayer.start();
                    //mediaPlayer object is used to setOnCompletionListener on completionListener varaible
                    // which is MediaPlayer.OnCompletionListener type
                    mediaPlayer.setOnCompletionListener(completionListener);
                }

            }
        });





        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

    }



    //if the app is closed in middle of the media player is playing a audio,
    //relasesMediaPlayer() should be called


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            //once the audio is played, audio focus should be released
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }




}
