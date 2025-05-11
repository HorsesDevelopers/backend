package org.aquasense.platform.iam.infrastructure.hashing.bcrypt;

import org.aquasense.platform.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
