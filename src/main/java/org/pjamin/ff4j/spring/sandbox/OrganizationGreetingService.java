package org.pjamin.ff4j.spring.sandbox;

import org.ff4j.aop.Flip;
import org.ff4j.core.FlippingExecutionContext;

@Flip(name = "organizationgreeting", alterBean = "greeting.organization.yes")
public interface OrganizationGreetingService {
    String sayHello(FlippingExecutionContext flippingExecutionContext);
}