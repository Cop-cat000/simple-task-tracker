package ruslan.simple_task_tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @PreAuthorize("hasAnyRole('admin', 'user')")
    @GetMapping("/demo")
    public String demo(Authentication a) {
        System.out.println(a.getName());
        return "Demo";
    }
}
