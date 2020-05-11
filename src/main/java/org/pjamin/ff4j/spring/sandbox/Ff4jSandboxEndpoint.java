package org.pjamin.ff4j.spring.sandbox;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Ff4jSandboxEndpoint {

    private final Ff4jSandboxService ff4jSandboxService;

    public Ff4jSandboxEndpoint(Ff4jSandboxService ff4jSandboxService) {
        this.ff4jSandboxService = ff4jSandboxService;
    }

    @GetMapping("/office-hours-greeting")
    public String sayStrategyAopHello(@RequestParam String who) {
        return ff4jSandboxService.greetOfficeHours(who);
    }

    @GetMapping("/organization-greeting")
    public String sayStrategyAopHello() {
        return ff4jSandboxService.greetOrganization();
    }
}
