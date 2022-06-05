package com.ifsc.tacoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.ifsc.tacoapp.controller.TacoController;
import com.ifsc.tacoapp.model.Taco;

public class TacoItemActivity extends AppCompatActivity {
    private TacoController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taco_item);
        controller = new TacoController(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Integer noteId = bundle.getInt("tacoItemId");
        Taco taco = controller.getTaco(noteId);

        TextView tvAlimento = findViewById(R.id.tvAlimentoHd);
        tvAlimento.setText(taco.getAlimento());

        TextView tvCategoria = findViewById(R.id.tvCategoria);
        tvCategoria.setText(taco.getCategoria());

        TextView tvUmidade = findViewById(R.id.tvUmidade);
        tvUmidade.setText(taco.getUmidade());
    }
}