package io.linus.client;

import com.lightbend.lagom.javadsl.client.integration.LagomClientFactory;
import io.linus.bragi.BragiService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public class BragiClient {
    public static void main(String[] args) {
        LagomClientFactory clientFactory = LagomClientFactory.create("Bragi-Client", LagomClientFactory.class.getClassLoader());

        try {
            BragiService bragiService = clientFactory.createClient(BragiService.class, new URI("http://localhost:9000"));
            String result = bragiService.healthCheck().invoke().toCompletableFuture().get();

            System.out.println(result);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            clientFactory.close();
        }
    }
}
