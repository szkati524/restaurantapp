package com.restaurantApp.restaurantApp.Controller;



import com.restaurantApp.restaurantApp.resources.Client;
import com.restaurantApp.restaurantApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/clients")
public class RestaurantController {

    private ClientService clientService;

    @Autowired
    public RestaurantController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/start")
    public String mainView(Model model){
        model.addAttribute("main","Witamy");
        return "main";
    }
    @GetMapping("/menu")
    public String menuView(Model model){
        model.addAttribute("menu","Menu");
        return "menu";
    }
    @GetMapping("/opinions")
    public String comments(Model model){

        model.addAttribute("opinions","Opinie");

        return "opinions";
    }



    }



