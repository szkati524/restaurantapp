package com.restaurantApp.restaurantApp.service;

import com.restaurantApp.restaurantApp.resources.Client;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.spi.DateFormatProvider;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor

public class ClientService {
    @Autowired
    private Client client = new Client();


    private List<Client> clients = new ArrayList<>();


    public void addClient(Client client) {
        if (client.getName() == null || client.getName().isEmpty() || !client.getName().matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Imię nie moze być puste");
        }
        String phoneNumber = String.valueOf(client.getPhoneNumber());
        if (phoneNumber == null || phoneNumber.length() < 9 || !phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Coś poszło nie tak");
        }
        if (client.getDishesAndBill().isEmpty()) {
            System.out.println("Zamówi na miejscu");
        } if (client.getEmail() == null || client.getEmail().isEmpty() || !client.getEmail().contains("@")){
            throw new IllegalArgumentException("Email jest nieprawidłowy");
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

       clients.add(client);
    }

    public List<Client> showClient() {

        return clients;
    }

    public Optional<Client> findByNumber(long phoneNumber) {
        return clients.stream()
                .filter(client -> client.getPhoneNumber() == phoneNumber)
                .findFirst();
    }

    public boolean deleteClientByName(String name) {
        return clients.removeIf(client -> client.getName().equalsIgnoreCase(name));

    }


    public List<String> getClientOrder() {
        List<String> collect = clients.stream().filter(client -> !client.getDishesAndBill().isEmpty())
                .map(client1 -> {
                    LocalTime hour = client.getTime();
                    LocalTime minute = client.getTime();
                    String formattedTime = String.format("%02d:%02d", hour, minute);

                    return "Na godzinę : " + formattedTime + "Zostały zamówione posiłki " + client.getDishesAndBill();
                })
                .collect(Collectors.toList());



        return collect;
    }






public List<Client> findClientByNameAndShowAllInformation(String name){
    return clients.stream()
            .filter(client -> client.getName().equalsIgnoreCase(name))
            .collect(Collectors.toList());
}
public List<Client> findClientByMeals(String name ) {
    return clients.stream()
            .filter(clientWithDishes ->
                    clientWithDishes.getDishesAndBill().stream()
                            .anyMatch(dish -> dish.getNameDishes().equalsIgnoreCase(name))
            )
            .collect(Collectors.toList());
}
}



