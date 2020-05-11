package org.pjamin.ff4j.spring.sandbox;

import org.ff4j.core.FlippingExecutionContext;
import org.springframework.stereotype.Component;

@Component("greeting.day")
public class OfficeHoursGreetingServiceDayImpl implements OfficeHoursGreetingService {

    public String sayHello(FlippingExecutionContext flippingExecutionContext, String name) {
        return "Good morning " + name + ", have a nice day.";
    }
}
