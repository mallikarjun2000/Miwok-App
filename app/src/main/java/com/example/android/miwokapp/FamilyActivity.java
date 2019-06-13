package com.example.android.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        final ArrayList<MiwokArray> miwokfamilywords = new ArrayList<>();

        miwokfamilywords.add(new MiwokArray("father", "әpә", R.mipmap.family_father, R.raw.family_father));
        miwokfamilywords.add(new MiwokArray("mother", "әṭa", R.mipmap.family_mother, R.raw.family_mother));
        miwokfamilywords.add(new MiwokArray("son", "angsi", R.mipmap.family_son, R.raw.family_son));
        miwokfamilywords.add(new MiwokArray("daughter", "tune", R.mipmap.family_daughter, R.raw.family_daughter));
        miwokfamilywords.add(new MiwokArray("older brother", "taachi", R.mipmap.family_older_brother, R.raw.family_older_brother));
        miwokfamilywords.add(new MiwokArray("younger brother", "chalitti", R.mipmap.family_younger_brother, R.raw.family_younger_brother));
        miwokfamilywords.add(new MiwokArray("older sister", "teṭe", R.mipmap.family_older_sister, R.raw.family_older_sister));
        miwokfamilywords.add(new MiwokArray("younger sister", "kolliti", R.mipmap.family_younger_sister, R.raw.family_younger_sister));
        miwokfamilywords.add(new MiwokArray("grandmother", "ama", R.mipmap.family_grandmother, R.raw.family_grandmother));
        miwokfamilywords.add(new MiwokArray("grandfather", "paapa", R.mipmap.family_grandfather, R.raw.family_grandfather));


        CustomAdapter adapter = new CustomAdapter(this, miwokfamilywords);

        ListView listview = (ListView) findViewById(R.id.family_list);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MiwokArray miwokArray = miwokfamilywords.get(position);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(FamilyActivity.this, miwokArray.getmAudioResourseID());
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
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
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
