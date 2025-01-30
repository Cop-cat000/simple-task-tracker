package ruslan.authorization.services;

import ruslan.authorization.persistence.repositories.UserRepository;

//@Service
public class JpaUserDetailsService /*implements UserDetailsService*/ {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.getUser(username)
//                .map(SecurityUser::new)
//                .orElseThrow(() -> new UsernameNotFoundException("No user with such username"));
//    }
}
