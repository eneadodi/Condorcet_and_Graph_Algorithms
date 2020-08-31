package com.example.eneadodi.condorcet_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Log_In_Activity extends AppCompatActivity {
    private Button logInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in_);
        logInButton = (Button)findViewById(R.id.Login_button);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDirectoryActivity();
            }
        });
    }

    public void startDirectoryActivity(){
        Intent intent = new Intent(Log_In_Activity.this, DirectoryActivity.class);
        startActivity(intent);
    }
}
