package com.example.bgc_casestudy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(view -> {
            loadFragment(new RegisterFragment());
        });
    }

    private void loadFragment(Fragment fragment) {
        // Hide logo and register button when switching to fragment
        findViewById(R.id.logoContainer).setVisibility(View.GONE);
        registerButton.setVisibility(View.GONE);

        // Show fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
