package com.example.bgc_casestudy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    Button loginButton, registerButton;
    ImageView logoImage;
    TextView appTitle;
    LinearLayout buttonContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        logoImage = findViewById(R.id.logoImage);
        appTitle = findViewById(R.id.appTitle);
        buttonContainer = findViewById(R.id.buttonContainer);

        // Login button click
        loginButton.setOnClickListener(view -> {
            hideIntro();
            loadFragment(new LoginFragment());
        });

        // Register button click
        registerButton.setOnClickListener(view -> {
            hideIntro();
            loadFragment(new RegisterFragment());
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                        android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void hideIntro() {
        logoImage.setVisibility(View.GONE);
        appTitle.setVisibility(View.GONE);
        buttonContainer.setVisibility(View.GONE);
    }

    private void showIntro() {
        logoImage.setVisibility(View.VISIBLE);
        appTitle.setVisibility(View.VISIBLE);
        buttonContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        // Handle back navigation
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();

            // If this is the last fragment being removed, show the intro again
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                showIntro();
            }
        } else {
            super.onBackPressed();
        }
    }
}
