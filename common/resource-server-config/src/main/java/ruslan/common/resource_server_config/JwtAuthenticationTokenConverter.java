package ruslan.common.resource_server_config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.List;

public class JwtAuthenticationTokenConverter implements Converter<Jwt, JwtAuthenticationToken> {

    @Override
    public JwtAuthenticationToken convert(Jwt source) {
        String role = (String) source.getClaims().get("role");
        JwtAuthenticationToken authenticationObj =
                new JwtAuthenticationToken(source, List.of(new SimpleGrantedAuthority(role)));
        return authenticationObj;
    }
}
