package com.example.convertor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.convertor.databinding.ActivityBytesTransBinding;

import java.text.DecimalFormat;

public class BytesTrans extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityBytesTransBinding binding;
    private Toolbar toolbar1;
    private EditText bit, bytes, kilobytes, megabyte, gigabyte, terabyte;

    DecimalFormat df = new DecimalFormat("#.####");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bytes_trans);

        binding = ActivityBytesTransBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar1 = findViewById(R.id.toolbar1);

        bit = findViewById(R.id.ediInputMetr);
        bit.setSelectAllOnFocus(true);
        bytes = findViewById(R.id.ediInputMetr2);
        bytes.setSelectAllOnFocus(true);
        kilobytes = findViewById(R.id.ediInputMetr3);
        kilobytes.setSelectAllOnFocus(true);
        megabyte = findViewById(R.id.ediInputMetr4);
        megabyte.setSelectAllOnFocus(true);
        gigabyte = findViewById(R.id.ediInputMetr5);
        gigabyte.setSelectAllOnFocus(true);
        terabyte = findViewById(R.id.ediInputMetr6);
        terabyte.setSelectAllOnFocus(true);

        setSupportActionBar(binding.toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Объём");

        bit.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (bit.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        bit.setText(TextEditor.edit(bit.getText().toString()));
                        bit.setSelection(bit.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(bit.getText().toString()) / 8);
                        toolbar1.setSubtitle("Бит");
                    }
                    catch (Exception e) {
                        resetAll();

                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        bytes.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (bytes.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        bytes.setText(TextEditor.edit(bytes.getText().toString()));
                        bytes.setSelection(bytes.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(bytes.getText().toString()));
                        toolbar1.setSubtitle("Байт");
                    }
                    catch (Exception e) {
                        resetAll();
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        kilobytes.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (kilobytes.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        kilobytes.setText(TextEditor.edit(kilobytes.getText().toString()));
                        kilobytes.setSelection(kilobytes.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(kilobytes.getText().toString()) * Math.pow(1024, 1));
                        toolbar1.setSubtitle("Килобайт");
                    }
                    catch (Exception e) {
                        resetAll();
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        megabyte.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (megabyte.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        megabyte.setText(TextEditor.edit(megabyte.getText().toString()));
                        megabyte.setSelection(megabyte.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(megabyte.getText().toString()) * Math.pow(1024, 2));
                        toolbar1.setSubtitle("Мегабайт");
                    }
                    catch (Exception e) {
                        resetAll();
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        gigabyte.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (gigabyte.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        gigabyte.setText(TextEditor.edit(gigabyte.getText().toString()));
                        gigabyte.setSelection(gigabyte.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(gigabyte.getText().toString()) * Math.pow(1024, 3));
                        toolbar1.setSubtitle("Гигабайт");
                    }
                    catch (Exception e) {
                        resetAll();
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        terabyte.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (terabyte.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        terabyte.setText(TextEditor.edit(terabyte.getText().toString()));
                        terabyte.setSelection(terabyte.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(terabyte.getText().toString()) * Math.pow(1024, 4));
                        toolbar1.setSubtitle("Терабайт");
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

    private void Handler(Double bb) {
        if (!bit.hasFocus())
            bit.setText(String.valueOf(df.format(bb * 8)));
        if (!bytes.hasFocus())
            bytes.setText(String.valueOf(df.format(bb / Math.pow(1024, 0))));
        if (!kilobytes.hasFocus())
            kilobytes.setText(String.valueOf(df.format(bb / Math.pow(1024, 1))));
        if (!megabyte.hasFocus())
            megabyte.setText(String.valueOf(df.format(bb / Math.pow(1024, 2))));
        if (!gigabyte.hasFocus())
            gigabyte.setText(String.valueOf(df.format(bb / Math.pow(1024, 3))));
        if (!terabyte.hasFocus())
            terabyte.setText(String.valueOf(df.format(bb / Math.pow(1024, 4))));
    }

    private void resetAll() {
        bit.setText("0");
        bytes.setText("0");
        kilobytes.setText("0");
        megabyte.setText("0");
        gigabyte.setText("0");
        terabyte.setText("0");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}