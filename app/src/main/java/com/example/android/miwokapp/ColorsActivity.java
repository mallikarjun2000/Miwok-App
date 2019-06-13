package com.example.android.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final ArrayList<MiwokArray> colorswords = new ArrayList<MiwokArray>();

        colorswords.add(new MiwokArray("red", "weṭeṭṭi", R.mipmap.color_red, R.raw.color_red));
        colorswords.add(new MiwokArray("green", "chokokki", R.mipmap.color_green, R.raw.color_green));
        colorswords.add(new MiwokArray("brown", "ṭakaakki", R.mipmap.color_brown, R.raw.color_brown));
        colorswords.add(new MiwokArray("gray", "ṭopoppi", R.mipmap.color_gray, R.raw.color_gray));
        colorswords.add(new MiwokArray("black", "kululli", R.mipmap.color_black, R.raw.color_black));
        colorswords.add(new MiwokArray("white", "kelelli", R.mipmap.color_white, R.raw.color_white));
        colorswords.add(new MiwokArray("dusty yellow", "ṭopiisә", R.mipmap.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorswords.add(new MiwokArray("mustard yellow", "chiwiiṭә", R.mipmap.color_mustard_yellow, R.raw.color_mustard_yellow));

        CustomAdapter adapter = new CustomAdapter(this, colorswords);

        ListView listview = findViewById(R.id.color_id);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MiwokArray mA = colorswords.get(position);

                releaseMediaPlayer();

                mediaPlayer1 = MediaPlayer.create(ColorsActivity.this, mA.getmAudioResourseID());
                mediaPlayer1.start();

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
    private void releaseMediaPlayer() {
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

    }
}
