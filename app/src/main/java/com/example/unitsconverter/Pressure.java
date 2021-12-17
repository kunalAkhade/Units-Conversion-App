package com.example.unitsconverter;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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


public class Pressure extends Fragment{

    private ListView pressure_list1;
    private AutoCompleteTextView pressure_autoText;
    private Button pressure_convert;
    private EditText pressure_editText;
    private ListView pressure_list2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_pressure, container, false);

        pressure_list1=view.findViewById(R.id.pressure_list1);
        pressure_autoText=view.findViewById(R.id.pressure_autoText);
        pressure_convert=view.findViewById(R.id.pressure_convert);
        pressure_editText=view.findViewById(R.id.pressure_editText);
        pressure_list2=view.findViewById(R.id.pressure_list2);
        String []area_units=new String[]{"atm","Pa","bar","Torr"};
        ArrayAdapter<String> area_arrayAdapter=new ArrayAdapter<String>(
                getContext(),
                R.layout.dropdown_area,
                area_units
        );
        pressure_autoText.setAdapter(area_arrayAdapter);
        double area_list[] = new double[4];
        String area_tutorials[]
                = new String[]{"       atm:", "       Pa:",
                "       bar:", "       Torr:",
        };

        ArrayAdapter<String> area_array;
        area_array = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                area_tutorials);
        pressure_list1.setAdapter(area_array);
        pressure_convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(pressure_editText.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter The Value First", Toast.LENGTH_SHORT).show();


                }
                else if(!TextUtils.isDigitsOnly(pressure_editText.getText())){
                    Toast.makeText(getActivity(), "Enter Numbers only as Input", Toast.LENGTH_SHORT).show();

                }
                else {

                    String value = pressure_editText.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    String unit = pressure_autoText.getEditableText().toString();

                    switch (unit) {
                        case "atm":

                            area_list[0] = (double) finalValue; // C
                            area_list[1] = (double) finalValue * 101325.0 ; // F
                            area_list[2] = (double) finalValue * 1.013;  // K
                            area_list[3] = (double) finalValue * 760.0; // R
                            // Re
                            break;
                        case "Pa":
                            area_list[0] = (double) finalValue / 101325.0;
                            area_list[1] = (double) finalValue;
                            area_list[2] = (double) finalValue / 100000.0;
                            area_list[3] = (double) finalValue / 133.0;

                            break;
                        case "bar":
                            area_list[0] = (double) finalValue / 1.013;
                            area_list[1] = (double) finalValue * 100000.0;
                            area_list[2] = (double) finalValue;
                            area_list[3] = (double) finalValue * 750.0;

                            break;
                        case "Torr":
                            area_list[0] = (double) finalValue / 760.0;
                            area_list[1] = (double) finalValue * 133.0;
                            area_list[2] = (double) finalValue / 750.0;
                            area_list[3] = (double) finalValue;

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
                pressure_list2.setAdapter(area_arrayAdapter);
            }

        });



        view.setBackgroundColor(Color.WHITE);
        return view;
    }
}