package com.example.gojuonandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.TextView
import android.content.Intent




class MainActivity : AppCompatActivity() {

    private val btnStartListener : View.OnClickListener = View.OnClickListener{
        val myIntent = Intent(this, GamePlayActivity::class.java)
        startActivity(myIntent);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Hide Navigation Bar
        this.getSupportActionBar()!!.hide();
        //End

        //Add listener to btnStart
        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener(btnStartListener)
        //End
    }
}
