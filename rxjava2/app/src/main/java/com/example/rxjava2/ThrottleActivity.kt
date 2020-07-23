package com.example.rxjava2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_throttle.*
import java.util.concurrent.TimeUnit

class ThrottleActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private var num: Int = 0
    private val publishSubject = PublishSubject.create<Unit>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_throttle)
/*        publishSubject.throttleFirst(2000L, TimeUnit.MILLISECONDS)
            .subscribe {
                num++
                tv_output.text = num.toString()
            }.addTo(compositeDisposable)*/


    }

    fun bindViewModel() {
        publishSubject.throttleFirst(2000L, TimeUnit.MILLISECONDS)
            .subscribe {
                Intent(this, DebounceActivity::class.java).apply {
                    startActivity(this)
                }

            }.addTo(compositeDisposable)
    }

    fun increase(v: View) {
        publishSubject.onNext(Unit)
    }

    override fun onStart() {
        super.onStart()
        bindViewModel()
    }

    override fun onPause() {
        compositeDisposable.clear()
        super.onPause()
    }
}