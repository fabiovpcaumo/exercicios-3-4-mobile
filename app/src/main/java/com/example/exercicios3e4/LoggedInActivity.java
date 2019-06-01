package com.example.exercicios3e4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.exercicios3e4.services.SessionManager;

public class LoggedInActivity extends AppCompatActivity {

    Button btnLogoff;
    TextView usernameLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        final Context context = this;
        final SessionManager sm = new SessionManager(context);

        btnLogoff = findViewById(R.id.buttonLogoff);
        usernameLabel = findViewById(R.id.usernameLabel);
        usernameLabel.setText("Seja bem vindo, " + sm.getLoggedUsername());

        btnLogoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm.doLogoff();
                finish();
            }
        });
    }
}
