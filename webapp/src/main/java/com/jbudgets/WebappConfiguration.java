package com.jbudgets;

import com.jbudgets.domain.UserFactory;
import com.jbudgets.domain.WorkspaceFactory;
import com.jbudgets.domain.user.CurrentUserProvider;
import com.jbudgets.domain.user.User;
import com.jbudgets.domain.user.UserId;
import com.jbudgets.domain.workspace.CurrentWorkspaceProvider;
import com.jbudgets.domain.workspace.Workspace;
import com.jbudgets.domain.workspace.WorkspaceId;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebappConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(WebappConfiguration.class);

    @Bean
    public CurrentUserProvider currentUserProvider(UserFactory factory) {
        // TODO: remove this explicit workspace once we support user login
        User user = factory.createUser(UserId.from(1));
        CurrentUserProvider provider = new CurrentUserProvider();
        provider.set(user);
        return provider;
    }

    @Bean
    @VaadinSessionScope
    public CurrentWorkspaceProvider currentWorkspaceProvider(WorkspaceFactory factory) {
        // TODO: remove this explicit workspace once we support user login
        Workspace workspace = factory.createWorkspace(WorkspaceId.from(1));
        CurrentWorkspaceProvider provider = new CurrentWorkspaceProvider();
        provider.set(workspace);
        return provider;
    }
}
