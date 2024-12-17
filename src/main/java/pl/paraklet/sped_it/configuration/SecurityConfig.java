package pl.paraklet.sped_it.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pl.paraklet.sped_it.service.CustomFirmaDetailsService;

@Configuration
public class SecurityConfig {

    private final CustomFirmaDetailsService firmaDetailsService;

    public SecurityConfig(CustomFirmaDetailsService firmaDetailsService) {
        this.firmaDetailsService = firmaDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors() // Włączenie obsługi CORS
                .and()
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/firma").permitAll() // Publiczny dostęp
                        .anyRequest().authenticated()                 // Pozostałe endpointy wymagają autoryzacji
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Twój endpoint do logowania
                        .defaultSuccessUrl("https://sped-it-front-00850f6f4d51.herokuapp.com", true) // Przekierowanie po zalogowaniu)
                .and()
                .logout(logout -> logout
                        .logoutUrl("/logout")              // URL wylogowywania (domyślnie /logout)
                        .logoutSuccessUrl("/login?logout") // URL przekierowania po wylogowaniu
                        .deleteCookies("JSESSIONID")      // Usuń ciasteczka (opcjonalne)
                        .invalidateHttpSession(true)      // Unieważnij sesję
                        .clearAuthentication(true)        // Wyczyszczenie uwierzytelnienia
                        .logoutSuccessUrl("https://sped-it-front-00850f6f4d51.herokuapp.com")
                )
                .httpBasic();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(firmaDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }
}