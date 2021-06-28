package com.example.nimmer_quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide();


        button_register.setOnClickListener{
            openNextActivity()

        }

        button_login.setOnClickListener{
            openHomeActivity()
        }
    }
    private fun  openNextActivity(){
        val intent = Intent(this, register_activity::class.java)
        startActivity(intent)
    }

    private fun openHomeActivity(){
        val intent = Intent(this, home_Activity::class.java)
        startActivity(intent)
    }
}