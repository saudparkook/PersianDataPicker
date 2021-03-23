package com.saud.calenderlib;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.NumberPicker;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private NumberPicker d, m, y;
    private int year, month, day;
    private String dayname;
    tabdilatshamsi tb;
    String[]ya;
    TextView txt;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=new tabdilatshamsi();
        ya=new String[1610];
        for(int i=0;i<1610;i++){
            ya[i]=(i+1)+"";
        }
        dialogpicker();
        dialog.show();
        findViewById(R.id.fr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

    void dialogpicker() {


        View di = LayoutInflater.from(this).inflate(R.layout.layout, null);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(di);
        d = dialog.findViewById(R.id.dayNumberPicker);
        m = dialog.findViewById(R.id.monthNumberPicker);
        y = dialog.findViewById(R.id.yearNumberPicker);
        txt=dialog.findViewById(R.id.textView);

        y.setMaxValue(1600);
        y.setMinValue(1);
        y.setDisplayedValues(ya);
        m.setMinValue(1);
        m.setMaxValue(12);
        m.setDisplayedValues(tb.FA_moon);
        d.setMinValue(1);
        int[]data=tb.emrozShamsi();
        getdate(data[0],data[1],data[2]);
        y.setValue(data[0]);
        m.setValue(data[1]);
        d.setValue(data[2]);

        y.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                getdate(Integer.parseInt(ya[y.getValue() - 1]), m.getValue(), d.getValue());
                ///
            }
        });

        m.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                getdate(Integer.parseInt(ya[y.getValue() - 1]), m.getValue(), d.getValue());
            }
        });
        d.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                getdate(Integer.parseInt(ya[y.getValue() - 1]), m.getValue(), d.getValue());

            }
        });





    }


    private void getdate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        dayname = tb.ForStringDay(year, month, day);
        txt.setText(year + "/" + month + "/" + day + "\n" + dayname);
        d.setMaxValue(tb.lengthofdaymon(year,month));

    }



}