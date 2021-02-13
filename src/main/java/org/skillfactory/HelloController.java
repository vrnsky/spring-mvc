package org.skillfactory;

import org.skillfactory.dto.StudentData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/student", method = RequestMethod.GET) //Можно поменять на @GetMapping("/student")
    @ResponseBody
    public String helloStudent() {
        return "Hello, student!";
    }

    @RequestMapping(value  = "/greetings/{name}")
    public String greetingsByName(@PathVariable String name) {
        return "Hello, " + name;
    }

    @RequestMapping(value = "/student/submit", method = RequestMethod.POST)
    public String giveMeFeedbackAboutGrade(@RequestBody StudentData studentData) {
        return "You are greate with your grade " + studentData.getGrade();
    }
}
