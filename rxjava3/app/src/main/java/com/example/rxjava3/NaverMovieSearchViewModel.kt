package com.example.rxjava3

import android.widget.Toast
import com.example.rxjava3.model.NaverMovieResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class NaverMovieSearchViewModel {
    private val compositeDisposable = CompositeDisposable()

    val errorSubject = BehaviorSubject.create<Throwable>()
    val loadingSubject = BehaviorSubject.createDefault(false)
    val movieItemsSubject = BehaviorSubject.create<List<NaverMovieResponse.Item>>()



    //unbind하고 이전 꺼를 bind 시켜줘야하니까 BehaviorSubject 써야함

    fun unbindViewModel() {
        compositeDisposable.clear()
    }

    fun searchMovie(query: String) {
        compositeDisposable.add(NetworkManager.naverApi.getMovies(query)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { loadingSubject.onNext(true)}
            .doAfterTerminate { loadingSubject.onNext(false) }
            .map {it.items}
            .subscribe(movieItemsSubject::onNext, errorSubject::onNext))


    }

}