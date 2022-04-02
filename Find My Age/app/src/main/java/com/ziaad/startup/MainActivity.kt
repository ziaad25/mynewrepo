package com.ziaad.startup

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ObjectInputStream
import java.lang.Exception
import java.sql.Time
import java.text.SimpleDateFormat
import java.time.Month
import java.util.*

class MainActivity : AppCompatActivity(), TextWatcher {
    var current_data = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())


    var day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    var month = Calendar.MONTH
    var year = Calendar.getInstance().get(Calendar.YEAR)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        ed_writeage.addTextChangedListener(this)

        ed_writeage.animate().translationX(-20f).duration = 2000
        btn_date.text = current_data.toString()


    }
    /*fun click (view: View){
        var yearofbirth:Int=buyourage.text.toString().toInt()
        var yearofday=Calendar.getInstance().get(Calendar.YEAR)
        var age :Int=yearofday-yearofbirth
        TV.text="your age is $age years old"


    }*/

    fun buclick(view: View) {
        if (view == butn_getage) {

            var yearofbirth: Int = ed_writeage.text.toString().toInt()

            var yearofday: Int = Calendar.getInstance().get(Calendar.YEAR)
            var age: Int = yearofday - yearofbirth
            tv_age.animate().alpha(1f).duration = 2000
            tv_age.text = ("Your age is $age years")

            if (age < 10) {
                tv_age.setBackgroundResource(R.color.light_blue)
            }
            if (age <= 20 && age > 10) {
                tv_age.setBackgroundResource(R.color.light2_blue)
            }


        }

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        var years: String = ed_writeage.text.toString()

        if (years.trim().length > 0) // .trim() is use to neglect the space
        {
            butn_getage.isEnabled = true
            butn_getage.setText(R.string.ON)
            butn_getage.setBackgroundResource(R.color.purple2)
        }


        if (years.trim().length == 0) {
            butn_getage.isEnabled = false
            butn_getage.setText(R.string.OFF)
            tv_age.animate().alpha(0f).duration = 1000
            butn_getage.setBackgroundResource(R.color.grey)

        }
    }

    override fun afterTextChanged(s: Editable?) {
        var years = s.toString()
        try {
            var num = s.toString().toInt()
            if (num > year || num < 0) {
                s?.replace(0, s.length, year.toString())
            }

        } catch (ex: Exception) {

        }
        if (years.trim().length == 3) {
            tv_age.animate().alpha(.8f).duration = 1000
        }
        if (years.trim().length == 2) {
            tv_age.animate().alpha(.5f).duration = 1000
        }
        if (years.trim().length == 1) {
            tv_age.animate().alpha(.3f).duration = 1000
        }

    }


}