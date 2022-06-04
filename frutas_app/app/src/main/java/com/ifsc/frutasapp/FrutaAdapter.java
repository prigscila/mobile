package com.ifsc.frutasapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ifsc.frutasapp.models.Fruta;

import java.text.DecimalFormat;
import java.util.List;

public class FrutaAdapter extends ArrayAdapter {
    private Context context;
    private int resource;

    public FrutaAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView tvCodigo = convertView.findViewById(R.id.tvCodigo);
        TextView tvNome = convertView.findViewById(R.id.tvNome);
        TextView tvPreco = convertView.findViewById(R.id.tvPreco);
        TextView tvPrecoVenda = convertView.findViewById(R.id.tvPrecoVenda);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        Fruta fruta = (Fruta) getItem(position);
        DecimalFormat format = new DecimalFormat("#,###,00");

        tvCodigo.setText(Integer.toString(fruta.getCodigo()));
        tvNome.setText(fruta.getNome());
        tvPreco.setText(format.format(fruta.getPreco()));
        tvPrecoVenda.setText(format.format(fruta.getPrecoVenda()));
        imageView.setImageResource(fruta.getImagem());

        return convertView;
    }
}
