package com.example.gojuonandroid

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.ActionMode
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class GamePlayActivity : AppCompatActivity()  {

    private var gojuon: Gojuon = Gojuon()
    private var qNo : Int = 0
    private var score : Int = 0
    private var choices : Map<Pair<String, String>, String> = HashMap<Pair<String, String>, String>()
    private var choiceSeq : List<Pair<String, String>> = LinkedList<Pair<String, String>>()
    private var ans : MutableMap.MutableEntry<Pair<String, String>, String>? = null
    private var btnChoice : MutableList<Button> = LinkedList<Button>()



    val btnChoice1Listener : View.OnClickListener = View.OnClickListener{
        checkAns(0)
    }

    val btnChoice2Listener : View.OnClickListener = View.OnClickListener{
        checkAns(1)
    }

    val btnChoice3Listener : View.OnClickListener = View.OnClickListener{
        checkAns(2)
    }

    val btnNextListener : View.OnClickListener = View.OnClickListener{
        qNo++
        if(qNo == 10){
            val myIntent = Intent(this, GameOverActivity::class.java)
            myIntent.putExtra("score", score.toString())
            startActivity(myIntent);

            qNo = 0
            score = 0
            gojuon = Gojuon()
        }else{
            val txtQNo = findViewById<TextView>(R.id.txtQNo)
            txtQNo.text = (qNo + 1).toString()

            draw()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        //Hide Navigation Bar
        this.getSupportActionBar()!!.hide();
        //End

        val btnChoice1 = findViewById<Button>(R.id.btnChoice1)
        val btnChoice2 = findViewById<Button>(R.id.btnChoice2)
        val btnChoice3 = findViewById<Button>(R.id.btnChoice3)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnChoice.add(btnChoice1)
        btnChoice.add(btnChoice2)
        btnChoice.add(btnChoice3)

        //Add listener to btnStart
        btnChoice1.setOnClickListener(btnChoice1Listener)
        btnChoice2.setOnClickListener(btnChoice2Listener)
        btnChoice3.setOnClickListener(btnChoice3Listener)
        btnNext.setOnClickListener(btnNextListener)
        //End
    }

    override fun onStart() {
        super.onStart()
        score = 0
        qNo = 0
        val txtQNo = findViewById<TextView>(R.id.txtQNo)
        txtQNo.text = (qNo + 1).toString()
        val txtScore = findViewById<TextView>(R.id.txtScore)
        txtScore.text = score.toString()
        draw()
    }

    private fun draw(){
        findViewById<Button>(R.id.btnNext).visibility = View.INVISIBLE
        findViewById<TextView>(R.id.txtMsg).text = ""
        btnChoice.forEach{
            it.isEnabled = true
            it.setBackgroundColor(ContextCompat.getColor(this,R.color.colorBtn))
        }

        ans = gojuon.pickAns()
        val txtAns = findViewById<TextView>(R.id.txtGojuon)
        txtAns.text = if ((0..1).random() == 0 )  ans!!.key.first else ans!!.key.second

        setChoices()
    }

    private fun setChoices(){
        gojuon.resetChoice()
        choices = gojuon.pickChoices(ans!!)
        choiceSeq = choices.keys.shuffled()
        choiceSeq.forEachIndexed{ index, it ->
            btnChoice[index].text = choices[it]
        }
    }

    fun checkAns(choiceNo : Int) {
        if (choices[choiceSeq[choiceNo]].equals(ans!!.value)) {
            score += 10
            val txtScore = findViewById<TextView>(R.id.txtScore)
            txtScore.text = score.toString()
            findViewById<TextView>(R.id.txtMsg).text = "Bingo! Please Press Next!"
        } else {
            findViewById<TextView>(R.id.txtMsg).text = "Wrong! Please Press Next!"
        }

        btnChoice.forEach {
            it.isEnabled = false
        }

        setAnsColor()

        findViewById<Button>(R.id.btnNext).visibility = View.VISIBLE

        gojuon.removeAns(ans!!)
    }

    fun setAnsColor(){
        choiceSeq.forEachIndexed{
            index,it->
            if(choices[it].equals(ans!!.value)){
                btnChoice[index].setBackgroundColor(Color.YELLOW)
            }
        }

    }
}
