package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

class MainActivity extends AppCompatActivity {
    TextView Description;
    Button pressButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pressButton = findViewById(R.id.pressButton);
        Description = findViewById(R.id.Description);

        pressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity .this, ShowActivity2.class);

                startActivity(intent);



            }
        });
    }
}