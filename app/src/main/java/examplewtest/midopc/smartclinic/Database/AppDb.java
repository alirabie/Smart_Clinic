package examplewtest.midopc.smartclinic.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import examplewtest.midopc.smartclinic.Database.Models.Patient;
import examplewtest.midopc.smartclinic.Database.Models.Patient_status;

public class AppDb extends SQLiteOpenHelper {

    final static String DBNAME = "smart_clinic.db";
    final static int Version = 1;

    public AppDb(Context context) {
        super(context, DBNAME, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table IF NOT EXISTS Patients (id INTEGER primary key,full_name TEXT,age INTEGER,gender TEXT,address TEXT,date TEXT,time TEXT,phone_num TEXT)");
        db.execSQL("Create table IF NOT EXISTS Status (id INTEGER primary key,p_Id INTEGER,s_date TEXT,s_time TEXT,blood_pressure TEXT,diabetes_rate TEXT,weight TEXT,temp TEXT,doctor_notes TEXT,required_analyzes TEXT,required_xray TEXT,drug TEXT,next_visit TEXT,FOREIGN KEY(p_Id) REFERENCES Patients(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table Patients ");
        db.execSQL("drop table Status ");
        onCreate(db);

    }






    //Get patient Name

    public String getName(int pId){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select full_name from Patients where id=" + pId, null);
        cursor.moveToFirst();
        String name=cursor.getString(cursor.getColumnIndex("full_name"));

        return name;
    }



    //Get Phone Num By Id
    public String getphonenum(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select phone_num from Patients where id=" + id, null);
        cursor.moveToFirst();
        String phoneNum =cursor.getString(cursor.getColumnIndex("full_name"));
        return phoneNum;
    }






    //Table Patients insertion
    public void insertToPatients(Patient patient) {
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String dateString = sdf.format(date);

        long time = System.currentTimeMillis();
        SimpleDateFormat stf = new SimpleDateFormat("hh:mm:ss");
        String timestring = stf.format(time);

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name", patient.getFullName());
        contentValues.put("age", patient.getAge());
        contentValues.put("address", patient.getAddress());
        contentValues.put("date", dateString);
        contentValues.put("time", timestring);
        contentValues.put("phone_num", patient.getPhoneNum());

        db.insert("Patients", null, contentValues);

    }


    //Table Patients Retrieve

    public List<Patient> getAllPatientsNames() {
        List<Patient> patients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Patients", null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            Patient patient = new Patient();
            patient.setId(cursor.getInt(cursor.getColumnIndex("id")));
            patient.setFullName(cursor.getString(cursor.getColumnIndex("full_name")));
            patient.setAge(cursor.getInt(cursor.getColumnIndex("age")));
            patient.setAddress(cursor.getString(cursor.getColumnIndex("address")));
            patient.setDate(cursor.getString(cursor.getColumnIndex("date")));
            patient.setTime(cursor.getString(cursor.getColumnIndex("time")));
            patient.setPhoneNum(cursor.getString(cursor.getColumnIndex("phone_num")));
            patients.add(patient);
            cursor.moveToNext();
        }
        return patients;
    }


    //Delete all Patients

    public void deleteAllPatients() {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("delete from Patients");
    }

    //Delete Patient By Id

    public void deletePatientByid(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("delete from Patients where id=" + Integer.toString(id));
    }

    //Update patient Name

    public void updatePatientName(String name, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update Patients set full_name=" + name + "where id = " + id);
    }

    //Update patient Age

    public void updatePatientAge(int Age, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update Patients set age=" + Age + "where id = " + id);
    }

    //Search patient by Name

    public List<Patient> searchPatientByName(String name) {
        List<Patient> patients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Patients where full_name like '" + name + "%'", null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            Patient patient = new Patient();
            patient.setId(cursor.getInt(cursor.getColumnIndex("id")));
            patient.setFullName(cursor.getString(cursor.getColumnIndex("full_name")));
            patient.setAge(cursor.getInt(cursor.getColumnIndex("age")));
            patient.setAddress(cursor.getString(cursor.getColumnIndex("address")));
            patient.setDate(cursor.getString(cursor.getColumnIndex("date")));
            patient.setTime(cursor.getString(cursor.getColumnIndex("time")));
            patient.setPhoneNum(cursor.getString(cursor.getColumnIndex("phone_num")));
            patients.add(patient);
            cursor.moveToNext();
        }
        return patients;
    }





    //Insert New Status in Table Status

    public void insertnewStatus(Patient_status patient_status) {
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(date);
        long time = System.currentTimeMillis();
        SimpleDateFormat stf = new SimpleDateFormat("hh:mm:ss");
        String timestring = stf.format(time);

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p_Id", patient_status.getpId());
        contentValues.put("s_date", dateString);
        contentValues.put("s_time", timestring);
        contentValues.put("blood_pressure", patient_status.getBloodPressure());
        contentValues.put("diabetes_rate", patient_status.getDiabetesRate());
        contentValues.put("weight", patient_status.getWeight());
        contentValues.put("temp", patient_status.getTemp());
        contentValues.put("doctor_notes", patient_status.getDoctorNotes());
        contentValues.put("required_analyzes", patient_status.getReqAnalyzes());
        contentValues.put("required_xray", patient_status.getxRayReq());
        contentValues.put("drug", patient_status.getDrug());
        contentValues.put("next_visit", patient_status.getNextVisit());
        db.insert("Status", null, contentValues);

    }


    //Get All Status for Patient

    public List<Patient_status>getAllStatusforPatieant(int pId){

        List<Patient_status> patient_statuses = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Status where p_Id="+pId, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Patient_status patient_status = new Patient_status();
            patient_status.setId(cursor.getInt(cursor.getColumnIndex("id")));
            patient_status.setpId(cursor.getInt(cursor.getColumnIndex("p_Id")));
            patient_status.setsDate(cursor.getString(cursor.getColumnIndex("s_date")));
            patient_status.setsTime(cursor.getString(cursor.getColumnIndex("s_time")));
            patient_status.setBloodPressure(cursor.getString(cursor.getColumnIndex("blood_pressure")));
            patient_status.setDiabetesRate(cursor.getString(cursor.getColumnIndex("diabetes_rate")));
            patient_status.setWeight(cursor.getString(cursor.getColumnIndex("weight")));
            patient_status.setTemp(cursor.getString(cursor.getColumnIndex("temp")));
            patient_status.setDoctorNotes(cursor.getString(cursor.getColumnIndex("doctor_notes")));
            patient_status.setReqAnalyzes(cursor.getString(cursor.getColumnIndex("required_analyzes")));
            patient_status.setxRayReq(cursor.getString(cursor.getColumnIndex("required_xray")));
            patient_status.setDrug(cursor.getString(cursor.getColumnIndex("drug")));
            patient_status.setNextVisit(cursor.getString(cursor.getColumnIndex("next_visit")));
            patient_statuses.add(patient_status);
            cursor.moveToNext();

        }

        return patient_statuses;

    }

    public void deleteAllStatusforpatient(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("delete from Status where p_Id=" + Integer.toString(id));
    }

















}
