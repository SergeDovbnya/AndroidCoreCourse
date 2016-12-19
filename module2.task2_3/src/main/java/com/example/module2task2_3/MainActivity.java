package com.example.module2task2_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> arguments = new ArrayList<>();
    private List<String> sortedArguments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        Button saveButton = (Button) findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText.getText().toString().equals("")) {
                    arguments.add(editText.getText().toString().trim());
                    editText.setText("");
                }
            }
        });

        final TextView textView = (TextView) findViewById(R.id.textView);
        Button showButton = (Button) findViewById(R.id.button_show);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortedArguments.addAll(arguments);
                Collections.sort(sortedArguments, new Comparator<String>() {
                    @Override
                    public int compare(String s, String t1) {
                        return s.length() - t1.length();
                    }
                });
                textView.setText(String.format("Number of arguments: %s \n Arguments: %s \n Sorted: %s", arguments.size(), arguments, sortedArguments));
            }
        });
    }
}
