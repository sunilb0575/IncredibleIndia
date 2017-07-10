package com.incredibleindia.android.incredibleindia;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;



public class NationalAnthem extends AppCompatActivity {

    //creating a media player object
    MediaPlayer mediaPlayer = new MediaPlayer();

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
        setContentView(R.layout.activity_item_description_view);


        // Create and setup the {@link AudioManager} to request audio focus services
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        //ScrollView (parent layout)(activity_item_description_view) inside which another
        // child(linear layout)(activity_item_description) is inflated or added
        ScrollView itemDescView = (ScrollView) findViewById(R.id.activity_item_description_view);

        //add or inflate the child layout(activity_item_description)
        View view = getLayoutInflater().inflate(R.layout.activity_item_description, itemDescView,false);


        //set item Image
        ImageView itemDescImage = (ImageView) view.findViewById(R.id.item_des_image);
        itemDescImage.setImageResource(R.drawable.tagore);

        //set title for the item, position: below image
        TextView itemTitleText = (TextView) view.findViewById(R.id.item_des_title_textview);
        itemTitleText.setText(R.string.rabindranath_tagore);


        //set item breif description, position: below title
        TextView itemDescText = (TextView) view.findViewById(R.id.item_des_textview);
        itemDescText.setText(R.string.national_anthem_description);


        //add the view to the activity_item_description_view
        itemDescView.addView(view);


        // Set a click listener on image
        itemDescImage.setOnClickListener(new View.OnClickListener() {


                // The code in this method will be executed when the image is clicked on.
            @Override
            public void onClick(View view) {

                //releaseMediaPlayer method is called here,because when a user clicks the
                // image again before the present audio is completed
                releaseMediaPlayer();



                //here requestAudioFocus method is called, and
                //it is checked with boolean constant AUDIOFOCUS_REQUEST_GRANTED

                int audioFocusStatus = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(audioFocusStatus == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    //reading audio file from R.raw. and storing in the object mediaPlayer
                    mediaPlayer = MediaPlayer.create(NationalAnthem.this, R.raw.jana_gana_mana_lata_mangeshkar);


                    mediaPlayer.start();

                    //mediaPlayer object is used to setOnCompletionListener on completionListener varaible
                    // which is MediaPlayer.OnCompletionListener type
                    mediaPlayer.setOnCompletionListener(completionListener);

                }

            }
        });



    }



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
