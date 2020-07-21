package io.linus.bragi;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static java.util.concurrent.CompletableFuture.completedFuture;

public class BragiServiceImpl implements BragiService {

    private final String HEALTH_CHECK_RES = "PONG";

    @Override
    public ServiceCall<NotUsed, String> healthCheck() {
        /* Warning: completedFuture is a blocking call... */
        return notUsed -> completedFuture(this.HEALTH_CHECK_RES);
    }
}
