package ruslan.user_service.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import ruslan.common.persistence.entities.Roles;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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
