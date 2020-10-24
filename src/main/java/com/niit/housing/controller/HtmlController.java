package com.niit.housing.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping (value = "/")
public class HtmlController {
    @GetMapping()
    @ResponseBody
    public String helloPage() {
        return "hello_page";
    }
}
