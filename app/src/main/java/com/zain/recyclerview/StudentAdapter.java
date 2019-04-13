package com.zain.recyclerview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private static List<Student> students;
    private static Context context;
    private OnAdapterClickListener listener;

    private interface OnAdapterClickListener{
        void onClick(Student student);
    }

    public StudentAdapter(List<Student> students, Context context, OnAdapterClickListener listener) {
        this.students = students;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_main, viewGroup);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Student student = students.get(i);
        viewHolder.nameText.setText(student.getName());
        viewHolder.idText.setText(student.getId());
    }

    @Override
    public int getItemCount() {
        return (students != null)? students.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView idText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.text_name);
            idText = itemView.findViewById(R.id.text_id);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student student = students.get(getAdapterPosition());
                    Toast.makeText(context,student.getName(),Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }
    }
}
