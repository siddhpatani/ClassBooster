package com.eduware.classbooster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import com.eduware.classbooster.Student;
import com.eduware.classbooster.ClassBoosterApp;

public class Generator extends AppCompatActivity {
    Button btnBack;
    Button btnGenerate;
    Button btnPrint;
    TableLayout table;
    ClassBoosterApp globalVariable;
    //ConstraintLayout root;
   // int studentCount = 30;


//    Student s1 = new Student("John", true, false, true, false, true);
//    Student s2 = new Student("Parth", true, true, false, true, false);
//    Student s3 = new Student("Siddh", true, true, true, false, false);
//    Student s4 = new Student("Akshat", true, true, true, true, true);
//    Student s5 = new Student("Ansh", false, true, false, false, true);
//   ArrayList<Student> students;

//    public void setStudents(ArrayList<Student> students) {
//        this.students.add(s1);
//        this.students.add(s2);
//        this.students.add(s3);
//        this.students.add(s4);
//        this.students.add(s5);
//
//    }

    public void ClassGenerator() {
//        Traditional t = new Traditional(studentCount, span, depth);
//        t.getColCount();
//        t.getRowCount();

        int span = globalVariable.getRoomInfo().getSpan();
        int depth = globalVariable.getRoomInfo().getDepth();
        int type = globalVariable.getRoomInfo().getSeatingType();

        switch (type) {
            case 0: {
                GenerateTraditional(span, depth);
            }
            break;
            case 1: {
                //GeneratePairPod();
                GenerateTraditional(span, depth);

            }
            break;
            case 2: {
                //GenerateGroupPod();
                GenerateTraditional(span, depth);

            }
            break;
        }
    }



public void GenerateTraditional(int row, int col){

    List<Student> myroster = globalVariable.getRoster();
    Traditional p1 = new Traditional(myroster.size(), row, col);
    p1.arrangeStudents(myroster);
    Assignment[][] mychart = p1.getChart();

    for(int rowctr = 0; rowctr < p1.getRowCount(); rowctr++) {
        TableRow tableRow = new TableRow(this);

        for(int colctr = 0; colctr < p1.getColCount(); colctr++) {
//            String name;
            TextView studentName = new TextView(this);
            TableRow.LayoutParams params = new TableRow.LayoutParams
                    ((int) TableRow.LayoutParams.MATCH_PARENT, (int) TableRow.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 20;
            params.topMargin = 20;
            studentName.setTextSize((float) 15);
            studentName.setPadding(5, 5, 5, 5);
            studentName.setTextColor(Color.parseColor("#FFFFFF"));
            studentName.setLayoutParams(params);
            if (mychart[rowctr][colctr] != null) {
                studentName.setText(((Student)mychart[rowctr][colctr]).getName());
            }
            tableRow.addView(studentName);

        }
        table.addView(tableRow);

    }
//    for (int studentindex = 0; studentindex < myroster.size();)
//            {
//                for (int rowctr = 0; rowctr < row && studentindex < mychart.size(); rowctr++ )
//                {
//                    TableRow tableRow = new TableRow(this);
//                    for (int colctr = 0; colctr < col && studentindex < myroster.size(); colctr++)
//                    {
//                        TextView studentName = new TextView(this);
//                        TableRow.LayoutParams params = new TableRow.LayoutParams
//                                ((int) TableRow.LayoutParams.MATCH_PARENT, (int) TableRow.LayoutParams.WRAP_CONTENT);
//                        params.leftMargin = 50;
//                        params.topMargin = 50;
//                        studentName.setTextSize((float) 20);
//                        studentName.setPadding(20, 50, 20, 50);
//                        studentName.setLayoutParams(params);
//                        studentName.setText(myroster.get(studentindex).getName());
//                        studentindex++;
//                        tableRow.addView(studentName);
//                    }
//                    table.addView(tableRow);
//                }
//
//            }

        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generatorp1);
        btnBack = findViewById(R.id.back);
        btnGenerate = findViewById(R.id.generate);
        btnPrint = findViewById(R.id.print);
        table = findViewById(R.id.tables);
        globalVariable = (ClassBoosterApp) getApplicationContext();

        ClassGenerator();
       // root = findViewById(R.id.rootlayout)
       // Toast.makeText(this, "Max students reached", Toast.LENGTH_SHORT).show();



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z = new Intent(Generator.this, HomeActivity.class);
                startActivity(z);
            }
        });

    }
}
