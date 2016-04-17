package examplewtest.midopc.smartclinic.Adapters;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import examplewtest.midopc.smartclinic.Database.Models.Patient;
import examplewtest.midopc.smartclinic.Activites.Status;
import examplewtest.midopc.smartclinic.R;

/**
 * Created by Mido PC on 4/14/2016.
 */
public class PatiantsAdb extends RecyclerView.Adapter<PatiantsAdb.VH2> {

    private List<Patient> patients;
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
    public void onBindViewHolder(final VH2 holder, final int position) {

        holder.name.setText(patients.get(position).getFullName());
        holder.address.setText(patients.get(position).getAddress());
        holder.id.setText(patients.get(position).getId() + "");
        holder.name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context.getApplicationContext(), Status.class).putExtra("id", patients.get(position).getId()).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Url = patients.get(position).getPhoneNum().toString();
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+Url)));



            }
        });



    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public static class VH2 extends RecyclerView.ViewHolder{

        TextView name,address,id;
        ImageView call;


        public VH2(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.nametxt22);
            address=(TextView)itemView.findViewById(R.id.addresstxt22);
            id=(TextView)itemView.findViewById(R.id.idtxt);
            call=(ImageView)itemView.findViewById(R.id.call);

        }
    }


}
