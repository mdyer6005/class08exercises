package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("hello")
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                    "<body>" +
                        "<form method='post' action='/hello'>" +
                            "<input type = 'text' name = 'name' />" +
                            "<select name='language'>" +
                                "<option value=''>English</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='german'>German</option>" +
                                "<option value='italian'>Italian</option>" +
                            "</select>" +
                            "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                    "</body>" +
                "</html>";
        return html;
    }

    @PostMapping("hello")
    @ResponseBody
    public String greet(@RequestParam String name, String language) {
        return createMessage(name, language);
    }

    public static String createMessage(String name, String language) {
        String greet = "";
        String checkLanguage = language.toLowerCase();
        if (checkLanguage.equals("spanish")) {
            greet = "Hola";
        } else if (checkLanguage.equals("french")) {
            greet = "Bonjour";
        } else if (checkLanguage.equals("german")) {
            greet = "Hallo";
        } else if (checkLanguage.equals("italian")) {
            greet = "Ciao";
        } else {
            greet = "Hello";
        }
        return String.format("%s, %s!",greet,name);
    }






}
