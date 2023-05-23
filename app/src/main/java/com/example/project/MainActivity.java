package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22danwe";
    private final String JSON_FILE = "statue.json";

    private ArrayList<Statyer> statue = new ArrayList<>();
    private RecyclerViewAdapter Adapter;
    private RecyclerView.ViewHolder ViewHolder;
    Button pressButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonFile(this, this).execute(JSON_FILE);

            pressButton = findViewById(R.id.button);
            pressButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, AboutActivity.class);

                    startActivity(intent);



                }
            });

    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);

        Gson gson = new Gson();

        Type type = new TypeToken<List<Statyer>>() {}.getType();

        ArrayList<Statyer> statue = gson.fromJson(json, type);

        Adapter= new RecyclerViewAdapter( this, statue);

        RecyclerView view = findViewById(R.id.MyView);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(Adapter);

        Adapter.notifyDataSetChanged();
    }




}