package examplewtest.midopc.smartclinic.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import examplewtest.midopc.smartclinic.Adapters.StatusListAdb;
import examplewtest.midopc.smartclinic.Database.AppDb;
import examplewtest.midopc.smartclinic.Database.Models.Patient;
import examplewtest.midopc.smartclinic.Database.Models.Patient_status;
import examplewtest.midopc.smartclinic.R;

public class Status extends AppCompatActivity {
       int id =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        id= getIntent().getIntExtra("id", 1);
        AppDb appDb = new AppDb(this);
        TextView nametag = (TextView) findViewById(R.id.reportpatientname);
        nametag.setText(appDb.getName(id));
        updatelist(getStatus(id));

        ImageView btnAdd=(ImageView)findViewById(R.id.addstatusbtn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(),StatusForm.class).putExtra("patiaentid",id));
            }
        });









}





    //Show and Update List
    public void updatelist(List<Patient_status>patient_statuses) {
        RecyclerView statuslist = (RecyclerView) findViewById(R.id.statuslist);
        StatusListAdb adb=new StatusListAdb(this,patient_statuses);
        statuslist.setAdapter(adb);
        statuslist.setLayoutManager(new LinearLayoutManager(this));
    }


    //Get Data from database
    public List<Patient_status>getStatus(int id){
        AppDb database=new AppDb(this);
        return database.getAllStatusforPatieant(id);
    }

    @Override
    protected void onResume() {
        super.onResume();

        updatelist(getStatus(id));
    }
}
