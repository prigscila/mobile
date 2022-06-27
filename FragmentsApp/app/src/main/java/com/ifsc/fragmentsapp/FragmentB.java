package com.ifsc.fragmentsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentB extends Fragment {
    TextView textViewMsg;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_b,container,false);
        textViewMsg=v.findViewById(R.id.textViewMsg);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments()!= null && getArguments().containsKey("msg")) {
            textViewMsg.setText(getArguments().getString("msg"));

        }
    }
}