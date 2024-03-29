import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

fun main() {


/*
*//*    val eventSource = EventSource2<String>()
    eventSource.addObserver { println("첫 번째 옵저버: $it") }
    eventSource.addObserver { println("두 번째 옵저버: $it") }
    eventSource.notify("Hello")
    eventSource.notify("Observer Pattern")*//*

*/
/*

    Observable.create<String> { emitter ->
        // Hello 전달
        emitter.onNext("Hello")
        // World 전달
        emitter.onNext("World")
        // 완료
        emitter.onComplete()
    }.subscribe { println(it) }

    Thread.sleep(2000L)
*/

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


    //Chap2

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


/*    //Chap3

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


    /*var name = "seunghwan"

    val justObservable = Observable.just(name)

    val deferObservable = Observable.defer { Observable.just(name) }

    name = "seosh817"

    justObservable.subscribe {
        println("justObservable name: $it")
    }

    deferObservable.subscribe {
        println("deferObservable name: $it")
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

/*
    var name = "seunghwan"

    val justObservable = Observable.just(name)

    val fromCallableObservable = Observable.fromCallable { name }

    name = "seosh817"

    justObservable.subscribe {
        println("justObservable name: $it")
    }

    fromCallableObservable.subscribe {
        println("fromCallableObservable name: $it")
    }

    Thread.sleep(1000)*/

/*    Observable.interval(1000, TimeUnit.MILLISECONDS)
        .subscribe { println(it) }
    Thread.sleep(3000)
    //1초마다 전달하고 3초일때 중지
    //initail delay를 주면 delay만큼 더 쉬고 전달 (그냥 하면 처음부터 1초쉬고 데이터전달 1초쉬고 데이터 전달)
    //첫 데이터를 안쉬고 데이터를 배출하려면 .startWith(0)을 추가해주면 됨
    //당연한거지만 이거 안주면 기다리지 않고 끝나버림 (안하면 Main()이 죽으니까 프로그램이 죽음)
    */

/*    Observable.range(3, 2)
        .subscribe { println(it) }
    //뭐지?*/

/*    //TIMER
    Observable.timer(2000L, TimeUnit.MILLISECONDS)
        .subscribe { println("2초 후")}
    Thread.sleep(3000L)*/


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


    //Chap4

/*
    // debounce 예시
    Observable.intervalRange(0L, 6, 0, 250L,  TimeUnit.MILLISECONDS)
        .debounce(300L, TimeUnit.MILLISECONDS)
        .subscribe(::println)

    Thread.sleep(1500)
*/

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
/*
    // throttleFirst
    Observable.interval(0, 100, TimeUnit.MILLISECONDS)
        .throttleFirst(500, TimeUnit.MILLISECONDS)
        .subscribe {
            println(it)
        }
    Thread.sleep(1000)*/

/*    // throttleLast 예시
    Observable.interval(0, 100, TimeUnit.MILLISECONDS)
        .throttleLast(500, TimeUnit.MILLISECONDS)
        .subscribe {
            println(it)
        }
    Thread.sleep(1000)*/

/*
    //skip, skiplast
    Observable.just(1, 1, 2, 1, 2, 3)
        .skip(2)
        .subscribe { println(it) }

    Thread.sleep(100L)*/

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

//    val list = arrayListOf<String>()
//
//    println(LocalTime.now())
//    for (i in 0..470000) {
//        list.add("aa")
//    }
//    println(LocalTime.now())
//
//
//    // subject와 observable의 가장 큰 차이점
//    // subject는 Observer의 기능 (onNext(), onComplete()...의 기능)과 Observable의 기능(zip, combineLatest 등등..)
//    // 모두 할 수 있지만 observable은 이름 그 자체로 Observable의 기능만 할 수 있다.
//    val subject = BehaviorSubject.create<Int>()
//    val observable = Observable.just(1)
//
//    var disposable: Disposable? = null
//    disposable = Observable.just(1, 2, 3)
//        .doOnSubscribe {
//            println("doOnSubscribe")
//        }
//        .doOnDispose { // dispose()
//            println("doOnDispose")
//        }
//        .doOnTerminate { // onComplete(), onError()
//            println("doOnTerminate")
//        }
//        .doAfterTerminate {
//            println("doAfterTerminate")
//        }
//        .doFinally { // onComplete(), onError(), dispose()
//            println("doFinally")
//            disposable = null // Because disposable means connectionstate. so if called onComplete(), dispose(), onError(), need to be disconnected
//        }
//        .subscribe({
//
//        }, {
//
//        }, {
//
//        })

/*
    Observable.intervalRange(0L, 30L, 0, 1L,TimeUnit.SECONDS)
        .subscribe {
            println("${Thread.currentThread().name} $it")
        }
    Thread.sleep(30000L)
*/

/*    Single.error<Throwable>(IllegalArgumentException())
        .doOnError {
            println("error")
        }
//        .retryWhen(RetryWithDelaySingle(5, 500))
        .retryWhen {
            it
                .delay(500, TimeUnit.MILLISECONDS)
                .take(5)
        }
        .subscribe({
            println("onSuccess()")
        }, {
            println("onError()")
        })
    Thread.sleep(5000L)*/

//    Flowable.just(1, 2, 3 ,4)
//        .subscribe()


//    Observable.range(1, 9)
//        .flatMapSingle {
//            Single.just("Single Success + $it")
//        }
//        .subscribe({
//            println(it)
//        }, {
//
//        })
/*
    Single.just(1)
        .flatMap {
            Single.fromCallable {
                "$it flatMapSingle1 + "
            }
        }
        .flatMap {
            Single.fromCallable {
                "$it flatMapSingle2"
            }
        }
        .ignoreElement()
        .andThen(Single.just("Next Stream"))
        .subscribe({
            println(it)
        }, {

        })*/


//    Thread.sleep(5000L)
//    Observable.just(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
//        .flatMap { Observable.fromIterable(it) }
//        .flatMapSingle {
//            Single.just("$it: flatMapSingle1 +")
//        }
//        .flatMapSingle {
//            Single.fromCallable {
//                "$it flatMapSingle2 +"
//            }
//        }
//        .flatMapSingle {
//            Single.fromCallable {
//                "$it flatMapSingle3"
//            }
//        }
//        .doOnNext {
//            println(it)
//        }
//        .flatMapCompletable {
//            Completable.create { emitter ->
//                if(it.length >= 2) {
//                    emitter.onComplete()
//                }
//                emitter.onError(IllegalArgumentException(""))
//            }
//            Completable.complete()
//        }
////        .ignoreElements()
//        .doOnComplete {
//            println("onCompleted")
//        }
//        .andThen(Single.just("New Stream"))
//        .subscribe({
//            println(it)
//        }, {
//
//        })


//    val observable1 = Observable.timer(3000L, TimeUnit.MILLISECONDS)
//        .doOnSubscribe {
//            println("observable1 subscribe: ${TimeUtil.fromMills(System.currentTimeMillis())}")
//        }
//        .doOnComplete {
//            println("observable1 completed: ${TimeUtil.fromMills(System.currentTimeMillis())}")
//        }
//    val observable2 = Observable.timer(2000L, TimeUnit.MILLISECONDS)
//        .doOnSubscribe {
//            println("observable2 subscribe: ${TimeUtil.fromMills(System.currentTimeMillis())}")
//        }
//        .doOnComplete {
//            println("observable2 completed: ${TimeUtil.fromMills(System.currentTimeMillis())}")
//        }
//
//    val observable3 = Observable.timer(1000L, TimeUnit.MILLISECONDS)
//        .doOnSubscribe {
//            println("observable3 subscribe: ${TimeUtil.fromMills(System.currentTimeMillis())}")
//        }
//        .doOnComplete {
//            println("observable3 completed: ${TimeUtil.fromMills(System.currentTimeMillis())}")
//        }
//
//    Observable.concat(observable1, observable2, observable3)
//        .subscribe({
//        }, {
//
//        })
//    Thread.sleep(7000L)


//    Single.just(listOf(1, 2, 3, 4, 5, 6))
//        .flatMapCompletable { list ->
//            Single.concat(
//                list.map {
//                    uploadS3Completable(it)
//                })
//                .flatMapCompletable {
//                    Completable.fromCallable {
//                        println("flatMapCompletable $it")
//                    }
//                }
//        }
//        .subscribe({
//            println("success")
//        }, {
//
//        })
//    Thread.sleep(7000L)
/*
    // 잘못된 예시. Observable이 interval 마다 생성이 되므로 나중에는 엄청 많이 생성이 됨.
    // 결과
    // protocol 1
    // protocol 2
    // protocol 2
    // protocol 3
    // protocol 3
    // protocol 3
    // protocol 4
    // protocol 4
    // protocol 4
    // protocol 4
    // protocol 5
    // protocol 5
    // protocol 5
    // protocol 5
    // protocol 5
    // protocol 6
    // protocol 6
    // protocol 6
    // protocol 6
    // protocol 6
    // protocol 6
    val protocolRelay = PublishRelay.create<String>()

    Observable.interval(1000L,  TimeUnit.MILLISECONDS)
        .doOnNext {
            protocolRelay.accept("protocol $it")
        }
        .flatMap {
            protocolRelay
        }
        .subscribe({
            println("$it")
        }, {

        })

    Thread.sleep(7000L)
*/


    // Observable은 단 1개만 생성이 되고, subject에 데이터를 흘려보내줘서 정상적으로 동작함.
    // protocol 0
    // protocol 1
    // protocol 2
    // protocol 3
    // protocol 4
    // protocol 5
    // subjectWithIntervalObservable()
    //     .subscribe({
    //         println("$it")
    //     }, {
    //         println("protocol error $it")
    //     })
    //
    // Thread.sleep(7000L)

//    Observable.just(1, 2, 3)
//        .doOnNext {
//            println("First observable: $it")
//        }
//        .flatMap {
//            Observable.just(it * 1, it * 2, it * 3)
//        }
//        .subscribe({
//            println("Second observable: $it")
//        }, {
//
//        })
/*
    val observable1 = Observable.interval(0, 1000L, TimeUnit.MILLISECONDS).map {"Observable 1 -> $it"}
        .take(3000L, TimeUnit.MILLISECONDS)
    val observable2 = Observable.interval(0, 1000L, TimeUnit.MILLISECONDS).map {"Observable 2 -> $it"}

    Observable.concat(observable1, observable2)
        .doOnNext {
            println("observable: $it")
        }
        .subscribe({

        }, {

        })

    Thread.sleep(7000L)*/

//    Observable.just(1)
//        .concatWith(Observable.just(111, 222, 333))
//        .doOnNext {
//            println("Second observable: $it")
//        }
//        .subscribe({
//        }, {
//
//        })


//    Observable.just(1, 2, 3, 4)
//        .doOnSubscribe {
//            throw IllegalStateException("abcd")
//        }
//        .subscribe({
//
//        }, {
//            println("error: $it")
//        })
//
//
//    Thread.sleep(1000)

    Observable.range(1, 12)
        .groupBy { it % 3 }
        .flatMapSingle { group ->
            group
                .toList()
                .map {
                    group.key to it
                }
        }
        .subscribe({ (key, list) ->
            println("observable: key: $key, list: $list")
        }, {

        })

    Thread.sleep(1000)
}

