package com.ros.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var newop = true
    var number1 = ""
    var number2 = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Number(view: View) {
        if (newop)
            tv_result.setText("")
        newop = false
        var btnclick:String = tv_result.text.toString()
        var btnselect:Button = view as Button
        when (btnselect.id) {
            btn_one.id -> {btnclick += "1"}
            btn_two.id -> {btnclick += "2"}
            btn_three.id -> {btnclick += "3"}
            btn_four.id -> {btnclick += "4"}
            btn_five.id -> {btnclick += "5"}
            btn_six.id -> {btnclick += "6"}
            btn_seven.id -> {btnclick += "7"}
            btn_eight.id -> {btnclick += "8"} btn_one.id -> {btnclick += "1"}
            btn_nine.id -> {btnclick += "9"}
            btn_dot.id -> {btnclick += "."}
            btn_plusminus.id -> {btnclick = "-$btnclick"}
        }
        tv_result.setText(btnclick)
    }

    fun Operator(view: View) {
        newop = true
        number1 = tv_result.text.toString()
        var btnselect:Button=view as Button
        when (btnselect.id) {
            btn_plus.id -> {op = "+"}
            btn_minus.id -> {op = "-"}
            btn_times.id -> {op = "*"}
            btn_devided.id -> {op = "/"}
        }
    }

    fun Equal(view: View) {
        number2 = tv_result.text.toString()
        var result =0.0
        when (op) {
            "+" -> {result = number1.toDouble() + number2.toDouble()}
            "-" -> {result = number1.toDouble() - number2.toDouble()}
            "*" -> {result = number1.toDouble() * number2.toDouble()}
            "/" -> {result = number1.toDouble() / number2.toDouble()}
        }
        tv_result.setText(result.toString())
    }

    fun AC(view: View) {
        tv_result.text=("0")
        newop = true
    }

    fun Percent(view: View) {
        var percent = tv_result.text.toString().toDouble()/100
        tv_result.setText(percent.toString())
        newop = true
    }
}