package com.ersinyurtseven.sayacprojesi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Abstract Class
        object :CountDownTimer(15000,250){
            override fun onFinish() {
                textView.text="Kalan=0"
            }
            override fun onTick(p0: Long) {
                textView.text="Kalan:${p0/1000}"
            }
        }.start()
    }
}