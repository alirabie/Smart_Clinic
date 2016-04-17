package examplewtest.midopc.smartclinic.Activites;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import examplewtest.midopc.smartclinic.Database.AppDb;
import examplewtest.midopc.smartclinic.Database.Models.Patient_status;
import examplewtest.midopc.smartclinic.R;

public class StatusForm extends AppCompatActivity {

    private EditText bloodP,diabR,weight,temp,otheranalysis,reqxray,drug,doctornotes,nextvisit;
    private CheckBox uanalysis,stool,blood;
    private ImageView savebtn;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_form);
        final int recivedId = getIntent().getIntExtra("patiaentid", 1);


        //Edit texts
        bloodP=(EditText)findViewById(R.id.Blodform);
        diabR=(EditText)findViewById(R.id.diabform);
        weight=(EditText)findViewById(R.id.weigtform);
        temp=(EditText)findViewById(R.id.tempform);
        otheranalysis=(EditText)findViewById(R.id.otheranalysisform);
        reqxray=(EditText)findViewById(R.id.xrayform);
        drug=(EditText)findViewById(R.id.drugform);
        doctornotes=(EditText)findViewById(R.id.notesform);
        nextvisit=(EditText)findViewById(R.id.nextvisitform);


        //Checkboxes
        uanalysis=(CheckBox)findViewById(R.id.urin);
        stool=(CheckBox)findViewById(R.id.stool);
        blood=(CheckBox)findViewById(R.id.blood);







        //Save Button
        savebtn=(ImageView)findViewById(R.id.okstatus);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uri="";
                String stooll="";
                String bloodd="";


                if(uanalysis.isChecked())
                    uri = " urine Analysis ";

                if(stool.isChecked())
                    stooll=" Stool Analysis ";

                if(blood.isChecked())
                    bloodd=" Blood Analysis ";




                AppDb db=new AppDb(getApplicationContext());
                Patient_status status=new Patient_status();
                status.setpId(recivedId);
                status.setBloodPressure(bloodP.getText().toString());
                status.setDiabetesRate(diabR.getText().toString());
                status.setWeight(weight.getText().toString());
                status.setTemp(temp.getText().toString());
                status.setReqAnalyzes(uri + stooll + bloodd + otheranalysis.getText().toString());
                status.setxRayReq(reqxray.getText().toString());
                status.setDrug(drug.getText().toString());
                status.setDoctorNotes(doctornotes.getText().toString());
                status.setNextVisit(nextvisit.getText().toString());
                db.insertnewStatus(status);

                finish();

            }
        });

















    }

}
