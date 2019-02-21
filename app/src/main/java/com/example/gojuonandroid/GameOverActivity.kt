package com.example.gojuonandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class GameOverActivity : AppCompatActivity() {

    val btnRestartListener : View.OnClickListener = View.OnClickListener{
        val myIntent = Intent(this, GamePlayActivity::class.java)
        startActivity(myIntent);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        //Hide Navigation Bar
        this.getSupportActionBar()!!.hide();
        //End

        //Add listener to btnRestart
        val btnRestart = findViewById<Button>(R.id.btnRestart)
        btnRestart.setOnClickListener(btnRestartListener)
        //End
    }

    override fun onStart() {
        super.onStart()
        findViewById<TextView>(R.id.txtFinalScore).text = intent.getStringExtra("score")
    }
}
