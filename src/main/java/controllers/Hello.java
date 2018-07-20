package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main page of the app.
 *
 * @author vrnsky.
 * @version 0.1
 */
@Controller
public class Hello {

    /**
     * Show some info.
     *
     * @param modelMap map for put a some data.
     * @return user to the hello page.
     */
    @RequestMapping("/welcome")
    public String hello(ModelMap modelMap) {
        modelMap.addAttribute("greeting", "Welcome to Web Store!");
        modelMap.addAttribute("tagline", "The one and only amazing store");
        return "hello";
    }
}
