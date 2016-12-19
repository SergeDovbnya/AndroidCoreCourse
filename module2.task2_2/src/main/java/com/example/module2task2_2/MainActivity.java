package com.example.module2task2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private List<String> stringList = new ArrayList<>();
    private List<String> newStringList = new ArrayList<>();

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        Button buttonSave = (Button) findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String argument = editText.getText().toString();
                if (argument.equals("")) {
                    return;
                }
                stringList.add(argument);
                newStringList.add(removeDuplicates(argument));
                editText.setText("");
            }
        });

        Button buttonShow = (Button) findViewById(R.id.button_show);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(String.format("Number of arguments: %s \n\n" + "Arguments: %s \n\n Without duplicate chars: %s", stringList.size(), stringList, newStringList));
            }
        });
    }

    public static String removeDuplicates(String word) {
        if (word == null || word.length() < 2) {
            return word;
        }

        int pos = 1; // possible position of duplicate character
        char[] characters = word.toCharArray();

        for (int i = 1; i < word.length(); i++) {
            int j;
            for (j = 0; j < pos; ++j) {
                if (characters[i] == characters[j]) {
                    break;
                }
            }
            if (j == pos) {
                characters[pos] = characters[i];
                ++pos;
            } else {
                characters[pos] = 0;
                ++pos;
            }
        }

        return toUniqueString(characters);
    }

    public static String toUniqueString(char[] letters) {
        StringBuilder sb = new StringBuilder(letters.length);
        for (char c : letters) {
            if (c != 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
