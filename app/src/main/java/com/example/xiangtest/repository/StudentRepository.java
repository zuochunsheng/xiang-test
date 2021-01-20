package com.example.xiangtest.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.xiangtest.AppDatabase;
import com.example.xiangtest.Bean.Student;
import com.example.xiangtest.dao.StudentDao;

import java.util.List;

public class StudentRepository {

    private LiveData<List<Student>> liveDataAllStudent;
    private StudentDao studentDao;

    public StudentRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        studentDao = database.userDao();

        if(liveDataAllStudent == null){
            liveDataAllStudent = studentDao.getAllLiveDataStudent();
        }

    }

    //提供一些API给viewmodel使用
    public  void insert(Student... students) {
        studentDao.insert(students);
    }

    public void delete(Student student) {
        studentDao.delete(student);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public List<Student> getAll() {
        return studentDao.getAll();
    }

    public LiveData<List<Student>> getAllLiveDataStudent() {
        return studentDao.getAllLiveDataStudent();
    }
}
