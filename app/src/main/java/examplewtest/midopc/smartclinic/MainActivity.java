package examplewtest.midopc.smartclinic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import examplewtest.midopc.smartclinic.Adapters.ListAdb;
import examplewtest.midopc.smartclinic.Database.AppDb;
import examplewtest.midopc.smartclinic.Database.Models.Patient;
import examplewtest.midopc.smartclinic.Database.Models.Patient_status;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        final RecyclerView list=(RecyclerView)findViewById(R.id.list);
        list.setLayoutManager(new GridLayoutManager(this, 2));
        list.setAdapter(new ListAdb(this));


        Patient_status status=new Patient_status();

        status.setBloodPressure("120/80");
        status.setpId(1);
        status.setDrug("Zurcal");
        status.setxRayReq("Arm");
        status.setDiabetesRate("98");
        status.setDoctorNotes("good");
        status.setTemp("37");
        status.setWeight("60");
        status.setNextVisit("2/5/2016");







        AppDb db=new AppDb(this);
        db.insertnewStatus(status);







    }















    //Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //Option Menu components
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }










}
