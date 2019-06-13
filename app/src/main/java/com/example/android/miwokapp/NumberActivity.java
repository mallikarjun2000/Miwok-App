package com.example.android.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);





        final ArrayList<MiwokArray> miwokArrays = new ArrayList<>();
        //word.add("One");
        miwokArrays.add(new MiwokArray("one", "lutti",R.mipmap.number_one,R.raw.number_one));
        miwokArrays.add(new MiwokArray("two", "otiiko",R.mipmap.number_two,R.raw.number_two));
        miwokArrays.add(new MiwokArray("three", "tolookosu",R.mipmap.number_three,R.raw.number_three));
        miwokArrays.add(new MiwokArray("four", "oyyisa",R.mipmap.number_four,R.raw.number_four));
        miwokArrays.add(new MiwokArray("five", "massokka",R.mipmap.number_five,R.raw.number_five));
        miwokArrays.add(new MiwokArray("six", "temmokka",R.mipmap.number_six,R.raw.number_six));
        miwokArrays.add(new MiwokArray("seven", "kenekaku",R.mipmap.number_seven,R.raw.number_seven));
        miwokArrays.add(new MiwokArray("eight", "kawinta",R.mipmap.number_eight,R.raw.number_eight));
        miwokArrays.add(new MiwokArray("nine", "wo’e",R.mipmap.number_nine,R.raw.number_nine));
        miwokArrays.add(new MiwokArray("ten", "na’aacha",R.mipmap.number_ten,R.raw.number_ten));


        CustomAdapter adapter = new CustomAdapter(this, miwokArrays);

        ListView listview = findViewById(R.id.list_id);



        listview.setAdapter(adapter);

        /// This is  used to get the current box in listview user clicked
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MiwokArray mA = miwokArrays.get(position);

                //before creating the media player release the mediaplayer
                releaseMediaPlayer();

                mediaPlayer1 = MediaPlayer.create(NumberActivity.this, mA.getmAudioResourseID());
                mediaPlayer1.start();

                //setOncompletion is a method to detect the completed audio file
                mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });

            }
        });

    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer(){
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer1 != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer1.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer1 = null;
        }
    };
}
