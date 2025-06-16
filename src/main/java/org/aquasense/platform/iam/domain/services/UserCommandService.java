package org.aquasense.platform.iam.domain.services;


import org.aquasense.platform.iam.domain.model.aggregates.User;
import org.aquasense.platform.iam.domain.model.commands.SignInCommand;
import org.aquasense.platform.iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
    Optional<User> handle(SignUpCommand command);


}
