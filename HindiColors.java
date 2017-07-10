package com.incredibleindia.android.incredibleindia;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class HindiColors extends AppCompatActivity {

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create and setup the {@link AudioManager} to request audio focus services
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> colorsArrayList = new
                ArrayList<Word>();

        colorsArrayList.add(new Word(getString(R.string.kala),getString(R.string.black), R.drawable.color_black, R.raw.kala));
        colorsArrayList.add(new Word(getString(R.string.lal),getString(R.string.red), R.drawable.color_red, R.raw.lal));
        colorsArrayList.add(new Word(getString(R.string.hara),getString(R.string.green), R.drawable.color_green, R.raw.hara));
        colorsArrayList.add(new Word(getString(R.string.safed), getString(R.string.white), R.drawable.color_white, R.raw.safed));
        colorsArrayList.add(new Word(getString(R.string.bhura),getString(R.string.brown), R.drawable.color_brown, R.raw.bhura));
        colorsArrayList.add(new Word(getString(R.string.slatey), getString(R.string.gray), R.drawable.color_gray, R.raw.slatey));
        colorsArrayList.add(new Word(getString(R.string.dhul_bhari_pila), getString(R.string.dusty_yellow), R.drawable.color_dusty_yellow, R.raw.dhul_bhari_piley));
        colorsArrayList.add(new Word(getString(R.string.pila), getString(R.string.yellow), R.drawable.color_mustard_yellow, R.raw.pila));

        WordArrayAdapter itemsAdapter =
                new WordArrayAdapter(this, colorsArrayList, R.color.color_blue);



        ListView listView = (ListView) findViewById(R.id.word_list);

        listView.setAdapter(itemsAdapter);


        //this will create on item click listener for the item of the list view

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            // Here the media player object is created
            @Override
            //onItemClick is an interface, hence we need to declare our own methods.
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //this will get each word stored in an each array of wordsArrayLists and store in word varaible of type Word(class)
                Word word = colorsArrayList.get(position);

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
                    mediaPlayer = MediaPlayer.create(HindiColors.this, word.getmAudioResourceID());
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
