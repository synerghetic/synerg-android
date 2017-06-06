package net.synerghetic.synerg.fragments;

/**
 * Created by aude on 31/05/2017.
 */

import android.app.ProgressDialog;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import net.synerghetic.synerg.R;
import net.synerghetic.synerg.model.Admin;

import java.util.ArrayList;
import java.util.List;


public class Tab1Bureau extends Fragment {
    RecyclerView re;
    View v;
    private List<Admin> dataset=new ArrayList<>();
    private List<String> mDatakey=new ArrayList<>();
    ProgressDialog progress;
//    formadapter cc;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1bureau, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.v=view;
        init();
        //progress bar
        progress = new ProgressDialog(getActivity());
        progress.setTitle("Loading");
        progress.setMessage("Chargement");
        progress.setCancelable(false);
        progress.show();
        loaddata();
    }

    private void loaddata() {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("admins");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataset.clear();
                mDatakey.clear();

                for (DataSnapshot single : dataSnapshot.getChildren()) {
                    dataset.add(single.getValue(Admin.class));
                    mDatakey.add(single.getKey().toString());
                }
                progress.dismiss();

            }

        });
    }

    private void init() {
        re=(RecyclerView)v.findViewById(R.id.my_recycler_view);
        re.setLayoutManager(new LinearLayoutManager(getContext()));
//        cc= new formadapter(dataset,mDatakey,getActivity(),"e1Form");
//        re.setAdapter(cc);

    }

    //    //Create a field to store the admin display TextView
//    private TextView adminTextView;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.tab1bureau, container, false);
//
//        String[] membersData = {
//                "Juliette, Présidente", "Aude, Secrétaire Générale",
//                "Vanessa, Trésorière", "Sébastien, Vice-Trésorier",
//                "Pierre, Responsable Relations Publiques", "Yann-Edern, Responsable Projets",
//                "Constance, Responsable Projets", "Aymeric, Responsable Qualité",
//                "Anthelme, Responsable Commercial", "Antoine, Responsable Commercial", "Jules, Responsable Prospection"};
//
//        adminTextView = (TextView) v.findViewById(R.id.admin_data);
//        for (String member : membersData) {
//
//            adminTextView.append(member + "\n\n\n");
//        }

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1, membersData);
//        setListAdapter(adapter);


//        return v;


}

