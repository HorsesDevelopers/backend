package org.aquasense.platform.iam.domain.model.commands;


import org.aquasense.platform.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}