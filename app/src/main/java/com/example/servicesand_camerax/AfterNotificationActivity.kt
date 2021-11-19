package com.example.servicesand_camerax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_after_notification.*
import java.util.*

class AfterNotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_notification)


        val random = Random()

        // on click listener for btnSpin
        btnSpin.setOnClickListener {
            // disabling the button so that user
            // should not click on the button
            // while the wheel is spinning
            btnSpin.setEnabled(false)
            // reading random value between 10 to 30
            var spin = random.nextInt(20)+10

            // since the wheel has 10 divisions, the
            // rotation should be a multiple of
            // 360/10 = 36 degrees
            spin = spin * 12 // rotaion time

            // timer for each degree movement
            var timer = object : CountDownTimer ((spin*20).toLong(),1){
                override fun onTick(p0: Long) {
                    // rotate the wheel
                    var  rotation = ivWheel.getRotation() + 4  /// speed
                    ivWheel.setRotation(rotation)

                }

                override fun onFinish() {
                    // enabling the button again
                    btnSpin.setEnabled(true);
                }

            }.start() }

        btnNext.setOnClickListener{
            startActivity(Intent(this,LuckyDrawAcrivity::class.java))
        }
    }
    }
