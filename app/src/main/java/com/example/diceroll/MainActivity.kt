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
            rollDice()

        }
    }

    private fun rollDice() {
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val returnImageView1: ImageView = findViewById(R.id.imageView1)
        val returnImageView2: ImageView = findViewById(R.id.imageView2)
        val returnTextView: TextView = findViewById(R.id.textView)
        val randomNum1 = dice1.roll()
        val randomNum2 = dice2.roll()
        when(randomNum1) {
            1 -> returnImageView1.setImageResource(R.drawable.dice_1)
            2 -> returnImageView1.setImageResource(R.drawable.dice_2)
            3 -> returnImageView1.setImageResource(R.drawable.dice_3)
            4 -> returnImageView1.setImageResource(R.drawable.dice_4)
            5 -> returnImageView1.setImageResource(R.drawable.dice_5)
            6 -> returnImageView1.setImageResource(R.drawable.dice_6)
        }
        when(randomNum2) {
            1 -> returnImageView2.setImageResource(R.drawable.dice_1)
            2 -> returnImageView2.setImageResource(R.drawable.dice_2)
            3 -> returnImageView2.setImageResource(R.drawable.dice_3)
            4 -> returnImageView2.setImageResource(R.drawable.dice_4)
            5 -> returnImageView2.setImageResource(R.drawable.dice_5)
            6 -> returnImageView2.setImageResource(R.drawable.dice_6)
        }

        if (randomNum1 + randomNum2 == 6){
            returnTextView.text = "Congrats!!! You are out of jail."
            returnTextView.setBackgroundColor(resources.getColor(R.color.green))

        } else {
            returnTextView.text = "Sorry!!! You are still in jail."
            returnTextView.setBackgroundColor(resources.getColor(R.color.white))

        }
    }
}

class Dice(val sides: Int){
    fun roll(): Int{
        return (1..sides).random()
    }
}