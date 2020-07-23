package com.example.rxjava2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_debounce.setOnClickListener {
            startActivity(Intent(this, DebounceActivity::class.java))
        }

        btn_behaviorSubject.setOnClickListener {
            startActivity(Intent(this, BehaviorSubjectActivity::class.java))
        }

        btn_buffer.setOnClickListener {
            startActivity(Intent(this, BufferActivity::class.java))
        }

        btn_combineLatest.setOnClickListener {
            startActivity(Intent(this, CombineLatestActivity::class.java))
        }

        btn_throttle.setOnClickListener {
            startActivity(Intent(this, ThrottleActivity::class.java))
        }
    }

    fun debounce(view: View) {
        startActivity(Intent(this, DebounceActivity::class.java))
    }

}
