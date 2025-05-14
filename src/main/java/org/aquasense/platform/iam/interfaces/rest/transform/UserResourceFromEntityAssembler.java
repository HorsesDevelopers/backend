package org.aquasense.platform.iam.interfaces.rest.transform;

import org.aquasense.platform.iam.domain.model.aggregates.User;
import org.aquasense.platform.iam.domain.model.entities.Role;
import org.aquasense.platform.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream()
                .map(Role::getStringName)
                .toList();
        return new UserResource(
                user.getId(),
                user.getUsername(),
                //user.getWorkerId(),
                roles
        );
    }
}
