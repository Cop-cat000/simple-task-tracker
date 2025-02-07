package ruslan.user_client_service.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;

import ruslan.common.persistence.entities.Roles;

@Getter
public class UserCreationDto {

    @NotNull
    private String username;

    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private Roles role;
}
