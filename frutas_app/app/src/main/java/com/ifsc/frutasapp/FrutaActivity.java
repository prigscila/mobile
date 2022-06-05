package com.ifsc.frutasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ifsc.frutasapp.controllers.FrutasController;
import com.ifsc.frutasapp.models.Fruta;

import java.text.DecimalFormat;

public class FrutaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruta);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Integer codigoFruta = bundle.getInt("codigoFruta");
        FrutasController frutasController = new FrutasController();
        Fruta fruta = frutasController.FRUTA_MAP.get(Integer.toString(codigoFruta));

        TextView tvCodigo = findViewById(R.id.tvCodigo);
        TextView tvNome = findViewById(R.id.tvNome);
        TextView tvPreco = findViewById(R.id.tvPreco);
        TextView tvPrecoVenda = findViewById(R.id.tvPrecoVenda);
        ImageView imageView = findViewById(R.id.imageView2);

        DecimalFormat format = new DecimalFormat("#,###,00");

        tvCodigo.setText(Integer.toString(fruta.getCodigo()));
        tvNome.setText(fruta.getNome());
        tvPreco.setText(format.format(fruta.getPreco()));
        tvPrecoVenda.setText(format.format(fruta.getPrecoVenda()));
        imageView.setImageResource(fruta.getImagem());
    }
}