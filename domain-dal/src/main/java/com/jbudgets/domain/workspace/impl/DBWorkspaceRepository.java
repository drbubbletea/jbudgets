package com.jbudgets.domain.workspace.impl;

import com.jbudgets.domain.WorkspaceFactory;
import com.jbudgets.domain.user.UserId;
import com.jbudgets.domain.workspace.Workspace;
import com.jbudgets.domain.workspace.WorkspaceId;
import com.jbudgets.domain.workspace.WorkspaceRepository;
import com.jbudgets.resource.ClassResource;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBWorkspaceRepository implements WorkspaceRepository {
    private static final String GET_DEFAULT_USER_WORKSPACE = ClassResource.get("find_default_user_workspace.sql");

    private final NamedParameterJdbcTemplate jdbc;
    private final WorkspaceFactory factory;
    @Inject
    public DBWorkspaceRepository(NamedParameterJdbcTemplate jdbc, WorkspaceFactory factory) {
        this.jdbc = jdbc;
        this.factory = factory;
    }

    @Override
    public Workspace getDefaultWorkspace(UserId id) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("userId", id.value());
        return jdbc.query(GET_DEFAULT_USER_WORKSPACE, params, new WorkspaceRowMapper(factory)).getFirst();
    }

    public static class WorkspaceRowMapper implements RowMapper<Workspace> {

        private final WorkspaceFactory factory;

        public WorkspaceRowMapper(WorkspaceFactory factory) {
            this.factory = factory;
        }

        @Override
        public Workspace mapRow(ResultSet rs, int rowNum) throws SQLException {
            return factory.createWorkspace(WorkspaceId.from(rs.getInt("id")));

        }
    }
}
