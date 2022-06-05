package com.ifsc.frutasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(
                    getApplicationContext(),
                    Long.toString(parent.getItemIdAtPosition(position)),
                    Toast.LENGTH_LONG
            ).show();

            Intent intent = new Intent(getApplicationContext(), FrutaActivity.class);
            intent.putExtra("codigoFruta", ((Fruta) adapter.getItem(position)).getCodigo());
            startActivity(intent);
        });
        /*
        listView.setOnItemClickListener(new AdapterView<>().OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        Long.toString(parent.getItemIdAtPosition(position)),
                        Toast.LENGTH_LONG
                ).show();

                Intent intent = new Intent(getApplicationContext(), FrutaActivity.class);
                intent.putExtra("codigoFruta", ((Fruta) adapter.getItem(position)).getCodigo());
                startActivity(intent);
            }
        });
        */
    }
}