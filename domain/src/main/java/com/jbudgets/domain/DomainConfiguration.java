package com.jbudgets.domain;

import com.jbudgets.domain.user.impl.DefaultUser;
import jakarta.inject.Singleton;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DomainConfiguration {

    @Bean
    public TestService testService() {
        return new TestService();
    }
}
