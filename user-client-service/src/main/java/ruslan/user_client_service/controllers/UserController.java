package ruslan.user_client_service.controllers;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import ruslan.user_client_service.dto.user.UserCreationDto;
import ruslan.user_client_service.dto.user.UserDto;
import ruslan.user_client_service.dto.user.UserUpdationDto;
import ruslan.user_client_service.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('root')")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserCreationDto creationDto) {
        return ResponseEntity
                .status(202)
                .body(userService.createUser(creationDto));
    }

    @GetMapping("/get/id/{id}")
    @PreAuthorize("hasAnyRole('root', 'admin')")
    public ResponseEntity<UserDto> getById(@PathVariable long id) {
        return ResponseEntity
                .status(202)
                .body(userService.getById(id));
    }

    @GetMapping("/get/username/{username}")
    @PreAuthorize("hasAnyRole('root', 'admin')")
    public ResponseEntity<UserDto> getByUsername(@PathVariable String username) {
        return ResponseEntity
                .status(202)
                .body(userService.getByUsername(username));
    }

    @GetMapping("/get/email/{email}")
    @PreAuthorize("hasAnyRole('root', 'admin')")
    public ResponseEntity<UserDto> getByEmail(@PathVariable String email) {
        return ResponseEntity
                .status(202)
                .body(userService.getByEmail(email));
    }

    @GetMapping("/get/self")
    public ResponseEntity<UserDto> getUser(Authentication authentication) {
        var username = authentication.getName();
        return ResponseEntity
                .status(202)
                .body(userService.getByUsername(username));
    }

    @GetMapping("/get/all/id")
    @PreAuthorize("hasAnyRole('root', 'admin')")
    public ResponseEntity<List<UserDto>> getAllById(@RequestBody List<Long> ids) {
        return ResponseEntity
                .status(202)
                .body(userService.getAllById(ids));
    }

    @GetMapping("/get/all/username")
    @PreAuthorize("hasAnyRole('root', 'admin')")
    public ResponseEntity<List<UserDto>> getAllByUsername(@RequestBody List<String> usernames) {
        return ResponseEntity
                .status(202)
                .body(userService.getAllByUsername(usernames));
    }

    @GetMapping("/get/all/email")
    @PreAuthorize("hasAnyRole('root', 'admin')")
    public ResponseEntity<List<UserDto>> getAllByEmail(@RequestBody List<String> emails) {
        return ResponseEntity
                .status(202)
                .body(userService.getAllByEmail(emails));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('root', 'admin') && @roleValidationService.validateDeletion(#id)")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity
                .status(202)
                .build();
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('root')")
    public ResponseEntity<UserDto> updateById(@PathVariable long id,
                                              @RequestBody UserUpdationDto updationDto) {
        if(updationDto.username() == null && updationDto.email() == null && updationDto.password() == null)
            throw new RuntimeException();

        return ResponseEntity
                .status(202)
                .body(userService.updateUser(id, updationDto));
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> selfUpdate(@RequestBody UserUpdationDto updationDto,
                                              Authentication authentication) {
        if(updationDto.username() == null && updationDto.email() == null && updationDto.password() == null)
            throw new RuntimeException();

        var username = authentication.getName();
        return ResponseEntity
                .status(202)
                .body(userService.updateUser(username, updationDto));
    }
}
