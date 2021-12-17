package com.example.unitsconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;


public class Basic extends Fragment{


 private TextInputLayout textInputLayout;
 private AutoCompleteTextView autoCompleteTextView;

 private Button area;
 private Button length;
 private Button weight;
 private Button volume;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_basic, container, false);
        textInputLayout= view.findViewById(R.id.textLayout);
        autoCompleteTextView=view.findViewById(R.id.autoText);
        length=view.findViewById(R.id.pressure);
        area=view.findViewById(R.id.force);
        weight=view.findViewById(R.id.work);
        volume=view.findViewById(R.id.power);
        String[] items=new String[]{"cm","m","mm","ft","km"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(),
                R.layout.dropdown_item,
                items);
        autoCompleteTextView.setAdapter(arrayAdapter);
        area.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Fragment fragment=new Area();

                FragmentManager fragmentManager=getParentFragmentManager();


                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment, fragment);
                //transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        length.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Fragment fragment=new Length();

                FragmentManager fragmentManager=getParentFragmentManager();


                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment, fragment);
                //transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        weight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Fragment fragment=new Weight();

                FragmentManager fragmentManager=getParentFragmentManager();


                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment, fragment);
                //transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        volume.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Fragment fragment=new Volume();

                FragmentManager fragmentManager=getParentFragmentManager();


                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment, fragment);
                //transaction.addToBackStack(null);

                transaction.commit();
            }
        });
        return view;
    }


}