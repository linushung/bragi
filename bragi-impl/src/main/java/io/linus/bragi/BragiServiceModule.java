package io.linus.bragi;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

public class BragiServiceModule extends AbstractModule implements ServiceGuiceSupport {
    /*
    * ServiceGuiceSupport provide some helper method to integrate with Guice. For example, bindService method helps to
    * connect a service's API to it;s impl(implementation)
    */
    @Override
    protected void configure() {
        bindService(BragiService.class, BragiServiceImpl.class);
    }
}
