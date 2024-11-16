package com.restaurantApp.restaurantApp.Controller;

import com.restaurantApp.restaurantApp.resources.Client;
import com.restaurantApp.restaurantApp.resources.Dishes;
import com.restaurantApp.restaurantApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {
    @Autowired
private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/add")
    public String showAddClientForm(Model model) {
          model.addAttribute("client",new Client());
        List<Dishes> dishesList = List.of(
                new Dishes("Zupa Pomidorowa",12.99f),
                new Dishes("Rosół z makaronem",14.50f),
                new Dishes("Krem z brokułów",16.0f),
                new Dishes("Sałatka grecka", 18.0f),
                new Dishes("Kotlety schabowe z ziemniakami", 22.9f),
                new Dishes("Filet z kurczaka w sosie śmietanowym", 24.5f),
                new Dishes("Gulasz wołowy z kluskami śląskimi", 28.0f),
                new Dishes("Lasagne bolognese", 26.99f),
                new Dishes("Pizza Margherita", 21.0f),
                new Dishes("Pizza Pepperoni", 24.0f),
                new Dishes("Makaron carbonara", 23.0f),
                new Dishes("Makaron z sosem pesto", 21.5f),
                new Dishes("Ryba po grecku", 27.0f),
                new Dishes("Smażony dorsz z frytkami", 28.5f),
                new Dishes("Tatar wołowy", 30.0f),
                new Dishes("Stek z rostbefu z ziemniakami", 38.0f),
                new Dishes("Krewetki w sosie czosnkowym", 32.0f),
                new Dishes("Sushi zestaw (8 kawałków)", 39.99f),
                new Dishes("Burgery (wołowy, drobiowy, wegetariański)", 26.0f),
                new Dishes("Naleśniki z dżemem i bitą śmietaną", 14.5f)
        );
         model.addAttribute("dishesList", dishesList);
         return "add";


    }
    @PostMapping("/add")
    public String addClient(@ModelAttribute Client client){
        clientService.addClient(client);
        return "redirect:/clients/start";
    }
}
