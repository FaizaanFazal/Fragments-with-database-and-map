package com.example.finalexam181924.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalexam181924.R;
import com.example.finalexam181924.model.data;

import java.util.ArrayList;
import java.util.List;


public class Viewhobbyfrag extends Fragment {
        List<data> studentlist= new ArrayList<>();
        RecyclerView recyclerView;
        com.example.finalexam181924.Adapter.recyclerviewadapter recyclerviewadapter;
        Button btns;


        public Viewhobbyfrag() {
            // Required empty public constructor
        }
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View view= inflater.inflate(R.layout.fragment_viewhobbyfrag, container, false);
            recyclerView= view.findViewById(R.id.recycler181924);
            btns=view.findViewById(R.id.btn_delete);

            viewDataOnTextView();
            btns.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });

            btns.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new addfrag()).commit();
                }
            });

            return view;
        }
        public  void viewDataOnTextView() {
        }
    }
