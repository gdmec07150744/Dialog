package com.example.min123.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1= (TextView) findViewById(R.id.characterPickerDialog);
        tv2= (TextView) findViewById(R.id.datePickerDialog);
        tv3= (TextView) findViewById(R.id.timePickerDialog);
    }
    public void characterpickerdialog(View v){
        final String options="76484459548474123";
        CharacterPickerDialog cpd=new CharacterPickerDialog(this,new View(this),null,options,false){
            @Override
            public void onClick(View v) {
                tv1.append(((Button)v).getText().toString());
                if(((Button) v).getText().toString().equals("")){
                    dismiss();
                }
            }
        };
        cpd.show();
    }
    public void datepickerdialog(View v){
        DatePickerDialog dpd=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                 tv2.setText("日期"+year+"-"+monthOfYear+"-"+dayOfMonth);
            }
        },2016,10,31);
        dpd.show();
    }
    public void timepickerdialog(View v){
        TimePickerDialog tpd=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv3.setText(hourOfDay+"："+minute);
            }
        },9,15,true);
        tpd.show();
    }
    public void progressdialog(View v){
        final ProgressDialog pg=ProgressDialog.show(this,"加载","正在加载当中.....",true);
        new Thread(){
            public void run() {
                try {
                    sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally{
                    pg.dismiss();
                }
            }
        }.start();

    }


}
