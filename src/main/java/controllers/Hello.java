package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Hello {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(ModelMap modelMap) {
        modelMap.addAttribute("greeting", "Welcome to Web Store!");
        modelMap.addAttribute("tagline", "The one and only amazing store");
        return "hello";
    }
}
