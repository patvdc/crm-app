package be.vdab.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.expression.Mvc;

@Configuration
@ComponentScan
public class CrmConfig {

    @Bean
    public Mvc mvc() {
        return new Mvc();
    }
}
