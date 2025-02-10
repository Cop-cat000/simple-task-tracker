package ruslan.user_client_service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ruslan.common.persistence.entities.Roles;
import ruslan.user_client_service.dto.user.UserDto;

@Service
@RequiredArgsConstructor
public class RoleValidationService {

    private final UserService userService;

    public boolean validateDeletion(long userId) {
        var role = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().findAny().get().toString();
        if(role.equals("ROLE_root")) return true;

        UserDto user = userService.getById(userId);
        return user.role().equals(Roles.USER);
    }
}
