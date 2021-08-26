package com.itransition.controllers;

import com.itransition.entity.CollectionDB;
import com.itransition.entity.Item;
import com.itransition.service.CollectionService;
import com.itransition.service.ItemService;
import com.itransition.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private CollectionService collectionService;

    @GetMapping("/main")
    public String goToMain(@ModelAttribute("item") Item item,
                           @ModelAttribute("collection") CollectionDB collectionDB, Model model) {//модель это передача чегото в html, model.addAttribute("key" , user.getName)

        model.addAttribute("collections", collectionService.findAll());
        model.addAttribute("user", userService.getAuthenticationUser());
        model.addAttribute("isAuthentication", userService.isAuthentication());
        return "main";
    }

}
