package com.example.convertor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.navigation.ui.AppBarConfiguration;
import com.example.convertor.databinding.ActivityLengthTransBinding;
import java.text.DecimalFormat;

public class LengthTrans extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityLengthTransBinding binding;
    private Toolbar toolbar1;
    private EditText metr, millimetr, kilometr, mile;

    DecimalFormat df = new DecimalFormat("#.####"); //Формат числа

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_trans);

        binding = ActivityLengthTransBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar1 = findViewById(R.id.toolbar1); //Закрепляет за переменной панель toolbar


        millimetr = findViewById(R.id.ediInputMetr);
        millimetr.setSelectAllOnFocus(true); //Закрепляет соответствующие поля ввода за переменными. Затем включает выделение всего текста при нажатии на поле ввода
        metr = findViewById(R.id.ediInputMetr2);
        metr.setSelectAllOnFocus(true);
        kilometr = findViewById(R.id.ediInputMetr3);
        kilometr.setSelectAllOnFocus(true);
        mile = findViewById(R.id.ediInputMetr4);
        mile.setSelectAllOnFocus(true);

        setSupportActionBar(binding.toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true); //Тулбар ставится как ActionBar
        setTitle("Длина");


        millimetr.addTextChangedListener(new TextWatcher() { //Listener триггерится на изменение текста в поле ввода
            public void afterTextChanged(Editable s) {
                if (millimetr.hasFocus() && TextEditor.on_edit == false) { //Проверяет, в фокусе ли поле и переменную on_edit. Без них код зависает
                    try {
                        millimetr.setText(TextEditor.edit(millimetr.getText().toString()));
                        millimetr.setSelection(millimetr.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(millimetr.getText().toString()));
                        toolbar1.setSubtitle("Миллиметр");
                    }
                    catch (Exception e) {
                        resetAll();
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        metr.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if(metr.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        metr.setText(TextEditor.edit(metr.getText().toString()));
                        metr.setSelection(metr.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(metr.getText().toString()) * 1000);
                        toolbar1.setSubtitle("Метр");
                    }
                    catch (Exception e) {
                        resetAll();
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        kilometr.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (kilometr.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        kilometr.setText(TextEditor.edit(kilometr.getText().toString()));
                        kilometr.setSelection(kilometr.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(kilometr.getText().toString()) * 1000000);
                        toolbar1.setSubtitle("Километр");
                    }
                    catch (Exception e) {
                        resetAll();
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        mile.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (mile.hasFocus() && TextEditor.on_edit == false) {
                    try {
                        mile.setText(TextEditor.edit(mile.getText().toString()));
                        mile.setSelection(mile.length());
                        TextEditor.on_edit = false;

                        Handler(Double.valueOf(mile.getText().toString()) * 1609340);
                        toolbar1.setSubtitle("Миля");
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

    private void Handler(Double mm)
    {
        if (!millimetr.hasFocus())
            millimetr.setText(String.valueOf(df.format(mm)));  //Считает и устанавливает значения в остальные поля
        if (!metr.hasFocus())
            metr.setText(String.valueOf(df.format(mm / 1000)));
        if (!kilometr.hasFocus())
            kilometr.setText(String.valueOf(df.format(mm / 1000000)));
        if (!mile.hasFocus())
            mile.setText(String.valueOf(df.format(mm / 1609340)));
    }

    private void resetAll() {
        millimetr.setText("0");
        metr.setText("0");
        kilometr.setText("0");
        mile.setText("0");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}