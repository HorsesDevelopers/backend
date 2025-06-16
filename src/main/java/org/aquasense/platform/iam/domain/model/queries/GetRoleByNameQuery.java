package org.aquasense.platform.iam.domain.model.queries;


import org.aquasense.platform.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
