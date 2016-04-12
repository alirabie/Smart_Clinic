package examplewtest.midopc.smartclinic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import examplewtest.midopc.smartclinic.Database.Models.Patient;

/**
 * Created by Mido PC on 4/12/2016.
 */
public class ListAdb extends RecyclerView.Adapter<ListAdb.VH> {

    List<Patient>patients;
    Context context;

    public ListAdb(Context context, List<Patient> patients) {
        this.context = context;
        this.patients = patients;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.simble, parent, false));
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

        holder.textView1.setText(patients.get(position).getFullName());
        holder.textView2.setText(patients.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public static class VH extends RecyclerView.ViewHolder{


        private TextView textView1;
        private TextView textView2;

        public VH(View itemView) {
            super(itemView);

            textView1=(TextView)itemView.findViewById(R.id.t1);
            textView2=(TextView)itemView.findViewById(R.id.t2);

        }
    }
}
