package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSpringController {
    /*@GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }*/

    // handle requests of the form /hello?name=LaunchCode
    @GetMapping("hello2")
    @ResponseBody
    public String helloWithQueryParameter(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // handle requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithNameInPath(@PathVariable String name) {
        return "Hello path name, " + name + "!";
    }

    @GetMapping
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                    "<body>" +
                        "<form method = 'get' action = '/hello2'>" +
                            "<input type = 'text' name = 'name' />" +
                            "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                    "</body>" +
                "</html>";
        return html;
    }

    @GetMapping("hello")
    @ResponseBody
    public String hello(@RequestParam String coder) {
        return "Hello, form " + coder + "!";
    }






}
