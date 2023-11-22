package unirio.es1.TransLogAPI.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import unirio.es1.TransLogAPI.security.JWTAuthenticationFilter;
import unirio.es1.TransLogAPI.security.JWTAuthorizationFilter;
import unirio.es1.TransLogAPI.security.JWTUtil;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;
    private UserDetailsService userDetailsService;

    private static final String[] PUBLIC_MATCHERS = new String[]{
            "/login"
    };

    private static final String[] PUBLIC_MATCHERS_POST = new String[]{
            "/api/usuario"
    };

    @Autowired
    public SecurityConfig(JWTUtil jwtUtil, UserDetailsService userDetailsService){
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.addFilterBefore(new CorsFilter(corsConfigurationSource()), UsernamePasswordAuthenticationFilter.class);
        http.csrf(AbstractHttpConfigurer::disable);

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(this.bCryptPasswordEncoder());
        this.authenticationManager = authenticationManagerBuilder.build();
        http.authorizeHttpRequests((request) -> {
            (request.requestMatchers(PUBLIC_MATCHERS).permitAll().requestMatchers(PUBLIC_MATCHERS_POST)).permitAll().anyRequest().authenticated();
        }).authenticationManager(this.authenticationManager);
        http.addFilter(new JWTAuthenticationFilter(this.authenticationManager, this.jwtUtil)).addFilter(new JWTAuthorizationFilter(this.authenticationManager, this.jwtUtil, this.userDetailsService));
        http.sessionManagement((httpSecuritySessionManagementConfigurer) -> {
            httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });
        return http.build();

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = (new CorsConfiguration()).applyPermitDefaultValues();
        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedOrigins(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
