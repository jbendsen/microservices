package dk.logb.microservices.techstack.infrastructure;

import org.slf4j.*;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.*;
import org.springframework.core.MethodParameter;

import java.lang.reflect.Field;

import static java.util.Optional.*;

@Configuration
public class LoggingConfiguration {

    @Bean
    @Scope("prototype")
    public Logger logger(final InjectionPoint ip) {
        if (ip.getMethodParameter() != null) {
            return LoggerFactory.getLogger(ip.getMethodParameter().getContainingClass().getName());
        }

        if (ip.getField() != null) {
            return LoggerFactory.getLogger(ip.getField().getDeclaringClass().getName());
        }

        throw new IllegalStateException("No suitable logger found!");
    }

}
