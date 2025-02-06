package ruslan.user_client_service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ruslan.common.persistence.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
}
