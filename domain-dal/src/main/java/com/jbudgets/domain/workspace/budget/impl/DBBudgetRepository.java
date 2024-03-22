package com.jbudgets.domain.workspace.budget.impl;

import com.jbudgets.domain.BudgetFactory;
import com.jbudgets.domain.workspace.budget.Budget;
import com.jbudgets.domain.workspace.budget.BudgetId;
import com.jbudgets.domain.workspace.budget.BudgetRepository;
import com.jbudgets.resource.ClassResource;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBBudgetRepository implements BudgetRepository {

    private static final String FIND_BUDGETS_BY_WORKSPACE = ClassResource.get("find_budgets_by_workspace.sql");
    private static final String FIND_BUDGETS = ClassResource.get("find_budget_by_ws_year_month.sql");
    private static final String COUNT_BUDGETS = ClassResource.get("count_budget_by_ws_year_month.sql");

    private final NamedParameterJdbcTemplate jdbc;

    private final BudgetFactory factory;

    @Inject
    public DBBudgetRepository(NamedParameterJdbcTemplate jdbc, BudgetFactory factory) {
        this.jdbc = jdbc;
        this.factory = factory;
    }

    @Override
    public List<Budget> budgets() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    public static class BudgetRowMapper implements RowMapper<Budget> {

        private final BudgetFactory factory;
        public BudgetRowMapper(BudgetFactory factory) {
            this.factory = factory;
        }

        @Override
        public Budget mapRow(ResultSet rs, int rowNum) throws SQLException {
            return factory.create(BudgetId.from(rs.getInt("id")), rs.getString("name"));
        }
    }
}
