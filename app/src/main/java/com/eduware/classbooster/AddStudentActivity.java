package com.eduware.classbooster;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.OnClickListener;

public class AddStudentActivity extends AppCompatActivity implements OnClickListener {
    private ArrayList<Student> roster;
    private final int ROSTER_SIZE = 30;
    private EditText[] name = new EditText[ROSTER_SIZE];
    private CheckBox[] sight = new CheckBox[ROSTER_SIZE];
    private CheckBox[] outgoing = new CheckBox[ROSTER_SIZE];
    private CheckBox[] shy = new CheckBox[ROSTER_SIZE];
    private CheckBox[] serious = new CheckBox[ROSTER_SIZE];
    private CheckBox[] offtask = new CheckBox[ROSTER_SIZE];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudents);
        View rosterView = findViewById(R.id.roster);
        for (int i = 0; i < ROSTER_SIZE; i++) {
            name[i] = rosterView.findViewWithTag("studentName" + i);
            sight[i] = rosterView.findViewWithTag("sight" + i);
            outgoing[i] = rosterView.findViewWithTag("outgoing" + i);
            shy[i] = rosterView.findViewWithTag("shy" + i);
            serious[i] = rosterView.findViewWithTag("serious" + i);
            offtask[i] = rosterView.findViewWithTag("offtask" + i);
        }

        findViewById(R.id.done_students).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.done_students:
                roster = new ArrayList<Student>();
                for (int i = 0; i < ROSTER_SIZE; i++) {
                    String studentName = name[i].getText().toString();
                    if (studentName.isEmpty()) continue;
                    roster.add(new Student(
                            studentName,
                            sight[i].isChecked(),
                            outgoing[i].isChecked(),
                            shy[i].isChecked(),
                            serious[i].isChecked(),
                            offtask[i].isChecked()
                    ));
                }
                break;
        }
    }

    public List<Student> getRoster() {
        return roster;
    }
}
