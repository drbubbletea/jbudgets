package com.jbudgets.domain;

import com.jbudgets.domain.workspace.Workspace;
import com.jbudgets.domain.workspace.WorkspaceId;
import com.jbudgets.domain.workspace.budget.Budget;
import com.jbudgets.domain.workspace.budget.BudgetId;
import com.jbudgets.domain.workspace.budget.impl.DefaultBudget;
import com.jbudgets.domain.workspace.impl.DefaultWorkspace;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BudgetFactory {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Budget create(BudgetId id, String name) {
        return new DefaultBudget(id, name);
    }
}
