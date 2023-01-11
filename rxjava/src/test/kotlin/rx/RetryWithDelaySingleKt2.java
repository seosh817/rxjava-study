package rx;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;

import java.util.concurrent.TimeUnit;


public class RetryWithDelaySingleKt2 implements Function<Flowable<? extends Throwable>, Publisher<?>> {
    private final int maxRetries;
    private final int retryDelayMillis;
    private int retryCount;

    public RetryWithDelaySingleKt2(final int maxRetries, final int retryDelayMillis) {
        this.maxRetries = maxRetries;
        this.retryDelayMillis = retryDelayMillis;
        this.retryCount = 0;
    }

    public RetryWithDelaySingleKt2(final int retryDelayMillis) {
        this.maxRetries = -1;
        this.retryDelayMillis = retryDelayMillis;
        this.retryCount = 0;
    }

    @Override
    public Publisher<?> apply(Flowable<? extends Throwable> flowable) throws Exception {
        return flowable
                .flatMap(new Function<Throwable, Publisher<?>>() {
                    @Override
                    public Publisher<?> apply(final Throwable throwable) {
                        if (maxRetries < 0 || ++retryCount < maxRetries) {
                            // When this Observable calls onNext, the original
                            // Observable will be retried (i.e. re-subscribed).
                            return Flowable.timer(retryDelayMillis, TimeUnit.MILLISECONDS);
                        }

                        // Max retries hit. Just pass the error along.
                        return Flowable.error(throwable);
                    }
                });
    }
}