package com.example.myfirstpractical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var numberText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.diceImage)
        numberText = findViewById(R.id.numberTxt)
        val rollButton: Button = findViewById(R.id.rollBtn)

        rollButton.setOnClickListener{ rollDice() }


    }

    private fun rollDice(){
        Toast.makeText(this, "!Roll", Toast.LENGTH_LONG).show()

        val randomNum = (1..6).random()
        numberText.text = randomNum.toString()
        val imgSrc = when (randomNum){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(imgSrc)
    }
}