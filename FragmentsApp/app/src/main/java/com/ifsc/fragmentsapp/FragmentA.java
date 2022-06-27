package com.ifsc.fragmentsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentA extends Fragment {
    TextView textView ;
    Button buttonSendMsg;
    EditText editText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v= inflater.inflate(R.layout.fragment_a,container,false);
        textView = v.findViewById(R.id.tvMsg);
        buttonSendMsg=v.findViewById(R.id.buttonSendMSg);
        editText = v.findViewById(R.id.edMsg);

        buttonSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentB  fragmentB =new FragmentB();

                Bundle b = new Bundle( );
                b.putString("msg", editText.getText().toString());
                fragmentB.setArguments(b);

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout,fragmentB);
                transaction.commit();

            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        if ( getArguments()!=null && getArguments().containsKey("msg")) {
            this.textView.setText(getArguments().getString("msg"));
        }
    }
}