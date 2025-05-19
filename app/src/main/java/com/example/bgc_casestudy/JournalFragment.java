package com.example.bgc_casestudy;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class JournalFragment extends Fragment {

    public JournalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_journal, container, false);

        Button addEntryButton = view.findViewById(R.id.addEntryButton);
        addEntryButton.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Add Entry Clicked", Toast.LENGTH_SHORT).show();
            // You can open a new dialog or navigate to an entry screen
        });

        return view;
    }
}
