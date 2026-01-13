package com.example.databases;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class StudentView extends BaseAdapter {

    private final Context context;
    private final LayoutInflater mInflater;
    private final ArrayList<Student> students;
    private final OnItemClickListener onItemClickListener;
    private final DatabaseHelper db;

    public StudentView(Context context, ArrayList<Student> students, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.students = students;
        this.onItemClickListener = onItemClickListener;
        this.db = new DatabaseHelper(context);
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View recordView, ViewGroup parentView) {

        if (recordView == null) {
            recordView = mInflater.inflate(R.layout.student_record, parentView, false);
        }

        TextView studentInfo = recordView.findViewById(R.id.studentInfo);
        TextView studentScore = recordView.findViewById(R.id.studentScore);
        ImageView studentPhoto = recordView.findViewById(R.id.studentImage);

        Student student = students.get(position);

        studentInfo.setText(student.toString());
        studentScore.setText("Average = " + Double.toString(student.average));
        studentPhoto.setImageResource(student.image);

        ImageButton editButton = recordView.findViewById(R.id.editStudent);
        ImageButton deleteButton = recordView.findViewById(R.id.deleteStudent);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                StudentEditFragment studentEditFragment = new StudentEditFragment();


                Bundle bundle = new Bundle();
                bundle.putSerializable("student", student);
                studentEditFragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment_container, studentEditFragment);
                fragmentTransaction.commit();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean removalSuccessful = db.removeRecord(student.id);
                String name = student.name + " " + student.surname;
                if (removalSuccessful) {
                    students.remove(position);
                    Toast.makeText(context, "Successfully removed \"" + name + "\"", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to remove \"" + name + "\"", Toast.LENGTH_SHORT).show();
                }
                notifyDataSetChanged();
            }
        });

        recordView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });

        return recordView;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
