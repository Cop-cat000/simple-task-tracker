package ruslan.user_service.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.security.crypto.password.PasswordEncoder;

import ruslan.common.persistence.entities.Roles;
import ruslan.common.persistence.entities.User;
import ruslan.common.persistence.exceptions.UserNotFoundException;
import ruslan.common.persistence.repositories.UserRepository;
import ruslan.user_service.dto.user.UserCreationDto;
import ruslan.user_service.dto.user.UserDto;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    public void isUsernameRegisteredHappyFlow() {
        User mockUser = new User();

        given(userRepository.findByUsername("abc"))
                .willReturn(Optional.of(mockUser));

        boolean result = userService.isUsernameRegistered("abc");

        verify(userRepository).findByUsername("abc");
        assertTrue(result);
    }

    @Test
    public void isUsernameRegisteredNegativeFlow() {
        given(userRepository.findByUsername("abc"))
                .willReturn(Optional.empty());

        boolean result = userService.isUsernameRegistered("abc");

        verify(userRepository).findByUsername("abc");
        assertFalse(result);
    }

    @Test
    public void isEmailRegisteredHappyFlow() {
        User mockUser = new User();

        given(userRepository.findByEmail("abc"))
                .willReturn(Optional.of(mockUser));

        boolean result = userService.isEmailRegistered("abc");

        verify(userRepository).findByEmail("abc");
        assertTrue(result);
    }

    @Test
    public void isEmailRegisteredNegativeFlow() {
        given(userRepository.findByEmail("abc"))
                .willReturn(Optional.empty());

        boolean result = userService.isEmailRegistered("abc");

        verify(userRepository).findByEmail("abc");
        assertFalse(result);
    }

    @Test
    public void createUserHappyFlow() {
        UserDto expected = new UserDto(0, "bill", "email@mail.com", Roles.USER);

        User mockUser = new User(0, "bill", "email@mail.com", "54321", Roles.USER);

        given(userRepository.save(mockUser))
                .willReturn(mockUser);
        given(passwordEncoder.encode("12345"))
                .willReturn("54321");

        UserDto result = userService.createUser(
                new UserCreationDto("bill", "email@mail.com", "12345", Roles.USER)
        );

        verify(userRepository).save(mockUser);
        assertEquals(expected, result);
    }

    @Test
    public void getByIdHappyFlow() {
        User mockUser = new User(1, "abc", "abc", "abc", Roles.USER);
        UserDto expected = new UserDto(mockUser);

        given(userRepository.findById(1L))
                .willReturn(Optional.of(mockUser));

        UserDto result = userService.getById(1);

        verify(userRepository).findById(1L);
        assertEquals(expected, result);
    }

    @Test
    public void getByIdNegativeFlow() {
        given(userRepository.findById(1L))
                .willReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,
                () -> userService.getById(1));
    }

    @Test
    public void getByUsernameHappyFlow() {
        User mockUser = new User(1, "abc", "abc", "abc", Roles.USER);
        UserDto expected = new UserDto(mockUser);

        given(userRepository.findByUsername("x"))
                .willReturn(Optional.of(mockUser));

        UserDto result = userService.getByUsername("x");

        verify(userRepository).findByUsername("x");
        assertEquals(expected, result);
    }

    @Test
    public void getByUsernameNegativeFlow() {
        given(userRepository.findByUsername("x"))
                .willReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,
                () -> userService.getByUsername("x"));
    }

    @Test
    public void getByEmailHappyFlow() {
        User mockUser = new User(1, "abc", "abc", "abc", Roles.USER);
        UserDto expected = new UserDto(mockUser);

        given(userRepository.findByEmail("x"))
                .willReturn(Optional.of(mockUser));

        UserDto result = userService.getByEmail("x");

        verify(userRepository).findByEmail("x");
        assertEquals(expected, result);
    }

    @Test
    public void getByEmailNegativeFlow() {
        given(userRepository.findByEmail("x"))
                .willReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,
                () -> userService.getByEmail("x"));
    }

    @Test
    public void getAllByIdHappyFlow() {
        List<User> mockUsers = List.of(new User(1, "abc", "abc", "abc", Roles.USER));
        List<UserDto> expected = List.of(new UserDto(mockUsers.get(0)));

        given(userRepository.findAllById(List.of(1L)))
                .willReturn(mockUsers);

        var result = userService.getAllById(List.of(1L));

        verify(userRepository).findAllById(List.of(1L));
        assertEquals(expected, result);
    }

    @Test
    public void getAllByIdNegativeFlow() {
        List<UserDto> expected = List.of();

        given(userRepository.findAllById(List.of()))
                .willReturn(List.of());

        var result = userService.getAllById(List.of());

        verify(userRepository).findAllById(List.of());
        assertEquals(expected, result);
    }

    @Test
    public void getAllByUsernameHappyFlow() {
        List<User> mockUsers = List.of(new User(1, "abc", "abc", "abc", Roles.USER));
        List<UserDto> expected = List.of(new UserDto(mockUsers.get(0)));

        given(userRepository.findAllByUsername(List.of("x")))
                .willReturn(mockUsers);

        var result = userService.getAllByUsername(List.of("x"));

        verify(userRepository).findAllByUsername(List.of("x"));
        assertEquals(expected, result);
    }

    @Test
    public void getAllByUsernameNegativeFlow() {
        List<UserDto> expected = List.of();

        given(userRepository.findAllByUsername(List.of()))
                .willReturn(List.of());

        var result = userService.getAllByUsername(List.of());

        verify(userRepository).findAllByUsername(List.of());
        assertEquals(expected, result);
    }

    @Test
    public void getAllByEmailHappyFlow() {
        List<User> mockUsers = List.of(new User(1, "abc", "abc", "abc", Roles.USER));
        List<UserDto> expected = List.of(new UserDto(mockUsers.get(0)));

        given(userRepository.findAllByEmail(List.of("x")))
                .willReturn(mockUsers);

        var result = userService.getAllByEmail(List.of("x"));

        verify(userRepository).findAllByEmail(List.of("x"));
        assertEquals(expected, result);
    }

    @Test
    public void getAllByEmailNegativeFlow() {
        List<UserDto> expected = List.of();

        given(userRepository.findAllByEmail(List.of()))
                .willReturn(List.of());

        var result = userService.getAllByEmail(List.of());

        verify(userRepository).findAllByEmail(List.of());
        assertEquals(expected, result);
    }

}
