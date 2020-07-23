package com.example.rxjava2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.combineLatest
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.layout_combine_latest.*

class CombineLatestActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    private val nameBehaviorSubject = BehaviorSubject.createDefault("")
    private val ageBehaviorSubject = BehaviorSubject.createDefault("")
    private val addressBehaviorSubject = BehaviorSubject.createDefault("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        et_name.doOnTextChanged { text, _, _, _ ->
            nameBehaviorSubject.onNext(text.toString())
        }
        et_age.doOnTextChanged { text, _, _, _ ->
            ageBehaviorSubject.onNext(text.toString())
        }
        et_address.doOnTextChanged { text, _, _, _ ->
            addressBehaviorSubject.onNext(text.toString())
        }

        listOf(nameBehaviorSubject, ageBehaviorSubject, addressBehaviorSubject).combineLatest {
            it.fold(true, {t1, t2 -> t1 && t2.isNotEmpty()})
        }.subscribe {
            btn_send.isEnabled = it
        }.addTo(compositeDisposable)
    }

    //배열이 1, 2, 3, 4라면
    //fold 가 더하기 연산이라면 1+2 +3 +4
    //앞에서부터 순회하면서 값을 조회하는 것
    //fold(디폴트값, {t1, t2})
    //kotlin list collection에 있는 함수
}