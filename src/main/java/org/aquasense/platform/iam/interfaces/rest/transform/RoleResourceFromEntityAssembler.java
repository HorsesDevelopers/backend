package org.aquasense.platform.iam.interfaces.rest.transform;

import org.aquasense.platform.iam.domain.model.entities.Role;
import org.aquasense.platform.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
