package com.example.convertor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.convertor.databinding.ActivityTemperatureTransBinding;

import java.text.DecimalFormat;

public class TemperatureTrans extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTemperatureTransBinding binding;
    private Toolbar toolbar1;
    private EditText celsiym, kelvin, farengate;

    DecimalFormat df = new DecimalFormat("#.####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_trans);

        binding = ActivityTemperatureTransBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar1 = findViewById(R.id.toolbar1);


        celsiym = findViewById(R.id.ediInputMetr);
        celsiym.setSelectAllOnFocus(true);
        kelvin = findViewById(R.id.ediInputMetr2);
        kelvin.setSelectAllOnFocus(true);
        farengate = findViewById(R.id.ediInputMetr3);
        farengate.setSelectAllOnFocus(true);

        setSupportActionBar(binding.toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Температура");


        celsiym.addTextChangedListener(new TextWatcher() {
            Double i1;
            public void afterTextChanged(Editable s) {
                if (celsiym.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        celsiym.setText(TextEditor.edit(celsiym.getText().toString()));
                        celsiym.setSelection(celsiym.length());
                        TextEditor.on_edit = false;

                        i1 = Double.valueOf(celsiym.getText().toString());
                        Handler(Double.valueOf(celsiym.getText().toString()));
                        toolbar1.setSubtitle("Цельсий");
                    }
                    catch (Exception e) {
                        celsiym.setText("0");
                        farengate.setText("32");
                        kelvin.setText("273.15");
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        kelvin.addTextChangedListener(new TextWatcher() {
            Double i1;
            public void afterTextChanged(Editable s) {
                if(kelvin.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        kelvin.setText(TextEditor.edit(kelvin.getText().toString()));
                        kelvin.setSelection(kelvin.length());
                        TextEditor.on_edit = false;

                        i1 = Double.valueOf(kelvin.getText().toString());
                        Handler(Double.valueOf(kelvin.getText().toString()) - 273.15);
                        toolbar1.setSubtitle("Кельвин");
                    }
                    catch (Exception e) {
                        celsiym.setText("-273.15");
                        farengate.setText("-459,67");
                        kelvin.setText("0");
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        farengate.addTextChangedListener(new TextWatcher() {
            Double i1;
            public void afterTextChanged(Editable s) {
                if (farengate.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        farengate.setText(TextEditor.edit(farengate.getText().toString()));
                        farengate.setSelection(farengate.length());
                        TextEditor.on_edit = false;

                        i1 = Double.valueOf(farengate.getText().toString());
                        Handler((Double.valueOf(farengate.getText().toString()) - 32) / 1.8);
                        toolbar1.setSubtitle("Фаренгейт");
                    }
                    catch (Exception e) {
                        celsiym.setText("-17.777");
                        farengate.setText("0");
                        kelvin.setText("275.372");
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });
    }

    private void Handler(Double c) {
        if (!celsiym.hasFocus())
            celsiym.setText(String.valueOf(df.format(c)));
        if (!kelvin.hasFocus())
            kelvin.setText(String.valueOf(df.format(c + 273.15)));
        if (!farengate.hasFocus())
            farengate.setText(String.valueOf(df.format(c * 1.8 + 32)));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}