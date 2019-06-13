package com.example.android.miwokapp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<MiwokArray> {
    public CustomAdapter(Activity context, ArrayList<MiwokArray> miwokArrays) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, miwokArrays);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        MiwokArray currentMiwokArray = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView MiwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        MiwokTextView.setText(""+currentMiwokArray.getmMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView DefaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        DefaultTextView.setText(currentMiwokArray.getmDefaultTranslation());

        ImageView imageview = (ImageView)listItemView.findViewById(R.id.miwok_image_view);


        imageview.setImageResource(currentMiwokArray.getImageResourceID());
        //MediaPlayer mediaPlayer;
        //mediaPlayer = MediaPlayer.create(this,R.raw.number_one);
        //mediaPlayer.start();
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
