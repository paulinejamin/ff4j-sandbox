package org.pjamin.ff4j.spring.sandbox;

import org.ff4j.core.FlippingExecutionContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("greeting.night")
@Primary
public class OfficeHoursGreetingServiceNightImpl implements OfficeHoursGreetingService {

    public String sayHello(FlippingExecutionContext flippingExecutionContext, String name) {
        return "Hey " + name + ", have a beer !";
    }
}
