package com.example.xiangtest.Bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.lang.reflect.Constructor;

@Entity()
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "pwd")
    private String password;
    @ColumnInfo(name = "addressId")
    private int addressId;

    @ColumnInfo(name="flag")
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", addressId=" + addressId +
                '}';
    }

    //public Student(){}
    public Student(String name, String password, int addressId) {
        this.name = name;
        this.password = password;
        this.addressId = addressId;
    }

    @Ignore
    public Student(int uid, String name, String password, int addressId) {
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.addressId = addressId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
