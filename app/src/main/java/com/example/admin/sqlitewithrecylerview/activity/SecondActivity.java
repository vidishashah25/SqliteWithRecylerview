package com.example.admin.sqlitewithrecylerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.sqlitewithrecylerview.R;
import com.example.admin.sqlitewithrecylerview.database.DBHandler;
import com.example.admin.sqlitewithrecylerview.models.StudentModel;

/**
 * Created by Admin on 2/9/2017.
 */
//SecondActivity

public class SecondActivity extends AppCompatActivity {

    DBHandler db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);

        db = new DBHandler(getApplicationContext());
    }


    public void addDetails(View view){
        EditText etName = (EditText) findViewById(R.id.etName);
        EditText etID = (EditText) findViewById(R.id.etID);
        EditText etEmail = (EditText) findViewById(R.id.etEmail);

        int id = Integer.valueOf( etID.getText().toString());
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        StudentModel sm = new StudentModel(id,name,email);

        db.addStudent(sm);

        Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show();

    }



}
