package io.linus.bragi;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.*;

public class BragiServiceImplTest {

    @Test
    public void healthCheck_shouldReturnPong() {
        /* Unit Test:
        assertEquals(
                "PONG",
                new BragiServiceImpl().healthCheck()
                        .invoke()
                        .toCompletableFuture()
                        .get(5, TimeUnit.SECONDS));
         */

        /* Integration Test */
        withServer(defaultSetup(), server -> {
            BragiService bragiService = server.client(BragiService.class);

            try {
                String result = bragiService.healthCheck()
                        .invoke()
                        .toCompletableFuture()
                        .get(3, TimeUnit.SECONDS);

                assertEquals("PONG", result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        });
    }
}