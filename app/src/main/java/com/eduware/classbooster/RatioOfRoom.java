package com.eduware.classbooster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RatioOfRoom extends AppCompatActivity {
    //TODO: Someone has to pass Classroom so that I can set the RoomInfo in it
    protected Classroom classRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratio_of_room);

        Button b = findViewById(R.id.button12);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView span = findViewById(R.id.editTextTextPersonName3);
                TextView depth = findViewById(R.id.editTextTextPersonName4);
                RadioButton r1 = findViewById(R.id.radioButton4);
                RadioButton r2 = findViewById(R.id.radioButton5);
                RadioButton r3 = findViewById(R.id.radioButton6);

                Integer sp = new Integer(span.getText().toString());
                Integer de = new Integer(depth.getText().toString());

                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup0);
                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if(selectedId == -1){
                    selectedId = 0;
                }
                else if(R.id.radioButton4 == selectedId){
                    selectedId = 0;
                }else if(R.id.radioButton5 == selectedId){
                    selectedId = 1;
                }else if(R.id.radioButton6 == selectedId){
                    selectedId = 2;
                }
                RoomInfo ri = new RoomInfo(sp, de, selectedId);

                //TODO: Someone has to pass Classroom so that I can set the RoomInfo in it
                //classRoom.setRoomInfo(ri);

                final ClassBoosterApp globalVariable = (ClassBoosterApp) getApplicationContext();

                globalVariable.setRoomInfo(ri);

            }
        });


    }

}