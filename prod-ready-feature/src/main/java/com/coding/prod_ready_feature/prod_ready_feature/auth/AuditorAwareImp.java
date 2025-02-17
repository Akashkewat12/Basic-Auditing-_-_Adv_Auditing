package com.coding.prod_ready_feature.prod_ready_feature.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImp implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // get security context
        // get Authentication
        // get the principle
        // get the username
        return Optional.of("Akash kumar Bind");
    }

}
