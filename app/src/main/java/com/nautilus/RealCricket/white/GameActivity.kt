package com.nautilus.RealCricket.white

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.nautilus.RealCricket.R
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    val random = Random()
    fun getRandom(min: Float, max: Float): Float {
        require(min < max) { "Invalid range [$min, $max]" }
        return min + random.nextFloat() * (max - min)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val updateHandler = Handler()
        val runnable = Runnable {
            updateDisplay()
        }

        updateHandler.postDelayed(runnable, 5000)
    }

    override fun onStart() {
        super.onStart()
        crownIV.setOnClickListener{
            translater()
        }
    }
    private fun translater() {
        val min = 0.0f
        val max = 1.0f
        val randomTwo = getRandom(min, max)
        val animation = crownIV.animate()
            .x(randomTwo * (ll_wasp.width-crownIV.width))
            .y(randomTwo * (ll_wasp.height-crownIV.height))

        animation.duration = 300
        animation.start()

    }
    private fun updateDisplay() {
        cardView.visibility = View.INVISIBLE
    }
}