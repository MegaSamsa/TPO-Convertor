package com.example.convertor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLength (View v) { //Просто кнопки для запуска окон. Где LengthTrans это название файла .java Следующим смотреть LengthTrans.java
        Intent i = new Intent(MainActivity.this, LengthTrans.class);
        startActivity(i);
    }
    public void onClickSquare (View v) {
        Intent i = new Intent(MainActivity.this, SquareTrans.class);
        startActivity(i);
    }
    public void onClickVolume (View v) {
        Intent i = new Intent(MainActivity.this, VolumeTrans.class);
        startActivity(i);
    }
    public void onClickTemperature (View v) {
        Intent i = new Intent(MainActivity.this, TemperatureTrans.class);
        startActivity(i);
    }
    public void onClickBytes (View v) {
        Intent i = new Intent(MainActivity.this, BytesTrans.class);
        startActivity(i);
    }
    public void onClickTime (View v) {
        Intent i = new Intent(MainActivity.this, TimeTrans.class);
        startActivity(i);
    }

}