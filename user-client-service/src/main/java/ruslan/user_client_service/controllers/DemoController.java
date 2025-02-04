package ruslan.user_client_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/demo1")
    public String demo1() {
        return "Demo1";
    }

    @PreAuthorize("hasRole('root')")
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
