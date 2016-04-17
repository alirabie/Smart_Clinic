package examplewtest.midopc.smartclinic.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import examplewtest.midopc.smartclinic.Database.Models.Patient_status;
import examplewtest.midopc.smartclinic.R;

/**
 * Created by Mido PC on 4/17/2016.
 */
public class StatusListAdb extends RecyclerView.Adapter<StatusListAdb.VH> {

    private List<Patient_status>patient_statuses;
    Context context;

    public StatusListAdb(Context context, List<Patient_status> patient_statuses) {
        this.context = context;
        this.patient_statuses = patient_statuses;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.statuscontaner, parent, false));
    }



    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.sDate.setText(patient_statuses.get(position).getsDate());
        holder.sTime.setText(patient_statuses.get(position).getsTime());
        holder.bloodP.setText(patient_statuses.get(position).getBloodPressure());
        holder.diabR.setText(patient_statuses.get(position).getDiabetesRate());
        holder.weight.setText(patient_statuses.get(position).getWeight());
        holder.temp.setText(patient_statuses.get(position).getTemp());
        holder.doctorNotes.setText(patient_statuses.get(position).getDoctorNotes());
        holder.reqAnalysis.setText(patient_statuses.get(position).getReqAnalyzes());
        holder.xRay.setText(patient_statuses.get(position).getxRayReq());
        holder.drug.setText(patient_statuses.get(position).getDrug());
        holder.nextVisit.setText(patient_statuses.get(position).getNextVisit());
    }


    @Override
    public int getItemCount() {
        return patient_statuses.size();
    }

    public static class VH extends RecyclerView.ViewHolder{

        private TextView sDate,sTime,bloodP,diabR,weight,temp,doctorNotes,reqAnalysis,xRay,drug,nextVisit;
        public VH(View itemView) {
            super(itemView);
            sDate=(TextView)itemView.findViewById(R.id.sdate);
            sTime=(TextView)itemView.findViewById(R.id.stime);
            bloodP=(TextView)itemView.findViewById(R.id.bloodp);
            diabR=(TextView)itemView.findViewById(R.id.DiabetsR);
            weight=(TextView)itemView.findViewById(R.id.weight);
            temp=(TextView)itemView.findViewById(R.id.Temp);
            doctorNotes=(TextView)itemView.findViewById(R.id.doctorNotes);
            reqAnalysis=(TextView)itemView.findViewById(R.id.reqana);
            xRay=(TextView)itemView.findViewById(R.id.xrayReq);
            drug=(TextView)itemView.findViewById(R.id.drug);
            nextVisit=(TextView)itemView.findViewById(R.id.nextvisit);

        }
    }

}
