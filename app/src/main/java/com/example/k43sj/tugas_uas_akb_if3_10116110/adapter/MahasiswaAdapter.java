package com.example.k43sj.tugas_uas_akb_if3_10116110.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.k43sj.tugas_uas_akb_if3_10116110.DetailActivity;
import com.example.k43sj.tugas_uas_akb_if3_10116110.R;
import com.example.k43sj.tugas_uas_akb_if3_10116110.model.MahasiswaModel;

import java.util.ArrayList;
import java.util.List;

/*
 * 12 Agustus 2019
 * 10116110
 * Muhamad Ibnu Tri Yuono
 * IF-3
 */

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MyViewHolder> {

    private List<MahasiswaModel> mahasiswaModels;
    Context context;

    public MahasiswaAdapter(Context context, List<MahasiswaModel> mahasiswaModels) {
        this.context = context;
        this.mahasiswaModels = mahasiswaModels;
    }

    @Override
    public MahasiswaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        return new MyViewHolder(v);
    }

//    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(MahasiswaAdapter.MyViewHolder holder, int position) {
        final MahasiswaModel model = mahasiswaModels.get(position);
        holder.nim.setText(String.valueOf(model.getNim()));
        holder.nama.setText(String.valueOf(model.getNama()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("id", Integer.parseInt(String.valueOf(model.getId())));
                intent.putExtra("nim", Integer.parseInt(String.valueOf(model.getNim())));
                intent.putExtra("nama", model.getNama());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mahasiswaModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nim, nama;

        public MyViewHolder(View itemView) {
            super(itemView);
            nim = itemView.findViewById(R.id.tvNim);
            nama = itemView.findViewById(R.id.tvNama);
        }
    }
}