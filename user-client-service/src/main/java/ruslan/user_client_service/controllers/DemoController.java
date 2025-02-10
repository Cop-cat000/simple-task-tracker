package ruslan.user_client_service.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/demo1")
    public String demo1(Authentication authentication, HttpServletRequest request) {
        System.out.println(authentication.getAuthorities());

        System.out.println(request.isUserInRole("'root'"));
        System.out.println(request.isUserInRole("'ROOT'"));
        System.out.println(request.isUserInRole("'ROLE_ROOT'"));
        return "Demo1";
    }

//    @PreAuthorize("hasRole('root')")
    @PreAuthorize("hasAuthority('ROOT')")
    @GetMapping("/demo2")
    public String demo2() {
        return "Demo2";
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/demo3")
    public String demo3() {
        return "Demo3";
    }

    @PreAuthorize("hasAnyRole('root', 'admin')")
    @GetMapping("/demo4")
    public String demo4() {
        return "Demo4";
    }
}
