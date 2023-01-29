package io.maxiplux.spa.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
class PageController {



    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("test", "employeeServiceImpl.getAllEmployee()");
        return "index";
    }


    @GetMapping("/admin/")
    public String viewHomePageForAdmin(Model model) {
        model.addAttribute("test", "employeeServiceImpl.getAllEmployee()");
        return "index";
    }

    @GetMapping("/view-admin/")
    public String admin(Model model) {
        model.addAttribute("test", "employeeServiceImpl.getAllEmployee()");
        return "admin";
    }
}
