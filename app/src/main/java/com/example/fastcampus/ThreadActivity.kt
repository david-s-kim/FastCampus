package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val currentThread = Thread.currentThread()
        Log.d("testt", "" + currentThread)

//        Thread {
//            for (a in 1..10) {
//                Log.d("testt", "A" + a)
//            }
//        }.start()
//
//        Thread {
//            for (a in 1..10) {
//                  Log.d("testt", "B" + a)
//            }
//        }.start()

        Thread {
            val currentThread = Thread.currentThread()
            Log.d("testt", "A" + currentThread)
            findViewById<TextView>(R.id.test).text = "change"
            // UI 관련 작업을 Main Thread 가 아닌 Thread 에서 하려고 하면 해당 작업은 Main Thread 의
            // queue 로 들어간다. -> 에러가 발생하지 않을 수도 있다.
            runOnUiThread{ // 실제로 선호되는 방법
                findViewById<TextView>(R.id.test).text = "change"
            }
        }.start()

    }
}