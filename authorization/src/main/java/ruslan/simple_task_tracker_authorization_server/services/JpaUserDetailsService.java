package ruslan.simple_task_tracker_authorization_server.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ruslan.simple_task_tracker_authorization_server.model.SecurityUser;
import ruslan.simple_task_tracker_authorization_server.persistence.repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUser(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("No user with such username"));
    }
}
