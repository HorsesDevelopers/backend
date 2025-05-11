package org.aquasense.platform.iam.application.internal.commandservices;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.aquasense.platform.iam.application.internal.outboundservices.hashing.HashingService;
import org.aquasense.platform.iam.application.internal.outboundservices.tokens.TokenService;
import org.aquasense.platform.iam.domain.model.aggregates.User;
import org.aquasense.platform.iam.domain.model.commands.SignInCommand;
import org.aquasense.platform.iam.domain.model.commands.SignUpCommand;
import org.aquasense.platform.iam.domain.services.UserCommandService;
import org.aquasense.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.aquasense.platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * User command service implementation
 * <p>
 *     This class implements the {@link UserCommandService} interface and provides the implementation for the
 *     {@link SignInCommand} and {@link SignUpCommand} commands.
 * </p>
 */
@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;

    private final RoleRepository roleRepository;

    public UserCommandServiceImpl(
            UserRepository userRepository,
            HashingService hashingService,
            TokenService tokenService,
            RoleRepository roleRepository
    ) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username());
        if (user.isEmpty())
            throw new RuntimeException("User not found");

        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");


        var token = tokenService.generateToken(user.get().getUsername());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        throw  new UnsupportedOperationException("Not supported yet.");
    }
}
