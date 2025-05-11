package org.aquasense.platform.iam.interfaces.rest.resources;

import java.util.Date;
import java.util.List;

public record SignUpResource(
        String email,
        String password,
        List<String> roles,
        String firstName,
        String lastName,
        String DNI,
        String workerCondition,
        String phoneNumber,
        String address,
        Date birthDate,
        String imgUrl,
        String workerArea
) {
}