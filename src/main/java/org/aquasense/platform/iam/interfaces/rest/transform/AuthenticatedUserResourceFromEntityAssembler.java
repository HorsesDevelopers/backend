package org.aquasense.platform.iam.interfaces.rest.transform;

import org.aquasense.platform.iam.domain.model.aggregates.User;
import org.aquasense.platform.iam.interfaces.rest.resources.AuthenticatedUserResource;

import java.util.stream.Collectors;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        var roles = user.getRoles().stream()
                .map(role -> role.getStringName()) // Transforma los roles a nombres
                .collect(Collectors.toList());
        return new AuthenticatedUserResource(
                user.getId(),
                user.getUsername(),
                token,
                roles
        );
    }
}
