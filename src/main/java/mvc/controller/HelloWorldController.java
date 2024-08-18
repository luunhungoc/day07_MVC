package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greeting(@RequestParam(name = "person") String person,
                           @RequestParam(name = "country", required = false, defaultValue = "Vietnam") String country, Model model) {
        model.addAttribute("personName", person);
        model.addAttribute("country", country);
        return "helloWorld/greeting";
    }

    @RequestMapping("hello/{person}/{country}")
    public String greeting2(@PathVariable("person") String person,
                            @PathVariable("country") String country,
                            Model model) {
        model.addAttribute("personName", person);
        model.addAttribute("country", country);
        return "helloWorld/greeting";

    }
}
