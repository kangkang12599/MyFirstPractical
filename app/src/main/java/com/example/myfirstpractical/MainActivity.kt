package com.example.myfirstpractical

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var diceImg: ImageView
    lateinit var numberTxt: TextView
    lateinit var nameTxt: EditText
    lateinit var playerNameTxt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImg = findViewById(R.id.diceImg)
        numberTxt = findViewById(R.id.numberTxt)
        nameTxt = findViewById(R.id.nameTxt)
        playerNameTxt = findViewById(R.id.playerNameTxt)
        val rollBtn: Button = findViewById(R.id.rollBtn)
        rollBtn.setOnClickListener{ rollDice() }
        val updateBtn: Button = findViewById(R.id.updateBtn)
        updateBtn.setOnClickListener { updateName(it) }
    }

    private fun updateName(view :View){
        playerNameTxt.text = "Hi, I am " + nameTxt.text

        nameTxt.text.clear()
        nameTxt.clearFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0);
    }

    private fun rollDice(){
        Toast.makeText(this, "!Roll", Toast.LENGTH_LONG).show()

        val randomNum = (1..6).random()
        numberTxt.text = randomNum.toString()
        val imgSrc = when (randomNum){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImg.setImageResource(imgSrc)
    }
}