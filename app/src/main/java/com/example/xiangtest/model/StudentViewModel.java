package com.example.xiangtest.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.xiangtest.Bean.Student;
import com.example.xiangtest.repository.StudentRepository;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {


    private final StudentRepository studentRepository;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        studentRepository = new StudentRepository(application);
        //AppDatabase database = AppDatabase.getInstance(application);
    }

    //提供一些API给viewmodel使用
    public void insert(Student... students) {
        studentRepository.insert(students);
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }

    public void update(Student student) {
        studentRepository.update(student);
    }

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public LiveData<List<Student>> getAllLiveDataStudent() {
        return studentRepository.getAllLiveDataStudent();
    }
}
