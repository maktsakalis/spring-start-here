package com.springstarthere.spinginitializrch7.controllers;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @GetMapping("/hello")
  public String sayHelloRequestParam(@RequestParam String name) {
    System.out.println("Hello " + name + " from console!");
    return "home.html";
  }

  @RequestMapping("/home")
  public String homeWithRequestParam(@RequestParam String color, Model page) {
    page.addAttribute("username", "Makis");
    page.addAttribute("color", color);
    return "home.html";
  }


  @RequestMapping("/home/{color}")
  public String homeWithPathVariable(@PathVariable String color, Model page) {
    page.addAttribute("username", "Makis");
    page.addAttribute("color", color);
    return "home.html";
  }
}
