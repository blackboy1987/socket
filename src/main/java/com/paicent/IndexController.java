package com.paicent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/index1")
    public String index1(ModelMap model,Long id){
        model.addAttribute("id",id);
        return "index1";
    }

    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }

    @GetMapping("/index3")
    public String index3(ModelMap model,Long id){
        model.addAttribute("id",id);
        return "index3";
    }


    @GetMapping("/index4")
    public String index4(ModelMap model,Long id){
        model.addAttribute("id",id);
        return "index4";
    }
}
