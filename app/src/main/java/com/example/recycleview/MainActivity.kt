package com.example.recycleview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var recycleview = findViewById<RecyclerView>(R.id.recycleView)
        val layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recycleview.layoutManager = layoutManager


        var studentInfo = ArrayList<Student>()
        studentInfo.add(Student("ARJUN","arjunnarikkuni@gmailcom",27))
        studentInfo.add(Student(name = "ADARSH",email = "adarsh@gmail.com",age = 20))
        studentInfo.add(Student(name = "Mr.XY",email = "mrxy@gmail.com",age = 18))
        studentInfo.add(Student(name = "Mr.YYYY",email = "myyyyyrxy@gmail.com",age = 22))
        studentInfo.add(Student(name = "Mr.zzz",email = "zzz@gmail.com",age = 25))


        val adapters = CustomAdapter(studentInfo)
        recycleview.adapter = adapters
    }
}