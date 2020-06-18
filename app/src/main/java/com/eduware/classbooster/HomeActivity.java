package com.eduware.classbooster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogout;
    Button btnP1;
    Button btnP2;
    Button btnP3;
    Button btnP4;
    Button btnP5;
    Button btnP6;
    Button btnAddClass;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    final ArrayList<Button> btnList = new ArrayList<Button>();
    int btnIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout = findViewById(R.id.logout);
        btnP1 = findViewById(R.id.p1);
        btnP2 = findViewById(R.id.p2);
        btnP3 = findViewById(R.id.p3);
        btnP4 = findViewById(R.id.p4);
        btnP5 = findViewById(R.id.p5);
        btnP6 = findViewById(R.id.p6);
        btnAddClass = findViewById(R.id.AddClass);


        btnLogout.setOnClickListener(this);
        btnP1.setOnClickListener(this);
        btnP2.setOnClickListener(this);
        btnP3.setOnClickListener(this);
        btnP4.setOnClickListener(this);
        btnP5.setOnClickListener(this);
        btnP6.setOnClickListener(this);
        btnAddClass.setOnClickListener(this);

        btnList.add(btnP1);
        btnList.add(btnP2);
        btnList.add(btnP3);
        btnList.add(btnP4);
        btnList.add(btnP5);
        btnList.add(btnP6);

//        btnP1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent b = new Intent(HomeActivity.this, Generator.class);
//                startActivity(b);
//            }
//        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intToMain);
                break;
            case R.id.AddClass:
                Button currentBtn = btnList.get(btnIndex);
                currentBtn.setVisibility(View.VISIBLE);
                if (btnIndex < 5) {
                    btnIndex++;
                }
                else {
                    Toast.makeText(this, "Max periods reached", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
