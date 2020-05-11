package org.pjamin.ff4j.spring.sandbox;

import org.ff4j.aop.Flip;
import org.ff4j.core.FlippingExecutionContext;

@Flip(name = "officehoursgreeting", alterBean = "greeting.day")
public interface OfficeHoursGreetingService {
    String sayHello(FlippingExecutionContext flippingExecutionContext, String name);
}


