package com.itransition.controllers;


import com.itransition.entity.CollectionDB;
import com.itransition.entity.Item;
import com.itransition.entity.Role;
import com.itransition.entity.User;
import com.itransition.service.CollectionService;
import com.itransition.service.ItemService;
import com.itransition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private CollectionService collectionService;


    @GetMapping("/admin")
    public String getAdminPage(Model model) {                                                                                                                                        //модель это передача чегото в html, model.addAttribute("key" , user.getName)
        model.addAttribute("isUsers", userService.findAll());
        return "admin";                                           //html
    }

    @PostMapping(value = "/admin", params = "action=setAdmin")
    public String setRole(@RequestParam ("id") Long id) {
        userService.changeRole(id);
        return "redirect:/admin";
    }
}
