package com.example.rxjava2

import io.reactivex.rxkotlin.ofType
import io.reactivex.subjects.BehaviorSubject

object RxBus {

    val behaviorSubject: BehaviorSubject<RxBusEvent> = BehaviorSubject.create()

    fun onNext(event: RxBusEvent) {
        behaviorSubject.onNext(event)
    }

    //reified -> 코틀린 문법, 액티비티 T.class.java 만들 수 있도록 함 T가 클래스 타입이어야 하니까 클래스타입으로 바뀔 수 있으니
    //crossinline -> 인라인 펑션하면 인라인이 함수 사용하는 부분으로 들어감 실제 함수를 call 하는 부분으로 들어감 crossinline을 붙이면 람다로 들어가서
    //crossinline 쓰는 이유는 인자를 람다로 할 때 무조건 붙여야함
    //inline 쓰는 이유는 reified 쓰면 무조건 inline이어야함
    //inline 쓰면 호출 한 곳으로 이동을 함 호출한 곳으로 저 함수를 복붙하는 것과 같음
    inline fun <reified T : RxBusEvent> subscribe(crossinline onNext: (T) -> Unit) =
        behaviorSubject
            .ofType<T>() //T타입으로 BehaviorSubject의 타입을 캐스팅 해주어야함
            .subscribe {
                onNext(it)
            }
}