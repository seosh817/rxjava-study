typealias Observer2<T> = (event:T) -> Unit
class EventSource2<T> {

    private var observers = mutableListOf<Observer<T>>()


    fun addObserver(observer: Observer2<T>) {
        observers.add(observer)
    }

    fun notify(event: T) {
        for(observer in observers) {
            observer.invoke(event)
        }
    }

}