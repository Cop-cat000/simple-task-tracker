package ruslan.user_client_service.dto.user;

// TODO: Accept validation

public record UserUpdationDto(String username,
                              String email,
                              String password) {
}
