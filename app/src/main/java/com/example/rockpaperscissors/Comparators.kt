package com.example.rockpaperscissors

object Comparators {

        fun  compare(firstImage: Int,secondImage: Int): Winner {
            var result: Winner = Winner.DRAW
            if (firstImage == secondImage)
                result = Winner.DRAW
            else if (firstImage == R.drawable.rock && secondImage == R.drawable.paper)
                result = Winner.SECOND
            else if (firstImage == R.drawable.rock && secondImage == R.drawable.scissors)
                result = Winner.FIRST
            else if (firstImage == R.drawable.paper && secondImage == R.drawable.rock)
                result = Winner.FIRST
            else if (firstImage == R.drawable.scissors && secondImage == R.drawable.rock)
                result = Winner.SECOND
            else if (firstImage == R.drawable.paper && secondImage == R.drawable.scissors)
                result = Winner.SECOND
            else if (firstImage == R.drawable.scissors && secondImage == R.drawable.paper)
                result = Winner.FIRST
            return result
        }
    }


enum class Winner{
    DRAW,FIRST,SECOND
}

