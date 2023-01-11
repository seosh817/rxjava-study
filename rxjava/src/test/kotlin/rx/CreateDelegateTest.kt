package rx

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import org.junit.Test


class CreateDelegateTest {

    @Test
    fun dbRawDataTest() {
        Observable.fromIterable(listOf("ab", "cd"))
            .doOnNext {
                println("doOnNext: $it")
            }
            .flatMapMaybe {
                println("string: $it")
                if(it == "ab") Maybe.error(NoSuchElementException())
                else {
                    Maybe.just("cd")
                }
                    .onErrorResumeNext { if(it is NoSuchElementException) Maybe.empty() else Maybe.error(it) }
            }
            .test()
            .await()

        val observable = Observable.just(1, 2, 3)
            .flatMap {
                Observable.create<Int> {  } // 얘는 subscribe를 해야 생성이 됨. flatMap은 subscribe시점에 생성되니까
            }

        // create와 defer의 차이점은 create는 그 안에서 로직을 만들 수 있도록 emitter로 Observable를 생성할 수 있도록
        // defer는 다른 Observable을 Return함.
        // fromCallable은 그냥 리턴하는 Function을 Observable로 만들고
        observable.subscribe({

        }, {

        })

        var a = 123
        val observable2 = Completable
            .complete()
            .andThen(Observable.just(a)) // subscribe 안해도 생성이되지만
        // create를 쓰면 delegate가 들어가있음.

        a = 321

        observable2.subscribe({

        }, {

        })

        var b = 123
        val observable3 = Completable
            .complete()
            .andThen(Observable.defer { Observable.just(b) }) // subscribe 안해도 생성이되지만

        b = 321

        observable3.subscribe({

        }, {

        })
    }
}