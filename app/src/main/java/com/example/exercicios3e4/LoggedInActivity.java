package com.example.exercicios3e4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.exercicios3e4.services.FirulaService;
import com.example.exercicios3e4.services.SessionManager;

import java.util.List;

public class LoggedInActivity extends AppCompatActivity {

    Button btnLogoff;
    TextView usernameLabel, welcomeLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        final Context context = this;
        final SessionManager sm = new SessionManager(context);
        final FirulaService fs = new FirulaService(context);

        List<String> userData = fs.retrieveUserData();

        usernameLabel = findViewById(R.id.usernameLabel);
        usernameLabel.setText("Logged user: " + sm.getLoggedUsername());

        welcomeLabel = findViewById(R.id.welcomeLabel);
        welcomeLabel.setText("Seja bem-vindo, " + userData.get(0) + ".");

        btnLogoff = findViewById(R.id.buttonLogoff);
        btnLogoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm.doLogoff();
                finish();
            }
        });
    }
}
