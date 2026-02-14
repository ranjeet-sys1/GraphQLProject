package com.example.graphQl;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.time.OffsetDateTime;
import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class GraphQLDateTimeCOnfiguration {
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.DateTime);
    }
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("SYSTEM");
    }
    @Bean
    public DateTimeProvider auditingDateTimeProvider() {
        return () -> Optional.of(OffsetDateTime.now());
    }


}
