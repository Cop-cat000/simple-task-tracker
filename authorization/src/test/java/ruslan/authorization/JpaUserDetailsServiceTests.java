package ruslan.authorization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ruslan.authorization.model.SecurityUser;
import ruslan.authorization.services.JpaUserDetailsService;
import ruslan.common.persistence.entities.Roles;
import ruslan.common.persistence.entities.User;
import ruslan.common.persistence.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class JpaUserDetailsServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private JpaUserDetailsService jpaUserDetailsService;

    @Test
    @DisplayName("Test the User is loaded from database if no exceptions occurs.")
    public void loadUserByUsernameHappyFlow() {
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

    @Test
    @DisplayName("Test if the exception is thrown")
    public void loadUserByUsernameExceptionFlow() {
        given(userRepository.findByUsername("bill"))
                .willReturn(Optional.empty());

        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> jpaUserDetailsService.loadUserByUsername("bill"));
    }

    @Test
    @DisplayName("Test if the assumed value is equals to the result")
    public void loadUserByUsernameEqualityTest() {
        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setUsername("bill");
        mockUser.setEmail("bill@mail.com");
        mockUser.setRole(Roles.ROOT);

        given(userRepository.findByUsername("bill"))
                .willReturn(Optional.of(mockUser));

        var assertedResult = new SecurityUser(mockUser);
        var result = jpaUserDetailsService.loadUserByUsername("bill");

        Assertions.assertEquals(assertedResult, result);
        verify(userRepository).findByUsername("bill");
    }
}
