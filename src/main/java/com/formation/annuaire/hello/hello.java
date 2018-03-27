package com.formation.annuaire.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class hello {
    @GetMapping("/")
    @ResponseBody
    public String index(){
        return "Bonjour tout le monde!!";
    }

    @GetMapping("test")
    public String index2(@RequestParam(required = false) String name, Model model){
        model.addAttribute("name", name);
        return "index";
    }
}
