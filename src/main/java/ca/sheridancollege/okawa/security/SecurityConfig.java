package ca.sheridancollege.okawa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvc = new MvcRequestMatcher.Builder(introspector);
        
        return http.authorizeHttpRequests(authorize -> authorize
                // Public pages
                .requestMatchers(mvc.pattern("/")).permitAll()
                .requestMatchers(mvc.pattern("/js/**")).permitAll()
                .requestMatchers(mvc.pattern("/css/**")).permitAll()
                .requestMatchers(mvc.pattern("/images/**")).permitAll()
                .requestMatchers(mvc.pattern("/login")).permitAll()
                .requestMatchers(mvc.pattern("/signup")).permitAll()
                .requestMatchers(mvc.pattern("/permission-denied")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                
                // Public routes
                .requestMatchers(mvc.pattern("/destinations")).permitAll()
                .requestMatchers(mvc.pattern("/adventures")).permitAll()
                .requestMatchers(mvc.pattern("/guides")).permitAll()
                .requestMatchers(mvc.pattern("/guides/**")).permitAll()
                .requestMatchers(mvc.pattern("/searchTrips")).permitAll()
                .requestMatchers(mvc.pattern("/destination-*/**")).permitAll()
                .requestMatchers(mvc.pattern("/adventures-*/**")).permitAll()
                
                // Secured routes (require authentication)
                .requestMatchers(AntPathRequestMatcher.antMatcher("/registration")).hasAnyRole("USER", "ADMIN")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/secure/**")).hasAnyRole("USER", "ADMIN")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/admin/**")).hasRole("ADMIN")
                
                // All other requests require authentication
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf
                .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**"))
                .disable()
            )
            .headers(headers -> headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()))
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
            )
            .exceptionHandling(exception -> exception
                .accessDeniedPage("/permission-denied")
            )
            .logout(logout -> logout
                .permitAll()
            )
            .userDetailsService(userDetailsService)
            .build();
    }
}