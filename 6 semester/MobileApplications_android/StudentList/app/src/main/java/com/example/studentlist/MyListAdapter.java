package com.example.studentlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    private final ArrayList<Student> students;

    public MyListAdapter(Context context, ArrayList<Student> students) {
        this.mInflater = LayoutInflater.from(context);
        this.students=students;
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
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null)  {
            view = mInflater.inflate(R.layout.student_record, null);
        }

        TextView studentInfo = view.findViewById(R.id.studentInfo);
        TextView studentScore = view.findViewById(R.id.studentScore);
        ImageView studentPhoto = view.findViewById(R.id.studentImage);

        Student student = students.get(position);

        studentInfo.setText(student.toString());
        studentScore.setText("Average = " + Double.toString(student.average));
        studentPhoto.setImageResource(student.image);
        return view;
    }

    private class ViewHolder {
        TextView studentInfo;
        TextView studentScore;
        ImageView image;

        public ViewHolder(View view) {
            TextView studentInfo = view.findViewById(R.id.studentInfo);
            TextView studentScore = view.findViewById(R.id.studentScore);
            ImageView studentPhoto = view.findViewById(R.id.studentImage);
        }
    }

}
