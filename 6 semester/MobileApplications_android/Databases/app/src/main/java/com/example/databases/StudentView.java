package com.example.databases;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentView extends BaseAdapter {

    LayoutInflater mInflater;
    private final ArrayList<Student> students;
    private OnItemClickListener onItemClickListener;

    public StudentView(Context context, ArrayList<Student> students, OnItemClickListener onItemClickListener) {
        this.mInflater = LayoutInflater.from(context);
        this.students=students;
        this.onItemClickListener = onItemClickListener;
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

        if (recordView == null)  {
            recordView = mInflater.inflate(R.layout.student_record, null);
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
                //TODO
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("StudentView", "Delete button clicked for: " + student.name);
                students.remove(student);
                notifyDataSetChanged();
            }
        });

        // now this has errors
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
