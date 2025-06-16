package org.aquasense.platform.iam.interfaces.rest.resources;// SignUpResource


import java.util.List;

public record SignUpResource(String username, String password, List<String> roles) {
}