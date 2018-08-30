package com.example.huangcl.greendaoupdatedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.huangcl.greendaoupdatedemo.DaoTable.Student;

import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView addText,showText,deleteText,displayText;
    private List<Student> studentList=new ArrayList<>();
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addText=(TextView)findViewById(R.id.tv_add);
        deleteText=(TextView)findViewById(R.id.tv_delete);
        showText=(TextView)findViewById(R.id.tv_show);
        displayText=(TextView)findViewById(R.id.tv_display); 

        addText.setOnClickListener(this);
        deleteText.setOnClickListener(this);
        displayText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_add:
                for(int i=1;i<=5;++i) {
                    DatabaseManager.getInstance().getDaoSession().insert(new Student(null,"student"+i,"男"));
                }
                break;
            case R.id.tv_display:
                text="";
                studentList=DatabaseManager.getInstance().getDaoSession().getStudentDao().loadAll();
                for(Student student : studentList) {
                    text=text+student.getId()+"  "+student.getName()+"  "+student.getSex()+"\n";
                }
                showText.setText(text);
                break;
            case R.id.tv_delete:
                DatabaseManager.getInstance().getDaoSession().getStudentDao().deleteAll();
                text="";
                showText.setText(text);
                break;
        }
    }
}
