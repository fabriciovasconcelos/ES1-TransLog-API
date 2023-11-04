package unirio.es1.TransLogAPI.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0")
public class IndexController {
    private static final String home = "Translog API Test";

    @GetMapping
    public String Home() {
        return home;
    }
}
