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


public class Force extends Fragment{
    private ListView force_list1;
    private AutoCompleteTextView force_autoText;
    private Button force_convert;
    private EditText force_editText;
    private ListView force_list2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_force, container, false);


        force_list1=view.findViewById(R.id.force_list1);
        force_autoText=view.findViewById(R.id.force_autoText);
        force_convert=view.findViewById(R.id.force_convert);
        force_editText=view.findViewById(R.id.force_editText);
        force_list2=view.findViewById(R.id.force_list2);
        String []area_units=new String[]{"N","dyne","kgf","kN"};
        ArrayAdapter<String> area_arrayAdapter=new ArrayAdapter<String>(
                getContext(),
                R.layout.dropdown_area,
                area_units
        );
        force_autoText.setAdapter(area_arrayAdapter);
        double area_list[] = new double[4];
        String area_tutorials[]
                = new String[]{"       N:", "       dyne:",
                "       kgf:", "       kN:",
        };

        ArrayAdapter<String> area_array;
        area_array = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                area_tutorials);
        force_list1.setAdapter(area_array);
        force_convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(force_editText.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter The Value First", Toast.LENGTH_SHORT).show();


                }
                else if(!TextUtils.isDigitsOnly(force_editText.getText())){
                    Toast.makeText(getActivity(), "Enter Numbers only as Input", Toast.LENGTH_SHORT).show();

                }
                else {

                    String value = force_editText.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    String unit = force_autoText.getEditableText().toString();

                    switch (unit) {
                        case "N":

                            area_list[0] = (double) finalValue; // C
                            area_list[1] = (double) finalValue * 100000.0 ; // F
                            area_list[2] = (double) finalValue / 9.807;  // K
                            area_list[3] = (double) finalValue / 1000.0; // R
                            // Re
                            break;
                        case "dyne":
                            area_list[0] = (double) finalValue / 100000.0;
                            area_list[1] = (double) finalValue;
                            area_list[2] = (double) finalValue / 980665.0;
                            area_list[3] = (double) finalValue / 1e+8;

                            break;
                        case "kgf":
                            area_list[0] = (double) finalValue * 9.807;
                            area_list[1] = (double) finalValue * 980665.0;
                            area_list[2] = (double) finalValue;
                            area_list[3] = (double) finalValue / 102.0;

                            break;
                        case "kN":
                            area_list[0] = (double) finalValue * 1000.0;
                            area_list[1] = (double) finalValue * 1e+8;
                            area_list[2] = (double) finalValue *102.0;
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
                force_list2.setAdapter(area_arrayAdapter);
            }

        });



        view.setBackgroundColor(Color.WHITE);

        return view;
    }
}