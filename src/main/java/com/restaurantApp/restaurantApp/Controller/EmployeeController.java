//package com.restaurantApp.restaurantApp.Controller;
//
//import com.restaurantApp.restaurantApp.resources.Client;
//import com.restaurantApp.restaurantApp.service.ClientService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class EmployeeController {

////    @Autowired
//    private ClientService clientService;
//
//    @Autowired
//    public EmployeeController(ClientService clientService) {
//        this.clientService = clientService;
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<String> addClient(@RequestBody Client client) {
//        try {
//            clientService.addClient(client);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Dodano klienta pomyślnie");
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//}
//
