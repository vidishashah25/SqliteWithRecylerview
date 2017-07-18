package com.example.admin.sqlitewithrecylerview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.admin.sqlitewithrecylerview.R;
import com.example.admin.sqlitewithrecylerview.adapters.StudentAdapter;
import com.example.admin.sqlitewithrecylerview.database.DBHandler;
import com.example.admin.sqlitewithrecylerview.models.StudentModel;

import java.util.ArrayList;
import java.util.List;

//MainActivity

public class MainActivity extends AppCompatActivity {

    ArrayList<String> studentDetails = new ArrayList<>();

    RecyclerView rvVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvVersions = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);

        rvVersions.setLayoutManager(lm);

    }

    @Override
    protected void onResume() {
        super.onResume();

        DBHandler db = new DBHandler(getApplicationContext());

        ArrayList<StudentModel> students = db.getAllStudents();


        StudentAdapter sa = new StudentAdapter(MainActivity.this,students);

        rvVersions.setAdapter(sa);
    }

    public void addStudent(View view) {
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(i);
    }

}
