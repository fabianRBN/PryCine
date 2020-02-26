package com.example.prycine.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.example.prycine.R;
import com.example.prycine.activities.ScrollingDetalleActivity;
import com.example.prycine.models.Calendario;


import java.util.List;

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.MyViewHolder> {


    private Context mContext;
    private List<Calendario> mData;
    RequestOptions options;

    public HorarioAdapter(Context applicationContext, List<Calendario> listCalendario) {
        this.mContext = applicationContext;
        this.mData = listCalendario;
        options =new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.calendario_row_item,parent,false);

        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        /*
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, ScrollingDetalleActivity.class);
                i.putExtra("pe_nombre",mData.get(viewHolder.getAdapterPosition()).getPe_nombre());
                i.putExtra("pe_descripcion",mData.get(viewHolder.getAdapterPosition()).getPe_detalle());
                i.putExtra("pe_imag",mData.get(viewHolder.getAdapterPosition()).getPe_imagen());


                mContext.startActivity(i);

            }
        });

         */
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HorarioAdapter.MyViewHolder holder, int position) {
        holder.tv_calendario.setText(mData.get(position).getSala()+" "+mData.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView tv_calendario;
        LinearLayout view_container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.containerCalendario);
            tv_calendario = itemView.findViewById(R.id.calendarioid);



        }
    }
}
