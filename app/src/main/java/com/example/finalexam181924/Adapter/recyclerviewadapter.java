package com.example.finalexam181924.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalexam181924.R;
import com.example.finalexam181924.model.data;

import java.util.List;

public class recyclerviewadapter extends RecyclerView.Adapter<recyclerviewadapter.ViewHolder> {
    List<data> studentList;
    Context context;

    public recyclerviewadapter(List<data> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public recyclerviewadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerviewadapter.ViewHolder holder, int position) {
        data student= studentList.get(position);
        holder.txtname.setText(student.getHobbyname());
        holder.txtdiscription.setText(student.getDiscription());

    }

    @Override
    public int getItemCount()
    {
        return studentList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtname,txtdiscription;
        Button btndelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname=itemView.findViewById(R.id.t1);
            txtdiscription=itemView.findViewById(R.id.t2);
            btndelete=itemView.findViewById(R.id.btn_delete);
            itemView.setOnClickListener(this);
            btndelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    studentList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });

        }

        @Override
        public void onClick(View v) {
        }
    }
}