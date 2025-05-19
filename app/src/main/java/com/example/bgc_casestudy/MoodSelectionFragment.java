package com.example.bgc_casestudy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MoodSelectionFragment extends Fragment {

    private ImageView moodImage;
    private TextView moodText;
    private int moodIndex = 0;

    private final String[] moods = {
            "Happy", "Angry", "Sad", "Envious",
            "Bored", "Disgust", "Embarrassed", "Anxious"
    };

    private final int[] moodImages = {
            R.drawable.joy, R.drawable.anger, R.drawable.sadness,
            R.drawable.envy, R.drawable.boredom, R.drawable.disgust,
            R.drawable.embarrassment, R.drawable.anxiety
    };

    public MoodSelectionFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mood_selection_fragment, container, false);

        moodImage = view.findViewById(R.id.ivMood);
        moodText = view.findViewById(R.id.tvMood);
        ImageButton arrowLeft = view.findViewById(R.id.btnLeft);
        ImageButton arrowRight = view.findViewById(R.id.btnRight);
        Button skipButton = view.findViewById(R.id.btnSkip);

        updateMoodDisplay();

        arrowLeft.setOnClickListener(v -> {
            moodIndex = (moodIndex - 1 + moods.length) % moods.length;
            updateMoodDisplay();
        });

        arrowRight.setOnClickListener(v -> {
            moodIndex = (moodIndex + 1) % moods.length;
            updateMoodDisplay();
        });

        skipButton.setOnClickListener(v ->
                Toast.makeText(getContext(), "Skipped", Toast.LENGTH_SHORT).show()
        );

        return view;
    }

    private void updateMoodDisplay() {
        moodText.setText(moods[moodIndex]);
        moodImage.setImageResource(moodImages[moodIndex]);
    }
}
