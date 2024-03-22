package com.jbudgets.widget;

import com.jbudgets.widget.budget.BudgetCreate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PublicWidgetFactory {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public BudgetCreate budgetCreate() {
        return new BudgetCreate();
    }
}
