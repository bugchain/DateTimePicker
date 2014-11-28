package com.bugchain.android.development.datetimepicker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.sleepbot.datetimepicker.time.RadialPickerLayout;
import com.sleepbot.datetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class MainActivity extends ActionBarActivity {

    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;

    Calendar calendar;

    TextView textDate,textTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = Calendar.getInstance();

        textDate = (TextView)findViewById(R.id.textDate);
        textTime = (TextView)findViewById(R.id.textTime);

        datePickerDialog = DatePickerDialog.newInstance(onDateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                false);

        timePickerDialog = TimePickerDialog.newInstance(onTimeSetListener,
                12,0,true,false);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnDate:
                    datePickerDialog.setYearRange(2000,2030);
                datePickerDialog.show(getSupportFragmentManager(),"datePicker");
                break;
            case R.id.btnTime:
                    timePickerDialog.show(getSupportFragmentManager(),"timePicker");
                break;
        }
    }

    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
            textDate.setText(day +"/"+month+"/"+year);
        }
    };

    private TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(RadialPickerLayout radialPickerLayout, int hour, int minute) {
                  textTime.setText(hour +" : " + minute);
        }
    };
}
