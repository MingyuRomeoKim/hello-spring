package hello.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        return "Hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name",required = false) String name, Model model)
    {
        model.addAttribute("name",name);
        return "hello-template";
    }
}
