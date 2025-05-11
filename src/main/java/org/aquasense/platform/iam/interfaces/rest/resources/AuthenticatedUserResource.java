package org.aquasense.platform.iam.interfaces.rest.resources;

import java.util.List;

public record AuthenticatedUserResource(
        Long id,
        String username,
        String token,
        List<RoleResource> role,
        Long workerId
) {

}
