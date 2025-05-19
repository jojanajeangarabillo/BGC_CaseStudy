package com.example.bgc_casestudy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textDateTime = view.findViewById(R.id.dateTimeText);
        TextView textUserName = view.findViewById(R.id.greetingText);
        ImageView imageProfile = view.findViewById(R.id.profileImage);

        // Set current date and time
        String currentDate = new SimpleDateFormat("EEEE, MMM d hh:mm a", Locale.getDefault()).format(new Date());
        textDateTime.setText(currentDate);

        // Set user name (can later get from SharedPreferences or arguments)
        textUserName.setText("Hi, User Name!");
    }
}
