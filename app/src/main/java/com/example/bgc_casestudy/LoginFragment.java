    package com.example.bgc_casestudy;

    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.CheckBox;
    import android.widget.EditText;
    import android.widget.TextView;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.fragment.app.Fragment;

    public class LoginFragment extends Fragment {
        EditText username, password;
        CheckBox oneTimeLogin;
        Button loginButton;
        TextView forgotPassword;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater,
                                 @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_login, container, false);

            username = view.findViewById(R.id.username);
            password = view.findViewById(R.id.password);
            oneTimeLogin = view.findViewById(R.id.oneTimeLogin);
            loginButton = view.findViewById(R.id.loginButton);
            forgotPassword = view.findViewById(R.id.forgotPassword);

            loginButton.setOnClickListener(v -> {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                boolean oneTime = oneTimeLogin.isChecked();

                // Handle login logic here
            });

            forgotPassword.setOnClickListener(v -> {
                // Handle forgot password
            });

            return view;
        }
    }

