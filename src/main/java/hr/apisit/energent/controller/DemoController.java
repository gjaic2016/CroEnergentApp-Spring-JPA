package hr.apisit.energent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demoenergentcontroller")
public class DemoController {

    @GetMapping("message")
    public String getWelcomewMessage() {
        return "hello world test";
    }
}
