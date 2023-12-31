package com.udemy.SimpleSpringWebApplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class ProjectSecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

        http.csrf((csrf) -> csrf
                        .ignoringRequestMatchers(mvcMatcherBuilder.pattern("/saveMsg")).ignoringRequestMatchers(mvcMatcherBuilder.pattern("/public/**"))
                        .ignoringRequestMatchers(mvcMatcherBuilder.pattern("/api/**")).ignoringRequestMatchers(mvcMatcherBuilder.pattern("/data-api/**"))
                )
                .authorizeHttpRequests((requests) -> requests.
                         requestMatchers(mvcMatcherBuilder.pattern("/displayMessages/**")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/closeMsg/**")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/data-api/**")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/admin/**")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/eazyschool/actuator/**")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/dashboard")).authenticated()
                        .requestMatchers(mvcMatcherBuilder.pattern("/displayProfile")).authenticated()
                        .requestMatchers(mvcMatcherBuilder.pattern("/api/**")).authenticated()
                        .requestMatchers(mvcMatcherBuilder.pattern("")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/home")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/holidays/**")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/contact")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/saveMsg")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/courses")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/about")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/assets/**")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/login")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/public/*")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/logout")).permitAll())
                .formLogin(loginConfigurer -> loginConfigurer.loginPage("/login")
                        .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll())
                .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true).permitAll())
                .httpBasic(Customizer.withDefaults());

        return http.build();

    }
}