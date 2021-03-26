package com.example.xiangtest

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.testbyxiang.IMyAidlInterface
import com.example.xiangtest.Bean.Student
import com.example.xiangtest.model.StudentViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    var studentViewModel: StudentViewModel? = null
    private var iMyAidlInterface: IMyAidlInterface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val function: (v: View) -> Unit = { view ->
            Snackbar.make(view, "Replace with your own action :"+ iMyAidlInterface?.name.toString(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
                Log.e("jett", "传递的值:"+ iMyAidlInterface?.name)
        }
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener(function)

        //数据库的操作应该是在子线程
//        var t = DbTest(applicationContext)
//        t.start()

//        val instance = AppDatabase.getInstance(applicationContext)
//        val dao = instance.userDao()
//
//        dao.insert(Student("jett", "123", 1))
//        dao.insert(Student("jett1", "123", 2))
//        dao.insert(Student("jett2", "123", 3))
//        dao.insert(Student("jett3", "123", 4))
//
//        val list: List<Student> = dao.getAll()
//        Log.i("jett", list.toString())
//
//        val jett2: Student = dao.findByName("jett3")
//        Log.i("jett2", jett2.toString())
//        val allId: List<Student> = dao.getAllId(intArrayOf(2, 3, 4))
//        Log.i("jett", allId.toString())
//
//        val record: List<StudentTuple> = dao.getRecord()
 //       Log.i("jett", record.toString())

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)
        studentViewModel?.getAllLiveDataStudent()?.observe(this, Observer {
            Log.i("jett", it.toString())
            //Log.i("jett name", it?.get(5).name)
        })


        for (i in 0..49) {
            studentViewModel?.insert(Student("jett", "123", 1))
        }

//        object : Thread() {
//            override fun run() {
//                for (i in 0..49) {
//                    try {
//                        sleep(1000)
//                    } catch (e: Exception) {
//                        e.printStackTrace()
//                    }
//                    studentViewModel?.update(Student(6, "jett$i", "123", 1))
//                }
//            }
//        }.start()


        //需要显示调用
        var intent = Intent()
//
        intent.action = "com.example.testbyxiang.myservice" //MyService 的 filter
        intent.`package` = "com.example.testbyxiang"
        //startService(intent)
        bindService(intent, object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Log.e("jett", "onServiceConnected: " )

                iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service)
                Log.e("jett", "传递的值:"+ iMyAidlInterface?.name)
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                //iMyAidlInterface = null

            }
        }, BIND_AUTO_CREATE)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


//    class DbTest(var applicationContext: Context) : Thread() {
//
//        override fun run() {
//            super.run()
//            //数据库的操作都在这里进行
//            var jettDB = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "jettDB").build()
//            var dao: StudentDao = jettDB.userDao()
//
//            dao.insert(Student("jett", "123", 1))
//            dao.insert(Student("jett1", "123", 2))
//            dao.insert(Student("jett2", "123", 3))
//            dao.insert(Student("jett3", "123", 4))
//
//            val list: List<Student> = dao.getAll()
//            Log.i("jett", list.toString())
//
//            val jett2: Student = dao.findByName("jett3")
//            Log.i("jett2", jett2.toString())
//            val allId: List<Student> = dao.getAllId(intArrayOf(2, 3, 4))
//            Log.i("jett", allId.toString())
//
//            val record: List<StudentTuple> = dao.getRecord()
//            Log.i("jett", record.toString())
//        }
//    }
}