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


public class Weight extends Fragment{
    private ListView weight_list1;
    private AutoCompleteTextView weight_autoText;
    private Button weight_convert;
    private EditText weight_editText;
    private ListView weight_list2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_weight, container, false);
        weight_list1=view.findViewById(R.id.weight_list1);
        weight_autoText=view.findViewById(R.id.weight_autoText);
        weight_convert=view.findViewById(R.id.weight_convert);
        weight_editText=view.findViewById(R.id.weight_editText);
        weight_list2=view.findViewById(R.id.weight_list2);

        String []area_units=new String[]{"kg","g","mg","ton","carat"};
        ArrayAdapter<String> area_arrayAdapter=new ArrayAdapter<String>(
                getContext(),
                R.layout.dropdown_area,
                area_units
        );
        weight_autoText.setAdapter(area_arrayAdapter);

        double area_list[] = new double[5];


        String area_tutorials[]
                = new String[]{"       kg:", "       g:",
                "       mg:", "       ton:",
                "       carat:",
        };

        ArrayAdapter<String> area_array;
        area_array = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                area_tutorials);
        weight_list1.setAdapter(area_array);
        weight_convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(weight_editText.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter The Value First", Toast.LENGTH_SHORT).show();


                }
                else if(!TextUtils.isDigitsOnly(weight_editText.getText())){
                    Toast.makeText(getActivity(), "Enter Numbers only as Input", Toast.LENGTH_SHORT).show();

                }
                else {

                    String value = weight_editText.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    String unit = weight_autoText.getEditableText().toString();

                    switch (unit) {
                        case "kg":

                            area_list[0] = (double) finalValue; // kg
                            area_list[1] = (double) finalValue*1000.0; //g
                            area_list[2] = (double) finalValue * 1e+6;  //mg
                            area_list[3] = (double) finalValue / 907.0; //ton
                            area_list[4] = (double) finalValue *5000.0; //carat
                            break;
                        case "g":
                            area_list[0] = (double) finalValue / 1000.0;
                            area_list[1] = (double) finalValue;
                            area_list[2] = (double) finalValue * 1000.0;
                            area_list[3] = (double) finalValue / 907185.0;
                            area_list[4] = (double) finalValue *5.0;
                            break;
                        case "mg":
                            area_list[0] = (double) finalValue / 1e+6;
                            area_list[1] = (double) finalValue / 1000.0;
                            area_list[2] = (double) finalValue;
                            area_list[3] = (double) finalValue / 9.072e+8;
                            area_list[4] = (double) finalValue / 200.0;
                            break;
                        case "ton":
                            area_list[0] = (double) finalValue * 907.0;
                            area_list[1] = (double) finalValue * 907185.0;
                            area_list[2] = (double) finalValue * 9.072e+8;
                            area_list[3] = (double) finalValue;
                            area_list[4] = (double) finalValue * 4.536e+6;
                            break;
                        case "carat":
                            area_list[0] = (double) finalValue /5000.0;
                            area_list[1] = (double) finalValue / 5.0;
                            area_list[2] = (double) finalValue * 200.0;
                            area_list[3] = (double) finalValue / 4.536e+6;
                            area_list[4] = (double) finalValue;
                            break;
                        default:
                            Toast.makeText(getActivity(), "Unit Missing", Toast.LENGTH_SHORT).show();
                            break;

                    }


                }


                ArrayList<String> weight_arrayList = new ArrayList<String>();
                for (double s : area_list) {
                    weight_arrayList.add(String.valueOf(s));
                }

                ArrayAdapter<String> area_arrayAdapter;
                area_arrayAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        R.layout.support_simple_spinner_dropdown_item,
                        weight_arrayList);
                weight_list2.setAdapter(area_arrayAdapter);
            }

        });




        view.setBackgroundColor(Color.WHITE);


        return view;
    }
}