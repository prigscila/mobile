package com.ifsc.tacoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.ifsc.tacoapp.controller.TacoController;

public class MainActivity extends AppCompatActivity {
    private TacoController controller;
    private ListView tacoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tacoListView = findViewById(R.id.lvTacoItems);
        controller = new TacoController(this);

        TacoAdapter adapter = new TacoAdapter(this, controller.listTacos());
        tacoListView.setAdapter(adapter);
        tacoListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), TacoItemActivity.class);
            intent.putExtra("tacoItemId", controller.listTacos().get(((int) id) - 1).getId());

            startActivity(intent);
        });

        EditText editText = findViewById(R.id.edtSearch);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }
}