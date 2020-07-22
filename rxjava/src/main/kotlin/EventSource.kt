typealias Observer<T> = (event: T) -> Unit
class EventSource<T> {
    private val observers = mutableListOf<Observer<T>>()
    fun addObserver(observer: Observer<T>) {
        observers += observer
    }
    fun notify(event: T) {
        observers.forEach { it(event) }
    }
}

