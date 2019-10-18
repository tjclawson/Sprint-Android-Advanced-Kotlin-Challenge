package com.example.sprintchallengeadvancedkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler

class MainController : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.main_controller_layout, container, false)
        return view
    }

    override fun onChangeEnded(changeHandler: ControllerChangeHandler, changeType: ControllerChangeType) {
        super.onChangeEnded(changeHandler, changeType)

        val buttonMultiply = view?.findViewById<Button>(R.id.button_multiply)
        val etMatrixOneRowOneColOne = view?.findViewById<EditText>(R.id.et_m1_r1_c1)
        val etMatrixOneRowOneColTwo = view?.findViewById<EditText>(R.id.et_m1_r1_c2)
        val etMatrixOneRowTwoColOne = view?.findViewById<EditText>(R.id.et_m1_r2_c1)
        val etMatrixOneRowTwoColTwo = view?.findViewById<EditText>(R.id.et_m1_r2_c2)
        val etMatrixTwoRowOneColOne = view?.findViewById<EditText>(R.id.et_m2_r1_c1)
        val etMatrixTwoRowOneColTwo = view?.findViewById<EditText>(R.id.et_m2_r1_c2)
        val etMatrixTwoRowTwoColOne = view?.findViewById<EditText>(R.id.et_m2_r2_c1)
        val etMatrixTwoRowTwoColTwo = view?.findViewById<EditText>(R.id.et_m2_r2_c2)


        val myMatrixOne = Matrix(Array(2) {IntArray(2) { 0 } },2 ,2)
        val myMatrixTwo = Matrix(Array(2) {IntArray(2) { 0 } }, 2, 2)


        buttonMultiply?.setOnClickListener {

            val m1r1c1Text = etMatrixOneRowOneColOne?.text.toString()
            val m1r1c2Text = etMatrixOneRowOneColTwo?.text.toString()
            val m1r2c1Text = etMatrixOneRowTwoColOne?.text.toString()
            val m1r2c2Text = etMatrixOneRowTwoColTwo?.text.toString()
            val m2r1c1Text = etMatrixTwoRowOneColOne?.text.toString()
            val m2r1c2Text = etMatrixTwoRowOneColTwo?.text.toString()
            val m2r2c1Text = etMatrixTwoRowTwoColOne?.text.toString()
            val m2r2c2Text = etMatrixTwoRowTwoColTwo?.text.toString()

            myMatrixOne.matrix[0][0] = m1r1c1Text.toInt()
            myMatrixOne.matrix[0][1] = m1r1c2Text.toInt()
            myMatrixOne.matrix[1][0] = m1r2c1Text.toInt()
            myMatrixOne.matrix[1][1] = m1r2c2Text.toInt()

            myMatrixTwo.matrix[0][0] = m2r1c1Text.toInt()
            myMatrixTwo.matrix[0][1] = m2r1c2Text.toInt()
            myMatrixTwo.matrix[1][0] = m2r2c1Text.toInt()
            myMatrixTwo.matrix[1][1] = m2r2c2Text.toInt()

            val productMatrix = myMatrixOne * myMatrixTwo

            val bundle = Bundle()

            bundle.putSerializable("KEY", productMatrix)

            router.pushController(RouterTransaction.with(ProductController(bundle))
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler()))
        }
    }
}