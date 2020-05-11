package org.pjamin.ff4j.spring.sandbox;

import org.ff4j.core.FlippingExecutionContext;
import org.springframework.stereotype.Component;

@Component("greeting.organization.yes")
public class OrganizationGreetingServiceYesImpl implements OrganizationGreetingService {

    public String sayHello(FlippingExecutionContext flippingExecutionContext) {
        return "Hello " + flippingExecutionContext.getValue("organization", true);
    }
}
