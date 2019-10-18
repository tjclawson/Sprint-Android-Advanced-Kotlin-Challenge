package com.example.sprintchallengeadvancedkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType

class ProductController(val bundle: Bundle): Controller() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.product_controller_layout, container, false)
        return view
    }

    override fun onChangeEnded(changeHandler: ControllerChangeHandler, changeType: ControllerChangeType) {
        super.onChangeEnded(changeHandler, changeType)

        val myInt = bundle.getInt("KEY")

        val tvProductRowOneColOne = view?.findViewById<TextView>(R.id.product_r1_c1)
        val tvProductRowOneColTwo = view?.findViewById<TextView>(R.id.product_r1_c2)
        val tvProductRowTwoColOne = view?.findViewById<TextView>(R.id.product_r2_c1)
        val tvProductRowTwoColTwo = view?.findViewById<TextView>(R.id.product_r2_c2)

        tvProductRowOneColOne?.text = myInt.toString()
        tvProductRowOneColTwo?.text = myInt.toString()
        tvProductRowTwoColOne?.text = myInt.toString()
        tvProductRowTwoColTwo?.text = myInt.toString()
    }

}