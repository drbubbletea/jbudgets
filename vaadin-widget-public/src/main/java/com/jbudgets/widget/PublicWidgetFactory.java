package com.jbudgets.widget;

import com.jbudgets.domain.workspace.budget.BudgetDAL;
import com.jbudgets.widget.budget.BudgetCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PublicWidgetFactory {

    @Autowired
    private BudgetDAL budgetDAL;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public BudgetCreate budgetCreate() {
        return new BudgetCreate(budgetDAL);
    }
}
