package com.example.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var mFirstImage : ImageView
    private lateinit var mSecondImage : ImageView
    private lateinit var mFirstScore : TextView
    private lateinit var mSecondScore : TextView
    private var  mFirstPlayerScore = 0
    private var mSecondPlayerScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    fun setupView(){
        mFirstImage = findViewById(R.id.first_img)
        mSecondImage = findViewById(R.id.second_img)
        mFirstScore = findViewById(R.id.firstScoreTV)
        mSecondScore = findViewById(R.id.SecondScoreTV)
    }

    fun playGame(view: View){
        var firstImage : Int = 0
        var secondImage : Int = 0
        var result: Winner = Winner.DRAW

        when(view.id){
            R.id.rockBtn -> {
                firstImage = R.drawable.rock
                secondImage = Generator.getImage()
                setImageResource(firstImage,secondImage)
                result = Comparators.compare(firstImage,secondImage)
                writeScore(result)
            }
            R.id.paperBtn -> {
                firstImage = R.drawable.paper
                secondImage = Generator.getImage()
                setImageResource(firstImage,secondImage)
                result = Comparators.compare(firstImage,secondImage)
                writeScore(result)
            }
            R.id.scissorsBtn -> {
                firstImage = R.drawable.scissors
                secondImage = Generator.getImage()
                setImageResource(firstImage,secondImage)
                result = Comparators.compare(firstImage,secondImage)
                writeScore(result)
            }
        }
    }

    fun setImageResource(firstImage: Int , secondImage: Int){
        mFirstImage.setImageResource(firstImage)
        mSecondImage.setImageResource(secondImage)
    }

    fun writeScore(winner: Winner){
        when(winner){
            Winner.DRAW -> Toast.makeText(this,"Draw",Toast.LENGTH_SHORT).show()
            Winner.FIRST -> {
                Toast.makeText(this,"You Win",Toast.LENGTH_SHORT).show()
                mFirstPlayerScore++
                mFirstScore.text = mFirstPlayerScore.toString()
        }
            Winner.SECOND ->{
                Toast.makeText(this,"Opponent Win",Toast.LENGTH_SHORT).show()
                mSecondPlayerScore++
                mSecondScore.text = mSecondPlayerScore.toString()
            }
        }
    }

    fun reset(view: View){
        mFirstPlayerScore = 0
        mSecondPlayerScore = 0

        mFirstScore.text = mFirstPlayerScore.toString()
        mSecondScore.text = mSecondPlayerScore.toString()

        var firstImage : Int = 0
        var secondImage : Int = 0

        firstImage = R.drawable.all
        secondImage = R.drawable.all
        setImageResource(firstImage,secondImage)

        Toast.makeText(this,"The game has been reset",Toast.LENGTH_SHORT).show()
    }
}