package com.restaurantApp.restaurantApp.resources;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class Client {
    private String name;
    private String surname;
    private String email;
    private long phoneNumber;
    private LocalTime time;
    private List<Dishes> dishesAndBill;

    public Client(String name, String surname, String email,long phoneNumber, String time, List<Dishes> dishesAndBill) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.time = LocalTime.parse(time);  // Zamiana String na LocalTime
        this.dishesAndBill = dishesAndBill;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}

