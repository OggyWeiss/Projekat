package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.repository.KorisnikRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/", "/index.html", "/loginController/**", "/prikazLogina/**", "/loginFolder/**", "/registracijaController/**", "/nelogovanController/**", "/dogadjaji/**").permitAll()
                .requestMatchers("/administratorController/**").hasRole("ADMIN")
                .requestMatchers("/dogadjajController/**").hasRole("KORISNIK")
                .requestMatchers("/porukaController/**").hasRole("KORISNIK")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/loginFolder/loginStranica.jsp")
                .loginProcessingUrl("/login") 
                .defaultSuccessUrl("/loginController/preusmeriNakonLogin", false)

            )
            .logout(logout -> logout
                .logoutSuccessUrl("/loginController/odjava")

            )
            .exceptionHandling(handling -> handling
                .accessDeniedPage("/jsp/access_denied.jsp")
            )
            .csrf(csrf -> csrf.disable());
        return http.build();
    }

	@Bean
	public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		return new ProviderManager(authenticationProvider);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
