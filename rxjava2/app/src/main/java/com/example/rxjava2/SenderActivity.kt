package com.example.rxjava2

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sender.*

class SenderActivity : AppCompatActivity(R.layout.activity_sender) {

    fun send(view: View) {
        val text = et_input.text.toString()
        RxBus.onNext(SampleBusEvent(text))
    }

}