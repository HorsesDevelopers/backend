package org.aquasense.platform.iam.interfaces.rest.transform;

import org.aquasense.platform.iam.domain.model.commands.SignInCommand;
import org.aquasense.platform.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
