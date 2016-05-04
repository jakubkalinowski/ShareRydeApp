package com.example.jakubkalinowski.sharerydeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    /**
     * ArrayAdapter that converts code to the view
     * @param context
     * @param notification
     */
    public CustomAdapter(Context context, String[] notification) {
        super(context, R.layout.custom_row, notification);
    }

    /**
     * This is how we want to lay out the strings that we passed in
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflater means prepare for rendering, getContext=background info
        LayoutInflater navInflater = LayoutInflater.from(getContext());

        View rowView = convertView;
        if (rowView == null){
            rowView = navInflater.inflate(R.layout.custom_row, parent, false);
        }

        String singleNotificationItem = getItem(position);
        TextView notificationText = (TextView) rowView.findViewById(R.id.customScheduleTextView);

        //assign data
        notificationText.setText(singleNotificationItem);
        //notificationImage.setImageResource(R.drawable.messageicon); //this only shows one icon for all notification

        return rowView;
    }
}
