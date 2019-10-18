package com.example.sprintchallengeadvancedkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
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

        val myArray = Array(2) {Array(2) { 0 } }
        val bundle = Bundle()

        bundle.putInt("KEY", 3)

        buttonMultiply?.setOnClickListener {
            router.pushController(RouterTransaction.with(ProductController(bundle))
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler()))
        }
    }
}