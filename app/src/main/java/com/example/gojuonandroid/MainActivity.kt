package com.example.gojuonandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.system.Os.bind
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.activity_main
import kotlinx.android.synthetic.main.activity_game_play.activity_game_play
import kotlinx.android.synthetic.main.activity_main.btnStart;




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Hide Navigation Bar
        this.getSupportActionBar()!!.hide();
        //

        //Add listener to btnStart
        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener{_->
            setContentView(R.layout.activity_game_play)
        }
        //
    }
}
