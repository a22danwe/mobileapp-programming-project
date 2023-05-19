package com.example.project;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
class ShowActivity2 extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22danwe";
    private final String JSON_FILE = "staty.json";

    private ArrayList<Statyer> staty = new ArrayList<>();
    private RecyclerViewAdapter Adapter;
    private RecyclerView.ViewHolder ViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonFile(this, this).execute(JSON_FILE);


    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);

        Gson gson = new Gson();

        Type type = new TypeToken<List<Statyer>>() {}.getType();

        ArrayList<Statyer> mountain = gson.fromJson(json, type);

        Adapter= new RecyclerViewAdapter( this, Statyer);

        RecyclerView view = findViewById(R.id.MyView);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(Adapter);

        Adapter.notifyDataSetChanged();
    }




}