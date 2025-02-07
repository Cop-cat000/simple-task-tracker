package ruslan.user_client_service.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ruslan.user_client_service.dto.user.UserCreationDto;

@Service
public class RoleValidationService {

    public boolean validate(UserCreationDto creationDto) {
        var authorities = SecurityContextHolder.getContext().getAuthentication();
        var x = authorities.getAuthorities().stream().findFirst().toString();
    }
}
