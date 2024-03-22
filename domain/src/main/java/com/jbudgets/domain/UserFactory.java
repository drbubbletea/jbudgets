package com.jbudgets.domain;

import com.jbudgets.domain.user.User;
import com.jbudgets.domain.user.UserId;
import com.jbudgets.domain.user.impl.DefaultUser;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UserFactory {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User createUser(UserId id) {
        return new DefaultUser(id);
    }

}
