package com.example.unitsconverter;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.AutoText;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Area extends Fragment{
private ListView area_list1;
private AutoCompleteTextView area_autoText;
private Button area_convert;
private EditText area_editText;
private ListView area_list2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_area, container, false);
        area_list1=view.findViewById(R.id.area_list1);
        area_autoText=view.findViewById(R.id.area_autoText);
        area_convert=view.findViewById(R.id.area_convert);
        area_editText=view.findViewById(R.id.area_editText);
        area_list2=view.findViewById(R.id.area_list2);
        String []area_units=new String[]{"cm^2","m^2","mm^2","ft^2","km^2"};
        ArrayAdapter<String> area_arrayAdapter=new ArrayAdapter<String>(
                getContext(),
                R.layout.dropdown_area,
                area_units
        );
       area_autoText.setAdapter(area_arrayAdapter);
        double area_list[] = new double[5];


        String area_tutorials[]
                = new String[]{"       cm^2:", "       m^2:",
                "       mm^2:", "       ft^2:",
                "       km^2:",
        };

        ArrayAdapter<String> area_array;
        area_array = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                area_tutorials);
        area_list1.setAdapter(area_array);
        area_convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(area_editText.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter The Value First", Toast.LENGTH_SHORT).show();


                }
                else if(!TextUtils.isDigitsOnly(area_editText.getText())){
                    Toast.makeText(getActivity(), "Enter Numbers only as Input", Toast.LENGTH_SHORT).show();

                }
                else {

                    String value = area_editText.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    String unit = area_autoText.getEditableText().toString();

                    switch (unit) {
                        case "cm^2":

                            area_list[0] = (double) finalValue; // cm
                            area_list[1] = (double) finalValue / 10000.0; //m
                            area_list[2] = (double) finalValue * 100.0;  //mm
                            area_list[3] = (double) finalValue / 929; //ft
                            area_list[4] = (double) finalValue / 1e+10; //km
                            break;
                        case "m^2":
                            area_list[0] = (double) finalValue * 10000.0;
                            area_list[1] = (double) finalValue;
                            area_list[2] = (double) finalValue / 1e+6;
                            area_list[3] = (double) finalValue * 10.7639;
                            area_list[4] = (double) finalValue / 1e+6;
                            break;
                        case "mm^2":
                            area_list[0] = (double) finalValue / 100.0;
                            area_list[1] = (double) finalValue / 1e+6;
                            area_list[2] = (double) finalValue;
                            area_list[3] = (double) finalValue / 92903.0;
                            area_list[4] = (double) finalValue / 1e+12;
                            break;
                        case "ft^2":
                            area_list[0] = (double) finalValue * 929.0;
                            area_list[1] = (double) finalValue / 10.764;
                            area_list[2] = (double) finalValue * 92903.04;
                            area_list[3] = (double) finalValue;
                            area_list[4] = (double) finalValue / 1.076e+7;
                            break;
                        case "km^2":
                            area_list[0] = (double) finalValue * 1e+10;
                            area_list[1] = (double) finalValue * 1e+6;
                            area_list[2] = (double) finalValue * 1e+12;
                            area_list[3] = (double) finalValue * 1.076e+7;
                            area_list[4] = (double) finalValue;
                            break;
                        default:
                            Toast.makeText(getActivity(), "Unit Missing", Toast.LENGTH_SHORT).show();
                            break;

                    }


                }


                ArrayList<String> area_arrayList = new ArrayList<String>();
                for (double s : area_list) {
                    area_arrayList.add(String.valueOf(s));
                }

                ArrayAdapter<String> area_arrayAdapter;
                area_arrayAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        R.layout.support_simple_spinner_dropdown_item,
                        area_arrayList);
                area_list2.setAdapter(area_arrayAdapter);
            }

        });



       view.setBackgroundColor(Color.WHITE);




        return view;

    }
}