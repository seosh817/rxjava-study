import io.reactivex.Flowable
import io.reactivex.functions.Function
import org.reactivestreams.Publisher
import java.util.concurrent.TimeUnit

class RetryWithDelaySingle(private val maxRetries: Int, private val retryDelayMillis: Int) : Function<Flowable<Throwable>, Publisher<*>> {

    constructor(retryDelayMillis: Int) : this(5, retryDelayMillis)

    private var retryCount = 0

    override fun apply(flowable: Flowable<Throwable>): Flowable<*> = flowable
        .flatMap { throwable ->
            if (maxRetries < 0 || ++retryCount <= maxRetries) {
                // When this Observable calls onNext, the original
                // Observable will be retried (i.e. re-subscribed).
                Flowable.timer(retryDelayMillis.toLong(), TimeUnit.MILLISECONDS)
            } else Flowable.error(throwable)
        }
}

