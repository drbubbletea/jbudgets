package com.jbudgets.domain.workspace;

import com.jbudgets.domain.user.UserId;

public interface WorkspaceRepository {
    Workspace getDefaultWorkspace(UserId id);
}
