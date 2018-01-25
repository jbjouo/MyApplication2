package com.example.user.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private var mIsLogin = false
    lateinit var test : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test=getSharedPreferences("test", Context.MODE_PRIVATE)
        mIsLogin=test.getBoolean("IsLogin",false)

        if(mIsLogin){
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_main_container, HomeFragment(), "HomeFragment")
                    .commit()
        }else{
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_main_container, LoginFragment(), "LoginFragment")
                    .commit()
        }



    }
}
