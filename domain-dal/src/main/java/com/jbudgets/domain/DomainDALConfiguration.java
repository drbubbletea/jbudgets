package com.jbudgets.domain;

import com.jbudgets.domain.user.impl.DBUserDAL;
import com.jbudgets.domain.user.impl.DBUserRepository;
import com.jbudgets.domain.workspace.budget.impl.DBBudgetDAL;
import com.jbudgets.domain.workspace.budget.impl.DBBudgetRepository;
import com.jbudgets.domain.workspace.impl.DBWorkspaceDAL;
import com.jbudgets.domain.workspace.impl.DBWorkspaceRepository;
import com.jbudgets.domain.workspace.transaction.impl.DBTransactionDAL;
import com.jbudgets.domain.workspace.transaction.impl.DBTransactionRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DomainDALConfiguration {

    @Bean
    public DBBudgetDAL dbBudgetDAL() {
        return new DBBudgetDAL();
    }

    @Bean
    public DBBudgetRepository dbBudgetRepository(NamedParameterJdbcTemplate template, BudgetFactory factory) {
        return new DBBudgetRepository(template, factory);
    }

    @Bean
    public DBTransactionDAL dbTransactionDAL() {
        return new DBTransactionDAL();
    }

    @Bean
    public DBTransactionRepository dbTransactionRepository() {
        return new DBTransactionRepository();
    }

    @Bean
    public DBUserDAL dbUserDAL() {
        return new DBUserDAL();
    }

    @Bean
    public DBUserRepository dbUserRepository() {
        return new DBUserRepository();
    }

    @Bean
    public DBWorkspaceDAL dbWorkspaceDAL() {
        return new DBWorkspaceDAL();
    }

    @Bean
    public DBWorkspaceRepository dbWorkspaceRepository(NamedParameterJdbcTemplate template, WorkspaceFactory factory) {
        return new DBWorkspaceRepository(template, factory);
    }

}
