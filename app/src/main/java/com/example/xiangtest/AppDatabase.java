package com.example.xiangtest;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.xiangtest.Bean.Student;
import com.example.xiangtest.dao.StudentDao;

@Database(entities = {Student.class}, version = 5, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {//

    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class
                    , "jettDB")
                    //可以强制在主线程运行数据库操作
                    .allowMainThreadQueries()
                    //强制升级,会数据丢失
                    .fallbackToDestructiveMigration()
                    // 升级
//                    .addMigrations(MIGRATION_1_2)
//                    .addMigrations(MIGRATION_2_3)
                    .build();

        }
        return instance;
    }

    public abstract StudentDao userDao();


    //进行数据库升级
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //在这里用sql脚本完成数据变化
            //添加一列 flag
            database.execSQL("alter table student add column flag integer not null default 1");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // 移除一列 flag error
            database.execSQL("create table student_temp (uid integer primary key not null,name text,pwd text,addressId)");
            database.execSQL("insert into student_temp (name,pwd,addressid)" + " select name,pwd,addressid from student");
            database.execSQL("drop table student");
            database.execSQL("alter table student_temp rename to student");
        }
    };

}
