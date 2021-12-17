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


public class Time extends Fragment{
    private ListView time_list1;
    private AutoCompleteTextView time_autoText;
    private Button time_convert;
    private EditText time_editText;
    private ListView time_list2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_time, container, false);

        time_list1=view.findViewById(R.id.time_list1);
        time_autoText=view.findViewById(R.id.time_autoText);
        time_convert=view.findViewById(R.id.time_convert);
        time_editText=view.findViewById(R.id.time_editText);
        time_list2=view.findViewById(R.id.time_list2);
        String []area_units=new String[]{"sec","min","hr","ms"};
        ArrayAdapter<String> area_arrayAdapter=new ArrayAdapter<String>(
                getContext(),
                R.layout.dropdown_area,
                area_units
        );
        time_autoText.setAdapter(area_arrayAdapter);
        double area_list[] = new double[4];
        String area_tutorials[]
                = new String[]{"       sec:", "       min:",
                "       hr:", "       ms:",
        };

        ArrayAdapter<String> area_array;
        area_array = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                area_tutorials);
        time_list1.setAdapter(area_array);
        time_convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(time_editText.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter The Value First", Toast.LENGTH_SHORT).show();


                }
                else if(!TextUtils.isDigitsOnly(time_editText.getText())){
                    Toast.makeText(getActivity(), "Enter Numbers only as Input", Toast.LENGTH_SHORT).show();

                }
                else {

                    String value = time_editText.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    String unit = time_autoText.getEditableText().toString();

                    switch (unit) {
                        case "sec":

                            area_list[0] = (double) finalValue; // sec
                            area_list[1] = (double) finalValue/60.0 ; // min
                            area_list[2] = (double) finalValue/ 3600.0;  // hr
                            area_list[3] = (double) finalValue * 1000.0; // ms
                            // Re
                            break;
                        case "min":
                            area_list[0] = (double) finalValue *60.0;
                            area_list[1] = (double) finalValue;
                            area_list[2] = (double) finalValue *3600.0 ;
                            area_list[3] = (double) finalValue / 60000.0;

                            break;
                        case "hr":
                            area_list[0] = (double) finalValue *3600.0 ;
                            area_list[1] = (double) finalValue *60;
                            area_list[2] = (double) finalValue;
                            area_list[3] = (double) finalValue * 3.6e+6;

                            break;
                        case "ms":
                            area_list[0] = (double) finalValue/1000.0;
                            area_list[1] = (double) finalValue/60000.0;
                            area_list[2] = (double) finalValue /3.6e+6;
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
                time_list2.setAdapter(area_arrayAdapter);
            }

        });



        view.setBackgroundColor(Color.WHITE);






        return view;
    }
}