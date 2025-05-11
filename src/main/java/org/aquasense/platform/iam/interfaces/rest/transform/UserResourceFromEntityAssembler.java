package org.aquasense.platform.iam.interfaces.rest.transform;

import org.aquasense.platform.iam.domain.model.aggregates.User;
import org.aquasense.platform.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        return new UserResource(
                user.getId(),
                user.getUsername(),
                user.getWorkerId(),
                user.getRoles().stream().map(RoleResourceFromEntityAssembler::toResourceFromEntity).toList()
        );
    }
}
