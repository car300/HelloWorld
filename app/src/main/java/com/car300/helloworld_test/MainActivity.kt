package com.car300.helloworld_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.car300.helloworld.HelloWorldJava
import com.car300.helloworld.HelloWorldKotlin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        HelloWorldJava().println()
        HelloWorldKotlin().println()
    }
}
