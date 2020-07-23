package com.example.rxjava2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_debounce.*
import java.util.concurrent.TimeUnit

class DebounceActivity : AppCompatActivity(R.layout.activity_main) {

    private val compositeDisposable = CompositeDisposable()
    private val inputPublishSubject = PublishSubject.create<String>()

    //publish 는 subscribe 이후에 전달되는 것만 받고 behavior은 구독이전 데이터도 가져오고 이후 데이터도 가져옴 subscribe하기전에 마지막으로 배출했던 데이터를 받아옴
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debounce)
        et_input.doOnTextChanged{ text, _, _, _ ->
            inputPublishSubject.onNext(text.toString())
        }

        inputPublishSubject.debounce(1000L, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                tv_output.text = it
            }.addTo(compositeDisposable)
    }

}