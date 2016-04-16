package examplewtest.midopc.smartclinic.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import examplewtest.midopc.smartclinic.Activites.Patiants;
import examplewtest.midopc.smartclinic.Database.Models.Patient;
import examplewtest.midopc.smartclinic.PatiantProfile;
import examplewtest.midopc.smartclinic.R;

/**
 * Created by Mido PC on 4/14/2016.
 */
public class PatiantsAdb  extends RecyclerView.Adapter<PatiantsAdb.VH2> {

    private List<Patient>patients;
    private Context context;

    public PatiantsAdb(List<Patient> patients, Context context) {
        this.patients = patients;
        this.context = context;
    }

    @Override
    public VH2 onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH2(LayoutInflater.from(parent.getContext()).inflate(R.layout.patiantcontaner, parent, false));
    }

    @Override
    public void onBindViewHolder(VH2 holder, final int position) {

        holder.name.setText(patients.get(position).getFullName());
        holder.address.setText(patients.get(position).getDate());
        holder.id.setText(patients.get(position).getId() + "");
        holder.name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context.getApplicationContext(),PatiantProfile.class).putExtra("id", patients.get(position).getId()).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });



    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public static class VH2 extends RecyclerView.ViewHolder{

        TextView name,address,id;


        public VH2(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.nametxt22);
            address=(TextView)itemView.findViewById(R.id.addresstxt22);
            id=(TextView)itemView.findViewById(R.id.idtxt);

        }
    }


}
