package myapplication.app1.todolist;

import android.app.usage.UsageEvents;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class EventCreation extends AppCompatActivity {

    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    LinearLayout Task,Event,Meeting;

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

    }
}
