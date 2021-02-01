package com.example.trip.User;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.trip.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class addPlan extends AppCompatActivity {
    private ListView ListV;
    ArrayList<LvItem> arrayList = new ArrayList<>();
    TextView empty;
    String title , t ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);
        empty = findViewById(R.id.name);
        final TextView textView = findViewById(R.id.date);
        Button selectD = findViewById(R.id.selectDate);
        Button addPlan = findViewById(R.id.addButton);
        String imageName = getIntent().getStringExtra("data");
        empty.setText(imageName);
        title = empty.getText().toString();



        final Calendar newCalender = Calendar.getInstance();
        selectD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(addPlan.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, final int year, final int month, final int dayOfMonth) {


                        final Calendar newDate = Calendar.getInstance();
                        Calendar newTime = Calendar.getInstance();
                        TimePickerDialog time = new TimePickerDialog(addPlan.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                newDate.set(year,month,dayOfMonth,hourOfDay,minute,0);
                                Calendar tem = Calendar.getInstance();
                                Log.w("TIME",System.currentTimeMillis()+"");
                                if(newDate.getTimeInMillis()-tem.getTimeInMillis()>0)
                                    textView.setText(newDate.getTime().toString());
                                else
                                    Toast.makeText(addPlan.this,"Invalid time",Toast.LENGTH_SHORT).show();

                            }
                        },newTime.get(Calendar.HOUR_OF_DAY),newTime.get(Calendar.MINUTE),true);
                        time.show();

                    }
                },newCalender.get(Calendar.YEAR),newCalender.get(Calendar.MONTH),newCalender.get(Calendar.DAY_OF_MONTH));

                dialog.getDatePicker().setMinDate(System.currentTimeMillis());
                dialog.show();

            }
        });
        addPlan.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                title = empty.getText().toString();
                t=textView.getText().toString();
                LvItem listI = new LvItem();
                listI.setTitle(title);
                listI.setTime(t);
                arrayList.add(listI);




                Intent intent = new Intent(addPlan.this,ListView1.class);
                intent.putExtra("Message",listI.getTitle());
                intent.putExtra("RemindDate",listI.getTime());
                startActivity(intent);







            }

        });
    }
}