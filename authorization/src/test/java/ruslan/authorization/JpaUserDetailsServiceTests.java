package ruslan.authorization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ruslan.authorization.services.JpaUserDetailsService;
import ruslan.common.persistence.entities.Roles;
import ruslan.common.persistence.entities.User;
import ruslan.common.persistence.repositories.UserRepository;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class JpaUserDetailsServiceTests {

    @Test
    @DisplayName("Test the User is loaded from database if no exceptions occurs.")
    public void loadUserByUsernameHappyFlow() {
        UserRepository userRepository = mock(UserRepository.class);
        JpaUserDetailsService jpaUserDetailsService = new JpaUserDetailsService(userRepository);

        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setUsername("bill");
        mockUser.setEmail("bill@mail.com");
        mockUser.setRole(Roles.ROOT);

        given(userRepository.findByUsername("bill"))
                .willReturn(Optional.of(mockUser));

        jpaUserDetailsService.loadUserByUsername("bill");

        verify(userRepository).findByUsername("bill");
    }
}
