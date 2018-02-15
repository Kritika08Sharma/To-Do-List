package myapplication.app1.todolist;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class EventCreation extends AppCompatActivity {


    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    Button b1,b2,b3;
    Toast toast;
    LinearLayout Task,Event,Meeting;
    EditText MeetTime,EventTime,Tasktitle,TaskDesc,text1,MeetingVenue,MeetingTime,MeetDesc;
    TextView EventText;
    Spinner spinner;
    DatePickerDialog MeetDate ;
    android.icu.util.Calendar Calendar;
    Database db;
    SimpleDateFormat dateFormatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creation);


        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        Task = (LinearLayout) findViewById(R.id.TaskLayout);
        Event = (LinearLayout) findViewById(R.id.EventLayout);
        Meeting = (LinearLayout) findViewById(R.id.MeetingLayout);
        EventTime =(EditText) findViewById(R.id.EventTime);
        Tasktitle = (EditText) findViewById(R.id.title);
        text1 = (EditText) findViewById(R.id.text1);
        MeetingVenue = (EditText) findViewById(R.id.MeetingVenue);
        MeetingTime = (EditText) findViewById(R.id.MeetingTime);
        MeetDesc  = (EditText) findViewById(R.id.MeetDesc);
        spinner = (Spinner) findViewById(R.id.Spinner1);
        EventText = (TextView) findViewById(R.id.EventText);
        TaskDesc =(EditText) findViewById(R.id.Description);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        db = new Database(this);
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task.setVisibility(View.VISIBLE);
                Event.setVisibility(View.GONE);
                Meeting.setVisibility(View.GONE);
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event.setVisibility(View.VISIBLE);
                Task.setVisibility(View.GONE);
                Meeting.setVisibility(View.GONE);
            }
        });

        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Meeting.setVisibility(View.VISIBLE);
                Event.setVisibility(View.GONE);
                Task.setVisibility(View.GONE);
            }
        });


        MeetingTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                android.icu.util.Calendar newCalendar = Calendar.getInstance();
                MeetDate = new DatePickerDialog(MeetTime.getContext() , new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);
                        MeetTime.setText(dateFormatter.format(newDate.getTime()));
                    }

                },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

                MeetDate.show();
            }
        });
        EventTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                Calendar newCalendar = Calendar.getInstance();
                MeetDate = new DatePickerDialog(EventTime.getContext() , new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);
                        EventTime.setText(dateFormatter.format(newDate.getTime()));
                    }

                },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

                MeetDate.show();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertTaskData(Tasktitle.getText().toString(),TaskDesc.getText().toString());

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertEventData(spinner.getSelectedItem().toString(),EventTime.getText().toString(),text1.getText().toString());
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertMeetingData(MeetingVenue.getText().toString(),MeetingTime.getText().toString(), MeetDesc.getText().toString());
            }
        });





    }
}
