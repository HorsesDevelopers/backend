package org.aquasense.platform.iam.interfaces.rest.transform;


import org.aquasense.platform.iam.domain.model.aggregates.User;
import org.aquasense.platform.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
