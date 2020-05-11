package org.pjamin.ff4j.spring.sandbox;

import org.ff4j.core.FlippingExecutionContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Ff4jSandboxService {

    private final OfficeHoursGreetingService officeHoursGreetingService;
    private final OrganizationGreetingService organizationGreetingService;

    public Ff4jSandboxService(OfficeHoursGreetingService officeHoursGreetingService, OrganizationGreetingService organizationGreetingService) {
        this.officeHoursGreetingService = officeHoursGreetingService;
        this.organizationGreetingService = organizationGreetingService;
    }

    public String greetOfficeHours(String name) {
        FlippingExecutionContext ctx = new FlippingExecutionContext();

        return officeHoursGreetingService.sayHello(ctx, name);
    }

    public String greetOrganization() {
        String organization = getOrganizationFromToken();

        Map<String, Object> map = new HashMap<>();
        map.put("organization", organization);
        FlippingExecutionContext ctx = new FlippingExecutionContext(map);

        return organizationGreetingService.sayHello(ctx);
    }

    private String getOrganizationFromToken() {
        return "G2S";
    }
}
