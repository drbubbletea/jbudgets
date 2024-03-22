package com.jbudgets.domain;

import com.jbudgets.domain.workspace.Workspace;
import com.jbudgets.domain.workspace.WorkspaceId;
import com.jbudgets.domain.workspace.impl.DefaultWorkspace;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WorkspaceFactory {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Workspace createWorkspace(WorkspaceId id) {
        return new DefaultWorkspace(id);
    }
}
