package com.jbudgets.domain;

import com.jbudgets.domain.impl.DefaultDomainFactory;
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
    @Singleton
    public TestService testService() {
        return new TestService();
    }

    @Bean
    public DefaultDomainFactory defaultDomainFactory(ApplicationContext applicationContext) {
        return new DefaultDomainFactory(applicationContext);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DefaultUser user() {
        return new DefaultUser();
    }
}
