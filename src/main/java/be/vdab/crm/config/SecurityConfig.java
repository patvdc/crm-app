package be.vdab.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //    super.configure(auth);
        auth
                .inMemoryAuthentication()
                .withUser("user1").password(" ").roles("SALES").and()
                .withUser("user2").password(" ").roles("ADMIN").and()
                .withUser("user3").password(" ").roles("SALES", "ADMIN");

        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select email, password, true from users where email=?")
                .authoritiesByUsernameQuery("select email, role from users where email=?");
        //        .passwordEncoder(new StandardPasswordEncoder("53cr3t"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);

        http
                .csrf().disable()
                .formLogin()
                .loginPage("/login")
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/contacts").hasAnyRole("SALES")
                .antMatchers("/quotes").hasAnyRole("SALES")
                .antMatchers("/products").hasAnyRole("ADMIN")
                .antMatchers("/users").hasAnyRole("ADMIN")
                .anyRequest().permitAll()    //catch-all
                .and()
                .logout()
                .logoutSuccessUrl("/");
       //         .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

    }
}