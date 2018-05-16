package com.trennble.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sang on 2017/1/10.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
}
