package com.eduware.classbooster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.eduware.classbooster.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
//asdfasd
public class Class1Activity extends AppCompatActivity {

//    public static final String NAME_KEY = "Name";
//    public static final String ID_KEY = "Id";

   // private CollectionReference studentCollection = FirebaseFirestore.getInstance().collection("studentprofiles");
   private static final String TAG = "MainActivity";
   private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     //getStudentData();
     setContentView(R.layout.activity_class1);


            DocumentReference docRef = db.collection("studentprofiles").document("T6PXndhqzjk0nXiNoAD1");
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        } else {
                            Log.d(TAG, "No such document");
                        }
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });

    }

//
//    }
}

