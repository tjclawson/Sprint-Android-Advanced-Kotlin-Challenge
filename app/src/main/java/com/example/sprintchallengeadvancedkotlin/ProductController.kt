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

        val myMatrixProduct = bundle.getSerializable("KEY") as Matrix
        val result = myMatrixProduct.matrix

        val tvProductRowOneColOne = view?.findViewById<TextView>(R.id.product_r1_c1)
        val tvProductRowOneColTwo = view?.findViewById<TextView>(R.id.product_r1_c2)
        val tvProductRowTwoColOne = view?.findViewById<TextView>(R.id.product_r2_c1)
        val tvProductRowTwoColTwo = view?.findViewById<TextView>(R.id.product_r2_c2)

        tvProductRowOneColOne?.text = result[0][0].toString()
        tvProductRowOneColTwo?.text = result[0][1].toString()
        tvProductRowTwoColOne?.text = result[1][0].toString()
        tvProductRowTwoColTwo?.text = result[1][1].toString()

        val testMatrix = Matrix(Array(3) { IntArray(3) { 0 } }, 3, 3)
        val testMatrixTwo = Matrix(Array(3) { IntArray(1) { 0 } }, 3, 1)

        testMatrix.matrix[0][0] = 1
        testMatrix.matrix[0][1] = 2
        testMatrix.matrix[0][2] = 3
        testMatrix.matrix[1][0] = 4
        testMatrix.matrix[1][1] = 5
        testMatrix.matrix[1][2] = 6
        testMatrix.matrix[2][0] = 7
        testMatrix.matrix[2][1] = 8
        testMatrix.matrix[2][2] = 9

        testMatrixTwo.matrix[0][0] = 1
        testMatrixTwo.matrix[1][0] = 2
        testMatrixTwo.matrix[2][0] = 3

    }
}