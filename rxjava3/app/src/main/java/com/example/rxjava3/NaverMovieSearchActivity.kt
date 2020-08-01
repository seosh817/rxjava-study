package com.example.rxjava3

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.merge
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_naver_movie_search.*
import java.util.concurrent.TimeUnit

class NaverMovieSearchActivity : AppCompatActivity(R.layout.activity_naver_movie_search) {

    private val compositeDisposable = CompositeDisposable()
    private val naverMovieSearchAdapter = NaverMovieSearchAdapter()

    private val backKeySubject = BehaviorSubject.createDefault<Long>(0L)

    private val vm by lazy { NaverMovieSearchViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        rv_content.adapter = naverMovieSearchAdapter
    }

    override fun onResume() {
        super.onResume()
        bindViewModel()
    }

    private fun bindViewModel() {
        val textChange = RxTextView.textChanges(et_input)
            .map { it.toString() }
            .debounce(
                1500L,
                TimeUnit.MILLISECONDS,
                Schedulers.computation()
            )// computation 시간관련작업할때 , io()는 input output처리
        val searchClick = RxView.clicks(btn_search)
            .map { et_input.text.toString() }

        compositeDisposable.add(
                listOf(textChange, searchClick)
                        .merge()
                        .throttleFirst(1000L, TimeUnit.MILLISECONDS)
                        .filter(String::isNotBlank)
                        .subscribe(vm::searchMovie)
        )


        backKeySubject
            .buffer(2, 1)
            .map { it[0] to it[1] }
            .subscribe {
                if(it.second - it.first < 2000L) {
                    super.onBackPressed()
                } else {
                    Toast.makeText(this, "앱을 종료하려면 한번 더 눌러주세요", Toast.LENGTH_SHORT).show()
                }
            }
            .addTo(compositeDisposable)





        vm.errorSubject // bind 작업
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::showError)
            .addTo(compositeDisposable)

        vm.loadingSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { pb_loading.isVisible = it}
            .addTo(compositeDisposable)
        vm.movieItemsSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(naverMovieSearchAdapter::submitList)
            .addTo(compositeDisposable)


    }

    override fun onPause() {
        unbindViewModel()
        super.onPause()
    }

    private fun unbindViewModel() {
        compositeDisposable.clear()
        vm.unbindViewModel()
    }

    override fun onBackPressed() {
        backKeySubject.onNext(System.currentTimeMillis())
    }

    private fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }
}