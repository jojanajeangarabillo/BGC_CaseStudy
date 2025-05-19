package com.example.bgc_casestudy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PopupMoodHistoryActivity extends AppCompatActivity {

    private TextView dateTimeText;
    private LinearLayout moodHistoryContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_mood_history); // Your XML file name

        dateTimeText = findViewById(R.id.dateTimeText);
        moodHistoryContainer = findViewById(R.id.moodHistoryContainer);

        // Set current date and time
        String currentDateAndTime = new SimpleDateFormat("EEEE, MMM dd hh:mm a", Locale.getDefault()).format(new Date());
        dateTimeText.setText(currentDateAndTime);

        // Dummy data for mood entries
        addMoodEntry(R.drawable.joy, "Happy", "Sunday", "May 18 08:30 PM");
        addMoodEntry(R.drawable.boredom, "Bored", "Saturday", "May 17 06:00 PM");
        addMoodEntry(R.drawable.sadness, "Sad", "Friday", "May 16 09:45 AM");
    }

    // Helper to add one mood row
    private void addMoodEntry(int iconResId, String mood, String day, String dateTime) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setPadding(0, 16, 0, 16);
        row.setGravity(android.view.Gravity.CENTER_VERTICAL);

        // Mood Icon
        ImageView moodIcon = new ImageView(this);
        moodIcon.setImageResource(iconResId);
        LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(60, 60);
        iconParams.setMargins(0, 0, 24, 0);
        moodIcon.setLayoutParams(iconParams);

        // Mood Text
        TextView moodText = new TextView(this);
        moodText.setText(mood);
        moodText.setTextSize(14);
        moodText.setTypeface(getResources().getFont(R.font.luckybones));

        // Day Text
        TextView dayText = new TextView(this);
        dayText.setText(day);

        dayText.setTextSize(14);
        dayText.setTypeface(getResources().getFont(R.font.luckybones));
        dayText.setPadding(40, 0, 0, 0);

        // Date/Time Text
        TextView dateTimeText = new TextView(this);
        dateTimeText.setText(dateTime);

        dateTimeText.setTextSize(14);
        dateTimeText.setTypeface(getResources().getFont(R.font.luckybones));
        dateTimeText.setPadding(40, 0, 0, 0);

        row.addView(moodIcon);
        row.addView(moodText);
        row.addView(dayText);
        row.addView(dateTimeText);

        moodHistoryContainer.addView(row);
    }
}
