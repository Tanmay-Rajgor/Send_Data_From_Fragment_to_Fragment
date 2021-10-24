package com.tanmay.fragmenttofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentFirst extends Fragment {

    EditText editText;
    Button button;



    public FragmentFirst() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        editText = view.findViewById(R.id.editTextPersonName);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("username", userName);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                FragmentSecond fragmentSecond = new FragmentSecond();
                fragmentSecond.setArguments(bundle);

                fragmentTransaction.replace(R.id.frame, fragmentSecond);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}