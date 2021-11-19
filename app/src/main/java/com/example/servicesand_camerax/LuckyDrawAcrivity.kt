package com.example.servicesand_camerax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_lucky_draw_acrivity.*

class LuckyDrawAcrivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_draw_acrivity)

        val mylist = mutableListOf<Int>()
        mylist.add(R.drawable.tatoo_1)
        mylist.add(R.drawable.tatoo_2)
        mylist.add(R.drawable.tatoo_3)
        mylist.add(R.drawable.tatoo_4)
        mylist.add(R.drawable.tatoo_5)
        mylist.add(R.drawable.tatoo_6)

        wheelSpinner.setArrowPointer(ivArrow)
        wheelSpinner.setBitmapsId(mylist)
        wheelSpinner.setOnItemSelectListener {
            ivSelectedTattoo.setImageBitmap(it)
            ivSelectedTattoo.visibility = View.VISIBLE
        }
        btnMySpin.setOnClickListener {
            ivSelectedTattoo.visibility = View.GONE
            wheelSpinner.rotateWheel()
        }

    }
}