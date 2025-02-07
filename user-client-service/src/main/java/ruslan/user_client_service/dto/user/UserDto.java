package ruslan.user_client_service.dto.user;

import ruslan.common.persistence.entities.Roles;
import ruslan.common.persistence.entities.User;

public record UserDto(long id,
                      String username,
                      String email,
                      Roles role) {

    public UserDto(User user) {
        this(user.getId(), user.getUsername(), user.getEmail(), user.getRole());
    }
}
