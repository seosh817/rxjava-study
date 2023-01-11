package rx

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.functions.Function
import org.reactivestreams.Publisher
import java.util.concurrent.TimeUnit

class RetryWithDelaySingleKt(private val maxRetries: Int, private val retryDelayMillis: Int) : Function<Flowable<Throwable>, Publisher<*>> {
    private var retryCount = 0

    constructor(retryDelayMillis: Int) : this(-1, retryDelayMillis) {
        retryCount = 0
    }

    override fun apply(flowable: Flowable<Throwable>): Flowable<*> = flowable
        .flatMap { throwable ->
            if (maxRetries < 0 || ++retryCount < maxRetries) {
                // When this Observable calls onNext, the original
                // Observable will be retried (i.e. re-subscribed).
                Flowable.timer(retryDelayMillis.toLong(), TimeUnit.MILLISECONDS)
            } else Flowable.error(throwable)
        }
}

