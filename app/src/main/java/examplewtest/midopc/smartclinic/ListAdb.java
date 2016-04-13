package examplewtest.midopc.smartclinic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import examplewtest.midopc.smartclinic.Database.Models.Patient;

/**
 * Created by Mido PC on 4/12/2016.
 */
public class ListAdb extends RecyclerView.Adapter<ListAdb.VH> {

    private Context context;

    public ListAdb(Context context) {
        this.context = context;
    }

    int []pics={R.drawable.add,R.drawable.all,R.drawable.stat};
     String[]lables={"Add New Patient","Patient History","See All Patients"};


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false));
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {



        holder.lable.setText(lables[position]);
        holder.img.setImageResource(pics[position]);
        holder.img.setBorderWidth(3);
        holder.img.setBorderColor(R.color.colorPrimary);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0)
                    context.startActivity(new Intent(context.getApplicationContext(),Newpatiant.class));
                if(position==1)
                    Log.d("gooooooooooooo","all");
                if(position==2)
                    Log.d("gooooooooooooo","status");
            }
        });

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class VH extends RecyclerView.ViewHolder{


        private TextView lable;
        private CircleImageView img;

        public VH(View itemView) {
            super(itemView);
            lable=(TextView)itemView.findViewById(R.id.lable);
            img=(CircleImageView)itemView.findViewById(R.id.add);

        }
    }
}
