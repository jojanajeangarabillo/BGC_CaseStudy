package com.example.bgc_casestudy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MoodCheckinFragment extends Fragment {

    private TextView dateTimeText;
    private EditText otherInput;
    private Button checkInBtn;

    // Mood data arrays
    private final String[] moodNames = {
            "Happy", "Sad", "Embarrassed", "Bored",
            "Anxious", "Envious", "Disgust", "Angry"
    };

    private final int[] moodIcons = {
            R.drawable.joy, R.drawable.sadness, R.drawable.embarrassment, R.drawable.boredom,
            R.drawable.anxiety, R.drawable.envy, R.drawable.disgust, R.drawable.anger
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mood_checkin, container, false);

        dateTimeText = view.findViewById(R.id.dateTimeText);
        otherInput = view.findViewById(R.id.otherInput);
        checkInBtn = view.findViewById(R.id.checkInBtn);
        GridLayout moodGrid = view.findViewById(R.id.moodGrid);

        // Set current date/time
        String currentDateTime = new SimpleDateFormat("EEEE, MMM d hh:mm a", Locale.getDefault())
                .format(new Date());
        dateTimeText.setText(currentDateTime);

        // Dynamically add mood items to grid
        LayoutInflater itemInflater = LayoutInflater.from(getContext());
        for (int i = 0; i < moodNames.length; i++) {
            View moodItem = itemInflater.inflate(R.layout.mood_item, moodGrid, false);

            ImageView moodIcon = moodItem.findViewById(R.id.moodIcon);
            TextView moodLabel = moodItem.findViewById(R.id.moodLabel);

            moodIcon.setImageResource(moodIcons[i]);
            moodLabel.setText(moodNames[i]);

            moodGrid.addView(moodItem);
        }

        checkInBtn.setOnClickListener(v -> {
            String otherMood = otherInput.getText().toString().trim();
            Toast.makeText(getContext(), "Checked in mood: " + otherMood, Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
