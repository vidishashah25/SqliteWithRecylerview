package com.example.admin.sqlitewithrecylerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.sqlitewithrecylerview.R;
import com.example.admin.sqlitewithrecylerview.models.StudentModel;

import java.util.ArrayList;

/**
 * Created by Admin on 2/10/2017.
 */

//StudentAdapter

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    Context c;
    ArrayList<StudentModel> studentDetails = new ArrayList<>();

    public StudentAdapter(Context c, ArrayList<StudentModel> studentDetails) {
        this.c = c;
        this.studentDetails = studentDetails;
    }

    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_students, parent, false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvID.setText("" + studentDetails.get(position).getStudentID());
        holder.tvName.setText(studentDetails.get(position).getStudentName());
        holder.tvEmail.setText(studentDetails.get(position).getStudentEmail());
    }

    @Override
    public int getItemCount() {

        return studentDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvID;
        TextView tvEmail;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvID = (TextView) itemView.findViewById(R.id.tvID);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);


        }
    }
}
