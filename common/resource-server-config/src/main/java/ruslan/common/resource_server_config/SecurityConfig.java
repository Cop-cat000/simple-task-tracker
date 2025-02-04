package ruslan.common.resource_server_config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Value("${jwksUri}")
    private String jwksUri;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer ->
            httpSecurityOAuth2ResourceServerConfigurer.jwt().jwkSetUri(jwksUri)
                    .jwtAuthenticationConverter(new JwtAuthenticationTokenConverter())
        );
        http.authorizeRequests().anyRequest().authenticated();
        return http.build();
    }
}
