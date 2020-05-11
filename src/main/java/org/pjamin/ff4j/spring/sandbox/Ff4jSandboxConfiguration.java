package org.pjamin.ff4j.spring.sandbox;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.ff4j.FF4j;
import org.ff4j.audit.EventPublisher;
import org.ff4j.springjdbc.store.EventRepositorySpringJdbc;
import org.ff4j.web.FF4jDispatcherServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Ff4jSandboxConfiguration extends SpringBootServletInitializer {

    @Bean
    public ServletRegistrationBean<FF4jDispatcherServlet> console(FF4jDispatcherServlet ff4jDispatcherServlet) {
        return new ServletRegistrationBean<>(ff4jDispatcherServlet, "/monitor/*");
    }

    @Bean
    public FF4j getFF4j() {
        FF4j ff4j = new FF4j("ff4j.xml");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:C:\\\\Temp/monitoring/MONITORING;AUTO_SERVER=TRUE;MODE=Oracle");
        config.setUsername("MONITORING");
        config.setPassword("MONITORING");
        HikariDataSource hikariDataSource = new HikariDataSource(config);

        EventRepositorySpringJdbc eventRepositorySpringJdbc = new EventRepositorySpringJdbc(hikariDataSource);
        eventRepositorySpringJdbc.createSchema();

        ff4j.setEventRepository(eventRepositorySpringJdbc);
        ff4j.setEventPublisher(new EventPublisher(eventRepositorySpringJdbc));
        ff4j.setEnableAudit(true);

        return ff4j;
    }

    @Bean
    @ConditionalOnMissingBean
    public FF4jDispatcherServlet getFF4jDispatcherServlet(FF4j ff4j) {
        FF4jDispatcherServlet ff4jDispatcherServlet = new FF4jDispatcherServlet();
        ff4jDispatcherServlet.setFf4j(ff4j);
        return ff4jDispatcherServlet;
    }
}
