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


public class Length extends Fragment{


    private ListView listView;
    private ListView listView2;
    private EditText editText;
    private Button convert;
    private AutoCompleteTextView autoText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_length, container, false);
        listView = view.findViewById(R.id.list1);
        listView2 = view.findViewById(R.id.list2);
        editText = view.findViewById(R.id.editText);
        convert = view.findViewById(R.id.convert);
        autoText = view.findViewById(R.id.autoText);

        view.setBackgroundColor(Color.WHITE);

        double list[] = new double[5];


        String tutorials[]
                = new String[]{"       cm:", "       m:",
                "       mm:", "       ft:",
                "       km:",
        };

        ArrayAdapter<String> array;
        array = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                tutorials);
        listView.setAdapter(array);
        convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(editText.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter The Value First", Toast.LENGTH_SHORT).show();


                }
                else if(!TextUtils.isDigitsOnly(editText.getText())){
                    Toast.makeText(getActivity(), "Enter Numbers only as Input", Toast.LENGTH_SHORT).show();

                }
                else {

                    String value = editText.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    String unit = autoText.getEditableText().toString();

                    switch (unit) {
                        case "cm":

                            list[0] = (double) finalValue;
                            list[1] = (double) finalValue / 100.0;
                            list[2] = (double) finalValue * 10.0;
                            list[3] = (double) finalValue / 30.48;
                            list[4] = (double) finalValue / 100000.0;
                            break;
                        case "m":
                            list[0] = (double) finalValue * 100.0;
                            list[1] = (double) finalValue;
                            list[2] = (double) finalValue / 1000.0;
                            list[3] = (double) finalValue * 3.281;
                            list[4] = (double) finalValue / 1000.0;
                            break;
                        case "mm":
                            list[0] = (double) finalValue / 10.0;
                            list[1] = (double) finalValue / 1000.0;
                            list[2] = (double) finalValue;
                            list[3] = (double) finalValue / 305.0;
                            list[4] = (double) finalValue / 1e+6;
                            break;
                        case "ft":
                            list[0] = (double) finalValue * 30.48;
                            list[1] = (double) finalValue / 3.281;
                            list[2] = (double) finalValue * 305.0;
                            list[3] = (double) finalValue;
                            list[4] = (double) finalValue / 3281.0;
                            break;
                        case "km":
                            list[0] = (double) finalValue * 100000.0;
                            list[1] = (double) finalValue * 1000.0;
                            list[2] = (double) finalValue * 1e+6;
                            list[3] = (double) finalValue * 3281.0;
                            list[4] = (double) finalValue;
                            break;
                        default:
                            Toast.makeText(getActivity(), "Unit Missing", Toast.LENGTH_SHORT).show();
                            break;

                    }


                }


                   ArrayList<String> arrayList = new ArrayList<String>();
                    for (double s : list) {
                        arrayList.add(String.valueOf(s));
                    }

                    ArrayAdapter<String> arrayAdapter;
                    arrayAdapter = new ArrayAdapter<String>(
                            getActivity(),
                            R.layout.support_simple_spinner_dropdown_item,
                            arrayList);
                    listView2.setAdapter(arrayAdapter);
                }

        });


        String[] items=new String[]{"cm","m","mm","ft","km"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(),
                R.layout.dropdown_item,
                items);
        autoText.setAdapter(arrayAdapter);
        return view;
    }


}