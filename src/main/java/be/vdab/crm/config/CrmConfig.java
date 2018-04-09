package be.vdab.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.spring5.expression.Mvc;

@Configuration
@ComponentScan
public class CrmConfig {

    @Bean
    public Mvc mvc() {
        return new Mvc();
    }

}
