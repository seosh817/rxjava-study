import io.reactivex.*
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.internal.util.HalfSerializer.onNext
import io.reactivex.rxkotlin.Flowables
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import java.io.IOException
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit
import javax.swing.text.DateFormatter
import kotlin.random.Random

fun main() {


/*
*//*    val eventSource = EventSource2<String>()
    eventSource.addObserver { println("첫 번째 옵저버: $it") }
    eventSource.addObserver { println("두 번째 옵저버: $it") }
    eventSource.notify("Hello")
    eventSource.notify("Observer Pattern")*//*

*/

/*    Observable.create<String> { emitter ->
        // Hello 전달
        emitter.onNext("Hello")
        // World 전달
        emitter.onNext("World")
        // 완료
        emitter.onComplete()
    }.subscribe { println(it) }*/


/*    Observable
        .fromIterable(0..5)
        .map { "hello: $it"}
        .subscribe {
            println(it)
        }*/
/*    Observable.fromIterable(0..3)
        .scan { t1: Int, t2: Int -> t1 + t2 }
        .subscribe { println(it) }*/


    /*
    val compositeDisposable = CompositeDisposable()
    val disposable1 = Observable.just(1, 2)
        .subscribe { println(it) }
    compositeDisposable.add(disposable1)
    compositeDisposable.clear() // dispose()
    val disposable2 = Observable.just(3, 4)
        .delay(1, TimeUnit.SECONDS)
        .subscribe { println(it) }
    compositeDisposable.add(disposable2)
    Thread.sleep(2000L)

*//*    val compositeDisposable = CompositeDisposable()
    val disposable1 = Observable.just(1, 2)
        .subscribe { println(it) }
    compositeDisposable.add(disposable1)
    compositeDisposable.dispose() // dispose()
    val disposable2 = Observable.just(3, 4)
        .delay(1, TimeUnit.SECONDS)
        .subscribe { println(it) }
    compositeDisposable.add(disposable2)
    Thread.sleep(2000L)*//*
    */


    //2주차

    //val source = object: Observable


    //source에 observer를 subscribe 해가지고
    //observer에 데이터를 전달하는 식으로 되어있음

    //Observable이 ObservableSource를 implements하고 있음

    //Disposable의 subscribe()의 파라미터에

/*    val observer = object: Observer<Int> {
        override fun onNext(t: Int) {
            //실제 데이터 받아서 처리하는 부분
            println(t)
        }

        override fun onSubscribe(d: Disposable) {
            //disposable이 여기로 날라옴

        }
        override fun onError(e: Throwable) {

        }

        override fun onComplete() {

        }
    }

    Observable.just(1, 2, 3)
        .subscribe(observer)
    //consumer는 subscribe()하는 시점에서 disposable이 return 됨

    Single.just(1)
        .subscribe({
            println(it)
        },{

        })
    Maybe.just(1)
        .subscribe {
            println(it)
        }
    Maybe.empty<Int>()
    Completable.complete()*/


    //onSubscribe


 /*   val publishSubject = PublishSubject.create<Int>()
    publishSubject.subscribe { println("1번째 Observer -> $it") }
    publishSubject.onNext(1)
    publishSubject.subscribe { println("2번째 Obsevrer -> $it") }
    publishSubject.onNext(2)
    publishSubject.onNext(3)
    publishSubject.subscribe { println("3번째 Observer -> $it") }
    publishSubject.onNext(4)*/

/*    val behaviorSubject = BehaviorSubject.create<Int>()
    behaviorSubject.subscribe { println("1번째 Observer -> $it") }
    behaviorSubject.onNext(1)
    behaviorSubject.subscribe { println("2번째 Observer -> $it") }
    behaviorSubject.onNext(2)
    behaviorSubject.onNext(3)
    behaviorSubject.subscribe { println("3번째 Observer -> $it") }
    behaviorSubject.onNext(4)*/

/*    val replaySubject = ReplaySubject.create<Int>()
    replaySubject.subscribe { println("1번째 Observer -> $it") }
    replaySubject.onNext(1)
    replaySubject.subscribe { println("2번째 Observer -> $it") }
    replaySubject.onNext(2)
    replaySubject.onNext(3)
    replaySubject.subscribe { println("3번째 Observer -> $it") }
    replaySubject.onNext(4)*/
/*

    val asyncSubject = AsyncSubject.create<Int>()
    asyncSubject.subscribe { println("1번째 Observer -> $it") }
    asyncSubject.onNext(1)
    asyncSubject.subscribe { println("2번째 Observer -> $it") }
    asyncSubject.onNext(2)
    asyncSubject.onNext(3)
    asyncSubject.subscribe { println("3번째 Observer -> $it") }
    asyncSubject.onNext(4)
    asyncSubject.onComplete()
*/



/*    //3주차

    Observable.create<String> { emitter ->
        //Hello 전달
        emitter.onNext("Hello")
        //World 전달
        emitter.onNext("World")
        //완료
        emitter.onComplete()
    }

    //create와 defer의 차이점

    val observable1 = Observable.create<Int> {
        println("create")
        it.onNext(1)
        it.onNext(2)
    }

    observable1.subscribe { println(it) }
    observable1.subscribe { println(it) }*/

/*    val observable = Observable.create<LocalTime> {emitter ->
        emitter.onNext(LocalTime.now())
    }*/


/*    val observable = Observable.defer {
        Observable.just(LocalTime.now())
    }*/

/*    val observable = Observable.just(LocalTime.now())*/

/*    observable.subscribe { println(it) }

    Thread.sleep(2000L)
    observable.subscribe{println(it)}*/

    /*observable2.delay(3000L, TimeUnit.MILLISECONDS).subscribe {println(it)}*/

    //오전에 관한 Observable, 오후에 관한 Observable 따로 처리
    //subscribe하는 시점에 생성하는 것이니까
    //다른 케이스의 Observable을 써야 할 때 defer를 사용

/*    //array를 받아서 쓸 때
    val items = arrayOf("Hello", "World")
    Observable.fromArray(*items)
        .subscribe { println(it) }*/

/*    //fromCallable
    println("start: ${System.currentTimeMillis()}")
    fun createItem(): String {
        println("create: ${System.currentTimeMillis()}")
        return "HelloWorld"
    }

    val observable = Observable.fromCallable { createItem() }

    Thread.sleep(1000)
    observable.subscribe { println(it) }

    Thread.sleep(1000)
    observable.subscribe { println(it) }*/

/*    Observable.interval(1000, TimeUnit.MILLISECONDS)
        .subscribe { println(it) }
    Thread.sleep(3000)
    //1초마다 전달하고 3초일때 중지
    //initail delay를 주면 delay만큼 더 쉬고 전달 (그냥 하면 처음부터 1초쉬고 데이터전달 1초쉬고 데이터 전달)
    //첫 데이터를 안쉬고 데이터를 배출하려면 .startWith(0)을 추가해주면 됨*/

/*    Observable.range(3, 2)
        .subscribe { println(it) }
    //뭐지?*/

/*    //TIMER
    Observable.timer(2000L, TimeUnit.MILLISECONDS)
        .subscribe { println("2초 후")}
    Thread.sleep(3000L) // 이거 안주면 기다리지 않고 끝나버림 (얼마나 기다리게 할건지 주는것)*/


    //TransformationOperator

/*    Observable.fromIterable(0..10)
        .buffer(2, 1)
        .subscribe { println(it)}
    //2를 없애고 3, 4 배출 5를 없개 6, 7 ...*/

    //flatMap



/*    Observable.fromIterable(0..2)
        .concatMap {
            Observable.interval(100L, TimeUnit.MILLISECONDS)
            .take(3)
                .map(Long::toInt)
                .map {
                    "${Thread.currentThread().getName()} value : $it, newData: ${list[it]}"
                }

        }.subscribe(::println)*/

/*        val list = listOf("First", "Second", "Third")

    Observable.fromIterable(0..2)
        .flatMap({
            Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(3)
                .map(Long::toInt)
                .map {
                    list[it]
                }
        },{value, newData->
            "${Thread.currentThread().getName()} value :$value, newData: $newData"
            }).subscribe(::println)

    Thread.sleep(1200)*/

/*    Observable.just(1, 2)
        .concatMap {
            Observable.just("${it} Hello", "${it} Hello")
        }.subscribe {
            println(it)
        }*/

    //retryWhen

/*    Observable.just(1,2)
        .retryWhen{ errors ->
            errors.zipWith(Observable.range(1,2), BiFunction { t1: Throwable, t2: Int -> Pair(t1, t2) })
                .flatMap { count: Pair<Throwable, Int> ->
                    if (count.second < 3) {
                        Observable.timer(5, TimeUnit.SECONDS)
                    } else {
                        Observable.error(count.first)
                    }
                }
        }

    Single.just(1)
        .retryWhen { attempts ->
        Flowables.zip(
            attempts.map { error -> if (error is IOException) error else throw error },
            Flowable.interval(1, TimeUnit.SECONDS)
        ).map { (error, retryCount) -> if (retryCount >= 3) throw error }
    }*/


/*    //scan
    Observable.just(0, 1, 2, 3)
        .scan { t1: Int, t2: Int -> t1 + t2}
        .subscribe { println(it)}*/

    //복습 하는법 -> ppt만 보고 연습


/*    Observable.create<Int> {emitter ->

        emitter.onNext(1)
        emitter.onNext(2)

    }.subscribe{
        println(it)
    }*/

/*    //defer
    Observable.defer {
        Observable.create<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
        }
    }.subscribe{
        println(it)
    }*/

/*    //fromArray
    val list = arrayOf("abc", "def")

    Observable.fromArray(*list)
        .subscribe{
            println(it)
        }*/

/*    val list2 = listOf(4, 5, 6)

    Observable.fromIterable(
        list2
    ).subscribe {
        println(it)
    }*/

/*    fun b(): List<Int> {

        return listOf(1, 2, 3)
    }

    Observable.fromCallable {
        b()
    }.subscribe {
        println(it)
    }*/

/*    val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss.SSS")

    Observable.interval(0, 1000L, TimeUnit.MILLISECONDS)
        .subscribe {data ->
            println(LocalTime.now().format(dateTimeFormatter) + "data = $data") }
    Thread.sleep(3000L)*/

/*    println("start:\t\t ${System.currentTimeMillis()}")
    Observable.timer(1000, TimeUnit.MILLISECONDS)
        .subscribe {data ->
            println("subscribe:\t ${System.currentTimeMillis()} + data = $data") }
    Thread.sleep(2000)*/


/*        Observable.range(2, 5)
            .subscribe { println(it) }*/


/*    val observable = Observable.just("Hello", "World")
        .doOnSubscribe { println("subscribe") }
        .repeat(2)

    observable.subscribe { println(it) }*/


    //4주차

/*    //debounceON
    Observable.interval(250L, TimeUnit.MILLISECONDS)
        .debounce(300L, TimeUnit.MILLISECONDS)
        .subscribe(::println)

    Thread.sleep(1500)*/

/*    //distinct
    Observable.just(1, 1, 2, 1, 2, 3)
        .distinct()
        .subscribe(::println)*/

/*    //distinctUntilChanged
    Observable.just(1, 2, 2, 3, 1, 1, 1, 2)
        .distinctUntilChanged()
        .subscribe { println(it) }*/

/*    Observable.just(1, 1, 2, 1, 2, 3)
        .filter { it % 2 == 1 }
        .subscribe { println(it) }*/


/*    Observable.just(1, "Hello", true, 2f)
        .ofType(String::class.java)
        .subscribe(::println)*/

/*        Observable.just(1, 1, 2, 1, 2, 3)
            .ignoreElements()
            .subscribe { println("complete") }*/




/*    //throttleFirst
    println(System.currentTimeMillis())
    Observable.interval(0, 100, TimeUnit.MILLISECONDS)
        .throttleFirst(250, TimeUnit.MILLISECONDS)
        .subscribe {
            println(System.currentTimeMillis())
            println(it)
        }
    Thread.sleep(1000)*/

/*    //throttleLast
    println(System.currentTimeMillis())
    Observable.interval(0, 100, TimeUnit.MILLISECONDS) //initialDelay 시작부터 시작
        .throttleLast(250, TimeUnit.MILLISECONDS)
        .subscribe {
            println(System.currentTimeMillis())
            println(it)
        }
    Thread.sleep(1000)*/


/*    //skip, skiplast
    Observable.just(1, 1, 2, 1, 2, 3)
        .skipLast(2)
        .subscribe { println(it) }*/

/*
    //take
    Observable.just(1, 1, 2, 1, 2, 3)
        .take(2)
        .subscribe { println(it)}
*/

/*    //combineLatest

    val observable3 = Observable.interval(1000L, TimeUnit.MILLISECONDS)
    val observable4 = Observable.interval(750L, TimeUnit.MILLISECONDS)

    val combineObservable = Observable.combineLatest<Long, Long, String> (
        observable3,
        observable4,
        BiFunction<Long, Long, String> { t1, t2 ->
            "$t1 $t2"
        }
    )
    combineObservable.subscribe {
        println(System.currentTimeMillis())
        println(it)
    }
    Thread.sleep(3000)*/

/*    val observable5 = Observable.interval(0, 1000L, TimeUnit.MILLISECONDS).map {"Observable 1 -> $it"}
    val observable6 = Observable.interval(0, 500L, TimeUnit.MILLISECONDS).map {"Observable 2 -> $it"}

    val mergeObservable = Observable.merge(observable5, observable6)

    mergeObservable.subscribe() {
        println(System.currentTimeMillis())
        println(it)
    }
    Thread.sleep(3000)*/

/*    Observable.just(1,2,3,4,5)
        .startWith(100)
        .subscribe { println(it)}*/

/*
    val observable7 = Observable.just(1, 2, 3, 4, 5,6,7)
    val observable8 = Observable.just("a", "b", "c", "d", "e")

    val zipObservable = Observable.zip(
        observable7,
        observable8,
        BiFunction<Int, String, String> { t1, t2 ->
            "$t1 $t2"
        }
    )
    zipObservable.subscribe { println(it)}
*/


/*
        Observable.just("Hello", "World")
            .doOnNext { println("doOnNext") }
            .doOnSubscribe { println("doOnSubscribe") }
            .doAfterNext { println("doAfterNext") }
            .doAfterTerminate { println("doAfterTerminate") }
            .doFinally { println("doFinally") }
            .doOnComplete { println("doOnComplete") }
            .doOnDispose { println("doOnDispose") }
            .doOnEach { println("doOnEach") }
            .doOnError { println("doOnError") }
            .doOnTerminate { println("doOnTerminate") }
            .subscribe { println("- $it") }
*/

/*    Observable.just("Hello", "World")
        .delay(3000L, TimeUnit.MILLISECONDS)
        .timeout(2000L, TimeUnit.MILLISECONDS, Observable.just("HelloWorld")) // 이 시간안에 들어오지 않으면 죽음
        .subscribe({
            println(it)
        }, {
            it.printStackTrace()
        })

    Thread.sleep(4000)*/

    val list = arrayListOf<String>()

    println(LocalTime.now())
    for(i in 0..470000) {
        list.add("aa")
    }
    println(LocalTime.now())


}

class CustomObserver<T>(
    private val compositeDisposable: CompositeDisposable,
    private val onNextAction: (T) -> Unit
) : Observer<T> {
    override fun onComplete() {
        // no-op
    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onNext(t: T) {
        onNextAction(t)
    }


    override fun onError(e: Throwable) {
        /*ErrorUtils.error(e)*/
    }


}

fun <T> Observable<T>.retryWhenError(retryCount: Int, delayInSeconds: Long): Observable<T> {
    return retryWhen { errors ->
        errors.zipWith(
            Observable.range(1, retryCount), BiFunction { throwable: Throwable, count: Int -> Pair(throwable, count) })
            .flatMap { count: Pair<Throwable, Int> ->
                if (count.second < retryCount) {
                    Observable.timer(delayInSeconds, TimeUnit.SECONDS)
                } else {
                    Observable.error(count.first)
                }
            }
    }
}