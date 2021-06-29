package com.example.finalexam181924.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.finalexam181924.R;
import com.example.finalexam181924.userModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.annotations.NotNull;


public class addfrag extends Fragment {
    EditText edt_name,edt_discription;
    Button btnadd;
    private FirebaseAuth mAuth;
    private FusedLocationProviderClient mfused;
    DatabaseReference myRef;

    public addfrag() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_addfrag, container, false);
        edt_name=view.findViewById(R.id.edt_hobname);
        edt_discription=view.findViewById(R.id.edt_hobdiscription);
        mAuth = FirebaseAuth.getInstance();


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addhobby();
            }
        });

        return view;
    }
    void addhobby()
    {
        String Name = edt_name.getText().toString();
        String Discription = edt_discription.getText().toString();

        mAuth.createUserWithEmailAndPassword(Name,Discription).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    userModel user = new userModel(Name,Discription);

                    String userId = mAuth.getCurrentUser().getUid();
                    myRef.child(userId).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getContext(), "Data is inserted in real time database", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }


                        }
                    });

                    Toast.makeText(getContext(), "Account Created", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}