package com.ifsc.frutasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.ifsc.frutasapp.controllers.FrutasController;
import com.ifsc.frutasapp.models.Fruta;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrutasController frutasController = new FrutasController();
        ArrayList<Fruta> frutas = new ArrayList<>();
        Collections.addAll(frutas, frutasController.FRUTAS);
        
        FrutaAdapter adapter = new FrutaAdapter(
            getApplicationContext(),
            R.layout.list_item_fruit,
            frutas
        );

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}