package io.linus.bragi;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.*;

public interface BragiService extends Service {

    ServiceCall<NotUsed, String> healthCheck();

    @Override
    default Descriptor descriptor() {
        return named("Bragi")
    /*
     * call: call is the basic type of call which generates the HTTP endpoint based on the name of the method
     * namedCall: namedCall allows the generated HTTP endpoint to be named by provided customised name
     * pathCall: pathCall allows using ":" prefix in path that will be mapped to parameters in the method signature
     * restCall: restCall provides full control of call, e.g restCall(Method.GET, "api/ping/:id", this::healthCheck)
    */
                .withCalls(
                        namedCall("api/ping", this::healthCheck)
                )
                .withAutoAcl(true);
    }
}
