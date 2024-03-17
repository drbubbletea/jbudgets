package com.jbudgets;

import com.jbudgets.domain.user.CurrentUserProvider;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.context.annotation.Bean;

public class WebappConfiguration {

    @Bean
    @VaadinSessionScope
    public CurrentUserProvider currentUserProvider() {
        return new CurrentUserProvider();
    }
}
