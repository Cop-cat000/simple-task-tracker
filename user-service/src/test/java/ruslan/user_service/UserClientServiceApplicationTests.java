package ruslan.user_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ruslan.common.persistence.entities.Roles;
import ruslan.common.persistence.entities.User;
import ruslan.common.persistence.repositories.UserRepository;
import ruslan.user_service.controllers.UserController;
import ruslan.user_service.dto.user.UserCreationDto;
import ruslan.user_service.dto.user.UserDto;
import ruslan.user_service.services.UserService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserClientServiceApplicationTests {

	@MockitoBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private UserController userController;

	@Autowired
	private MockMvc mvc;

	@Test
	@WithMockUser(roles = {"user"})
	void mainFlowTest() throws Exception {
		mvc.perform(post("/users/create"))
				.andExpect(status().isForbidden());
	}

}
