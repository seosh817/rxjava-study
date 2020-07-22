import java.util.ArrayList;

public class EventSource3<T> {

    private ArrayList<Observer<T>> observers = new ArrayList();

    //구독자 추가
    void addObserver(Observer<T> observer) {
        observers.add(observer);
    }
    //알림 보내기
    void notify(T item) {
        for (Observer<T> observer: observers) {
            observer.notify(item);
        }
    }
}


interface Observer<T> {
    void notify(T item);
}