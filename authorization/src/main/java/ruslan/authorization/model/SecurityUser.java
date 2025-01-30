package ruslan.authorization.model;

import ruslan.authorization.persistence.entities.User;

public class SecurityUser /*implements UserDetails*/ {

    private final User user;

    public SecurityUser(User user) {
        this.user = user;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(() -> user.getRole().toString());
//    }

//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getId();
//    }
}
