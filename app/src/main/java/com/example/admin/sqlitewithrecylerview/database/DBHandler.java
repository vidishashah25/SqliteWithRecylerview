package com.example.admin.sqlitewithrecylerview.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.sqlitewithrecylerview.models.StudentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2/9/2017.
 */

//DBHandler

public class DBHandler extends SQLiteOpenHelper
{
    private  static  final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "studentdetails";

    private static  final String TABLE_STUDENTS = "students";

    private static final String KEY_STUDENT_ID = "studentID";

    private static final String KEY_STUDENT_NAME = "studentName";

    private static final String KEY_STUDENT_EMAIL = "studentEmail";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_STUDENTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_STUDENTS + " ("
                + KEY_STUDENT_ID + " INTEGER PRIMARY KEY, "
                + KEY_STUDENT_NAME + " TEXT, "
                + KEY_STUDENT_EMAIL + " TEXT "
                + ") ";

        sqLiteDatabase.execSQL(CREATE_STUDENTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j) {

    }


    public void addStudent(StudentModel student){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_STUDENT_ID,student.getStudentID());
        values.put(KEY_STUDENT_NAME,student.getStudentName());
        values.put(KEY_STUDENT_EMAIL,student.getStudentEmail());

        db.insert(TABLE_STUDENTS,null,values);
        db.close();

    }

    public StudentModel getStudent(int studentID) {

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(TABLE_STUDENTS,
                new String[]{KEY_STUDENT_ID, KEY_STUDENT_NAME, KEY_STUDENT_EMAIL},
                KEY_STUDENT_ID + "=?",
                new String[]{String.valueOf(studentID)},
                null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        StudentModel student = new StudentModel(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2));

        return student;

    }


    public ArrayList<StudentModel> getAllStudents() {

        ArrayList<StudentModel> studentList = new ArrayList<>();

        //Select All Query

        String selectQuery = "SELECT * FROM " + TABLE_STUDENTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //Looping through all rows and adding to list

        if (cursor.moveToFirst()) {

            do {
                StudentModel student = new StudentModel(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)

                );
                studentList.add(student);
            } while (cursor.moveToNext());
        }

        //return student list
        return studentList;
    }

    public int updateStudent(StudentModel student){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STUDENT_NAME,student.getStudentName());
        values.put(KEY_STUDENT_EMAIL,student.getStudentEmail());

        //Updating student row

        return db.update(TABLE_STUDENTS,
                values,
                KEY_STUDENT_ID + "= ?",
                new String[]{String.valueOf(student.getStudentID())}
        );

    }

    public void deleteStudent(StudentModel student){

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_STUDENTS,
                KEY_STUDENT_ID + "= ?",
                new String[]{String.valueOf(student.getStudentID())}
        );
        db.close();
    }


    public int getStudentsCount(){

        String countQuery = "SELECT * FROM " + TABLE_STUDENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }


}
