package com.example.serhii.androidcorecourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Integer number = 0;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.main_textView);
        textView.setText(String.valueOf(number));

        editText = (EditText) findViewById(R.id.main_editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editable.toString();
                if (text.length() > 12) increaseNumber();
            }
        });

        final TextView fibResTextView = (TextView) findViewById(R.id.fib_res_textView);
        EditText fibEditText = (EditText) findViewById(R.id.fib_EditText);
        fibEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int num = 0;
                if (editable.length() > 0) {
                    String input = editable.toString();
                    num = Integer.valueOf(input);
                }
                fibResTextView.setText(String.valueOf(fibonacci(num)));
            }
        });

    }

    public void increase(View view) {
        increaseNumber();
    }

    private void increaseNumber() {
        number++;
        if (number > 23) {
            textView.setText("I love GoIT so much");
            return;
        }
        textView.setText(String.valueOf(number));
    }

    private long fibonacci(int num) {
        if (num <= 20) return (num <= 2 ? 1 : fibonacci(num - 1) + fibonacci(num - 2));
        else return 0;
    }
}
