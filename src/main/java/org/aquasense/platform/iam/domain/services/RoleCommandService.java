package org.aquasense.platform.iam.domain.services;

import org.aquasense.platform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