// Subject 혹은 Observable이 주기적으로(예륻들면, Observable.interval 등) 데이터를 방출시키게 하는 방법.
fun subjectWithIntervalObservable(): Observable<String> {
    var intervalDisposable: Disposable? = null
    val dataSubject = PublishSubject.create<String>()
    return dataSubject
        .doOnSubscribe {
            intervalDisposable = Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .doFinally {
                    if (!dataSubject.hasThrowable()) {
                        dataSubject.onComplete()
                    }
                }
                .subscribe({
                    dataSubject.onNext("protocol $it")
                }, {
                    dataSubject.onError(it)
                })
        }
        .doFinally {
            intervalDisposable?.dispose()
        }
        .subscribeOn(Schedulers.computation())
}

// doOnSubscribe와 doFinally에서 dataSubject와 생명주기를 맞춰준다.
fun getPostureStream(): Observable<Pair<Long, Long>> {
    val dataSubject = PublishSubject.create<Pair<Long, Long>>()
    var dataDisposable: Disposable? = null
    var timerDisposable: Disposable? = null
    return dataSubject
        .doOnSubscribe {
            dataDisposable = Observable
                .combineLatest<Long, Long, Pair<Long, Long>>(
                    Observable.interval(1L, TimeUnit.SECONDS),
                    Observable.interval(2L, TimeUnit.SECONDS),
                    { t1, t2 ->
                        t1 to t2
                    })
                .doFinally {
                    if (!dataSubject.hasThrowable()) {
                        dataSubject.onComplete()
                    }
                }
                .subscribe({
                    dataSubject.onNext(it)
                }, {
                    println("onError :$it")
                    dataSubject.onError(it)
                })
            timerDisposable = Completable
                .timer(1000L, TimeUnit.SECONDS)
                .doFinally {
                    if (dataDisposable?.isDisposed == false) {
                        dataDisposable?.dispose()
                    }
                }
                .subscribe()
        }
        .doFinally {
            dataDisposable?.dispose()
            timerDisposable?.dispose()
        }
        .subscribeOn(Schedulers.computation())
}

fun uploadS3Completable(num: Int): Single<Int> {
    return Single
        .create { emitter ->
            println("num: $num")
            emitter.onSuccess(num)
        }
}

fun makeCompletable(): Completable {
    return Completable.create {
        println("completed")
        it.onComplete()
    }
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