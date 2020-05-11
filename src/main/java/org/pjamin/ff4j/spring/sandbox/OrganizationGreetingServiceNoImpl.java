package org.pjamin.ff4j.spring.sandbox;

import org.ff4j.core.FlippingExecutionContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("greeting.organization.no")
@Primary
public class OrganizationGreetingServiceNoImpl implements OrganizationGreetingService {

    public String sayHello(FlippingExecutionContext flippingExecutionContext) {
        return "Hello France !";
    }
}
