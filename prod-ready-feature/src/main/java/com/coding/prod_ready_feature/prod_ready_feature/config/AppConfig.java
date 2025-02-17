package com.coding.prod_ready_feature.prod_ready_feature.config;

import com.coding.prod_ready_feature.prod_ready_feature.auth.AuditorAwareImp;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImp")
public class AppConfig {

    @Bean
    ModelMapper getModelMapper() {

        return new ModelMapper();
    }

    @Bean
    AuditorAware<String> getAuditorAwareImp() {
        return new AuditorAwareImp();
    }
}


