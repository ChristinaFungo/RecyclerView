package com.khrystynahryb.recyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


public class AdapterPharmacy extends RecyclerView.Adapter<AdapterPharmacy.MyViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

   public AdapterPharmacy(Context ct, String name[], String adress[], String description[], int image[]){
        context = ct;
        data1 = name;
        data2 = adress;
        data3 = description;
        images = image;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
       holder.tv_name_pharmacy.setText(data1[position]);
       holder.tv_adress_pharmacy.setText(data2[position]);
       holder.iv_pharmacy.setImageResource(images[position]);
       //lambda
       holder.mainLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(context, Pharmacy.class);
               intent.putExtra("data1", data1[position]);
               intent.putExtra("data2", data2[position]);
               intent.putExtra("data3", data3[position]);
               intent.putExtra("myImage", images[position]);
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

       TextView tv_name_pharmacy, tv_adress_pharmacy;
       ImageView iv_pharmacy;
       ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name_pharmacy = itemView.findViewById(R.id.tv_name_pharmacy);
            tv_adress_pharmacy = itemView.findViewById(R.id.tv_adress_pharmacy);
            iv_pharmacy = itemView.findViewById(R.id.iv_pharmacy);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }

}
