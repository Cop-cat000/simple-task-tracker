package ruslan.user_client_service.services;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ruslan.common.persistence.entities.User;
import ruslan.common.persistence.exceptions.UserNotFoundException;
import ruslan.common.persistence.repositories.UserRepository;
import ruslan.user_client_service.dto.user.UserCreationDto;
import ruslan.user_client_service.dto.user.UserDto;
import ruslan.user_client_service.dto.user.UserUpdationDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean isUsernameRegistered(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent();
    }

    public boolean isEmailRegistered(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();
    }

    @Transactional
    public UserDto createUser(UserCreationDto creationDto) {
        User user = new User();
        user.setUsername(creationDto.getUsername());
        user.setEmail(creationDto.getEmail());
        user.setPassword(
                passwordEncoder.encode(creationDto.getPassword())
        );
        user.setRole(creationDto.getRole());

        return new UserDto(userRepository.save(user));
    }

    public UserDto getById(long id) {
        return new UserDto(userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new));
    }

    public UserDto getByUsername(String username) {
        return new UserDto(userRepository.findByUsername(username)
                .orElseThrow(UserNotFoundException::new));
    }

    public UserDto getByEmail(String email) {
        return new UserDto(userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new));
    }

    public List<UserDto> getAllById(List<Long> ids) {
        return userRepository.findAllById(ids).stream()
                .map(UserDto::new)
                .toList();
    }


    public List<UserDto> getAllByUsername(List<String> usernames) {
        return userRepository.findAllByUsername(usernames).stream()
                .map(UserDto::new)
                .toList();
    }

    public List<UserDto> getAllByEmail(List<String> emails) {
        return userRepository.findAllByEmail(emails).stream()
                .map(UserDto::new)
                .toList();
    }

    @Transactional
    public UserDto updateUser(long id, UserUpdationDto updationDto) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        if(updationDto.username() != null) user.setUsername(updationDto.username());
        if(updationDto.email() != null) user.setEmail(updationDto.email());
        if(updationDto.password() != null) user.setPassword(
                passwordEncoder.encode(updationDto.password())
        );

        return new UserDto(user);
    }

    @Transactional
    public UserDto updateUser(String username, UserUpdationDto updationDto) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(UserNotFoundException::new);

        if(updationDto.username() != null) user.setUsername(updationDto.username());
        if(updationDto.email() != null) user.setEmail(updationDto.email());
        if(updationDto.password() != null) user.setPassword(
                passwordEncoder.encode(updationDto.password())
        );

        return new UserDto(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
