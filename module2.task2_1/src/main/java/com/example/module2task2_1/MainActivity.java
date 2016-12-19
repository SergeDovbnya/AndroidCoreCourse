package com.example.module2task2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private TextView mTextView;
    private int mArgumentCounter = 0;

    private static List<String> stringArrayList = new ArrayList<>();
    private static List<Binary> binaryArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
        Button buttonSave = (Button) findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = mEditText.getText().toString();
                if (input.matches("^[01]+$")) {
                    binaryArrayList.add(new Binary(Integer.parseInt(input)));
                    mArgumentCounter++;
                    Toast.makeText(MainActivity.this, R.string.saved, Toast.LENGTH_SHORT).show();
                    mEditText.setText("");
                } else {
                    stringArrayList.add(input);
                    mArgumentCounter++;
                    Toast.makeText(MainActivity.this, R.string.saved, Toast.LENGTH_SHORT).show();
                    mEditText.setText("");
                }
            }
        });

        mTextView = (TextView) findViewById(R.id.textView);

        Button buttonShow = (Button) findViewById(R.id.button_show);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText(result());
            }
        });
    }

    private String result() {
        return String.format("Total number of arguments: %s \n\n Binary: %s \n String: %s \n",
                mArgumentCounter, binaryArrayList, stringArrayList);
    }
}
