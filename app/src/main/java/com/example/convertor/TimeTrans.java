package com.example.convertor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.convertor.databinding.ActivityTimeTransBinding;

import java.text.DecimalFormat;

public class TimeTrans extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTimeTransBinding binding;
    private Toolbar toolbar1;
    private EditText ms, sec, min, hour;

    DecimalFormat df = new DecimalFormat("#.####");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_trans);

        binding = ActivityTimeTransBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar1 = findViewById(R.id.toolbar1);

        ms = findViewById(R.id.ediInputMetr);
        ms.setSelectAllOnFocus(true);
        sec = findViewById(R.id.ediInputMetr2);
        sec.setSelectAllOnFocus(true);
        min = findViewById(R.id.ediInputMetr3);
        min.setSelectAllOnFocus(true);
        hour = findViewById(R.id.ediInputMetr4);
        hour.setSelectAllOnFocus(true);

        setSupportActionBar(binding.toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Время");


        ms.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ms.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        ms.setText(TextEditor.edit(ms.getText().toString()));
                        ms.setSelection(ms.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(ms.getText().toString()) / 1000);

                        toolbar1.setSubtitle("Миллисекунда");
                    }
                    catch (Exception e) {
                        resetAll();
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        sec.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (sec.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        sec.setText(TextEditor.edit(sec.getText().toString()));
                        sec.setSelection(sec.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(sec.getText().toString()));
                        toolbar1.setSubtitle("Секунда");
                    }
                    catch (Exception e) {
                        resetAll();
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        min.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (min.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        min.setText(TextEditor.edit(min.getText().toString()));
                        min.setSelection(min.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(min.getText().toString()) * 60);
                        toolbar1.setSubtitle("Минута");
                    }
                    catch (Exception e) {
                        resetAll();
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        hour.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (hour.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        hour.setText(TextEditor.edit(hour.getText().toString()));
                        hour.setSelection(hour.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(hour.getText().toString()) * 3600);
                        toolbar1.setSubtitle("Час");
                    }
                    catch (Exception e) {
                        resetAll();
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });
    }

    private void Handler(Double s) {
        if (!sec.hasFocus())
            sec.setText(String.valueOf(df.format(s)));
        if (!ms.hasFocus())
            ms.setText(String.valueOf(df.format(s * 1000)));
        if (!min.hasFocus())
            min.setText(String.valueOf(df.format(s / 60)));
        if (!hour.hasFocus())
            hour.setText(String.valueOf(df.format(s / 3600)));
    }
    private void resetAll() {
        ms.setText("0");
        sec.setText("0");
        min.setText("0");
        hour.setText("0");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}