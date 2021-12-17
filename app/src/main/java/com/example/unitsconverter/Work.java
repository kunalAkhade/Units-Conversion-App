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

public class Work extends Fragment{
    private ListView work_list1;
    private AutoCompleteTextView work_autoText;
    private Button work_convert;
    private EditText work_editText;
    private ListView work_list2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_work, container, false);


        work_list1=view.findViewById(R.id.work_list1);
        work_autoText=view.findViewById(R.id.work_autoText);
        work_convert=view.findViewById(R.id.work_convert);
        work_editText=view.findViewById(R.id.work_editText);
        work_list2=view.findViewById(R.id.work_list2);
        String []area_units=new String[]{"J","kJ","kcal"};
        ArrayAdapter<String> area_arrayAdapter=new ArrayAdapter<String>(
                getContext(),
                R.layout.dropdown_area,
                area_units
        );
        work_autoText.setAdapter(area_arrayAdapter);
        double area_list[] = new double[3];
        String area_tutorials[]
                = new String[]{"       J:", "       kJ:",
                "       kcal:",
        };

        ArrayAdapter<String> area_array;
        area_array = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                area_tutorials);
        work_list1.setAdapter(area_array);
        work_convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(work_editText.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter The Value First", Toast.LENGTH_SHORT).show();


                }
                else if(!TextUtils.isDigitsOnly(work_editText.getText())){
                    Toast.makeText(getActivity(), "Enter Numbers only as Input", Toast.LENGTH_SHORT).show();

                }
                else {

                    String value = work_editText.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    String unit = work_autoText.getEditableText().toString();

                    switch (unit) {
                        case "J":

                            area_list[0] = (double) finalValue; // C
                            area_list[1] = (double) finalValue / 1000.0 ; // F
                            area_list[2] = (double) finalValue / 4184.0;  // K

                            // Re
                            break;
                        case "kJ":
                            area_list[0] = (double) finalValue * 1000.0;
                            area_list[1] = (double) finalValue;
                            area_list[2] = (double) finalValue / 4.184;


                            break;
                        case "kcal":
                            area_list[0] = (double) finalValue * 4184.0;
                            area_list[1] = (double) finalValue * 4.184;
                            area_list[2] = (double) finalValue;


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
                work_list2.setAdapter(area_arrayAdapter);
            }

        });



        view.setBackgroundColor(Color.WHITE);


        return view;
    }
}