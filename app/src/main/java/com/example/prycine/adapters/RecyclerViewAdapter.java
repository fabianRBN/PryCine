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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.prycine.R;
import com.example.prycine.activities.DetalleActivity;
import com.example.prycine.activities.ScrollingDetalleActivity;
import com.example.prycine.models.Pelicula;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Pelicula> mData;
    RequestOptions options;

    public RecyclerViewAdapter(Context mContext, List<Pelicula> mData){
        this.mContext = mContext;
        this.mData = mData;
        options =new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.pelicula_row_item,parent,false);

        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, ScrollingDetalleActivity.class);
                i.putExtra("pe_nombre",mData.get(viewHolder.getAdapterPosition()).getPe_nombre());
                i.putExtra("pe_descripcion",mData.get(viewHolder.getAdapterPosition()).getPe_detalle());
                i.putExtra("pe_imag",mData.get(viewHolder.getAdapterPosition()).getPe_imagen());
                i.putExtra("id_pelicula",mData.get(viewHolder.getAdapterPosition()).getId_pelicula());



                mContext.startActivity(i);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getPe_nombre());
        holder.tv_categoria.setText(mData.get(position).getPe_categoria());

        Glide.with(mContext).load(mData.get(position).getPe_imagen()).apply(options).into(holder.img_pelicula);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView tv_name, tv_rating, tv_detalle,tv_director,tv_categoria;
        ImageView img_pelicula;
        LinearLayout view_container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.container);
           tv_name = itemView.findViewById(R.id.anime_name);
           tv_categoria = itemView.findViewById(R.id.categorie);
           img_pelicula = itemView.findViewById(R.id.thumbnail);


        }
    }
}
