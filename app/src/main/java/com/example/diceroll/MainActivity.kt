package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{
            val luckynum = 4
            rollDice(luckynum)

        }
    }

    private fun rollDice(luckyNum: Int) {
        val dice = Dice(6)
        val returnImageView: ImageView = findViewById(R.id.imageView)
        val returnImageView2: ImageView = findViewById(R.id.imageView2)
        val returnTextView: TextView = findViewById(R.id.textView)
        val randomNum = dice.roll()
        when(randomNum) {
            1 -> returnImageView.setImageResource(R.drawable.dice_1)
            2 -> returnImageView.setImageResource(R.drawable.dice_2)
            3 -> returnImageView.setImageResource(R.drawable.dice_3)
            4 -> returnImageView.setImageResource(R.drawable.dice_4)
            5 -> returnImageView.setImageResource(R.drawable.dice_5)
            6 -> returnImageView.setImageResource(R.drawable.dice_6)
        }

        if (randomNum == luckyNum){
            returnTextView.text = "Congrats!!! Its the lucky number."
            returnImageView2.setImageResource(R.color.green)

        } else {
            returnTextView.text = "Sorry!!! Better luck next time."

            returnImageView2.setImageResource(R.color.red)
        }
    }
}

class Dice(val sides: Int){
    fun roll(): Int{
        return (1..sides).random()
    }
}