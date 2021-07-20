package web.spring313v2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import web.spring313v2.security.handler.LoginSuccessHandler;
import web.spring313v2.service.UserServiceImpl;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserServiceImpl userDetailsService;

    @Autowired
    public void WebSecurityConfig(UserServiceImpl userDetailsService) {
        this.userDetailsService=userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.formLogin()
                    .loginPage("/login")
                    .successHandler(new LoginSuccessHandler())
                    .loginProcessingUrl("/login")
                    .usernameParameter("login")
                    .passwordParameter("password")
                    .permitAll();

            http.logout()
                    .permitAll()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .and().csrf().disable();

            http.authorizeRequests()
                    .antMatchers("/login").anonymous()
                    .antMatchers("/api/user").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/api/**").hasRole("ADMIN")
                    .anyRequest().authenticated();

    }
}

















