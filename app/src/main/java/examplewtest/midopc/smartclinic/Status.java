package examplewtest.midopc.smartclinic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import examplewtest.midopc.smartclinic.Database.AppDb;

public class Status extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        AppDb appDb=new AppDb(this);
         int id= getIntent().getIntExtra("id", 1);



        TextView nametag=(TextView)findViewById(R.id.reportpatientname);
        nametag.setText(  appDb.getName(id));






    }

}
