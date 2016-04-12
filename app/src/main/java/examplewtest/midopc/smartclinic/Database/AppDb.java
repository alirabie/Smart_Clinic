package examplewtest.midopc.smartclinic.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import examplewtest.midopc.smartclinic.Database.Models.Patient;

public class AppDb extends SQLiteOpenHelper {

    final static String DBNAME="smart_clinic.db";
    final static int Version=1;

    public AppDb(Context context) {
        super(context,DBNAME,null,Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table IF NOT EXISTS Patients (id INTEGER primary key,full_name TEXT,age INTEGER,gender TEXT,address TEXT,phone_num TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table Patients ");
        onCreate(db);

    }



    //Table Patients insertion

    public void insertToPatients(Patient patient){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("full_name",patient.getFullName());
        contentValues.put("age",patient.getPhoneNum());
        contentValues.put("gender",patient.getGender());
        contentValues.put("address",patient.getAddress());
        contentValues.put("phone_num", patient.getPhoneNum());
        db.insert("Patients", null, contentValues);

    }


    //Table Patients Retrieve



    public List<Patient> getAllPatientsNames(){

        List<Patient>patients=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Patient patient=new Patient();
        Cursor cursor=db.rawQuery("select * from Patients",null);
        cursor.moveToFirst();
        int index=0;
        while(cursor.isAfterLast()==false){
            patient.setFullName(cursor.getString(cursor.getColumnIndex("full_name")));
            patient.setAge(cursor.getInt(cursor.getColumnIndex("age")));
            patient.setAddress(cursor.getString(cursor.getColumnIndex("address")));
            patient.setGender(cursor.getString(cursor.getColumnIndex("gender")));
            patient.setPhoneNum(cursor.getString(cursor.getColumnIndex("phone_num")));
            patients.add(0,patient);
            cursor.moveToNext();
            index++;
        }

        return patients;

    }


}
