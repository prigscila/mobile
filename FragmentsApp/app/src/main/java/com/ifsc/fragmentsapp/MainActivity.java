package com.ifsc.fragmentsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    Button buttonFragmentA, buttonFragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonFragmentA = findViewById(R.id.buttonFragmentA);
        buttonFragmentB = findViewById(R.id.buttonFragmentB);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId() ){
                    case R.id.buttonFragmentA:
                        fragment= new FragmentA();
                        break;
                    case R.id.buttonFragmentB:
                        fragment=new FragmentB();
                        break;
                }
                startFragment();
            }
        } ;

        buttonFragmentA.setOnClickListener(onClickListener);
        buttonFragmentB.setOnClickListener(onClickListener);
    }

    public void startFragment(){
        if (this.fragment != null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout,fragment);
            transaction.commit();
        }
    }
}