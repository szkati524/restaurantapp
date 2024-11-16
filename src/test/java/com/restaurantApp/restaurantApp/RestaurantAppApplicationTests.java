package com.restaurantApp.restaurantApp;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.restaurantApp.restaurantApp.resources.Client;
import com.restaurantApp.restaurantApp.resources.Dishes;
import com.restaurantApp.restaurantApp.service.ClientService;
import com.restaurantApp.restaurantApp.service.DishesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@SpringBootTest
class RestaurantAppApplicationTests {
	private ClientService clientService;


	@BeforeEach
	public void CreateParametrs() {

		clientService = new ClientService();




	}

	@Test
	void contextLoads() {
	}


	@Test
	public void ifAddClientCorrect() {
		Dishes pizza = new Dishes("Pizza",20.50f);
		Dishes chips = new Dishes("Frytki",10.00f);
		Client client = new Client("Adam", "Kowalski","a@a.pl", 123456789, "11:30",Arrays.asList(pizza,chips));

		clientService.addClient(client);
			assertTrue(clientService.showClient().contains(client));
	}
	@Test
	public void nameOfClientIsEmptyAndShouldReturnException() {

		Dishes pizza = new Dishes("Pizza", 20.50f);
		Dishes chips = new Dishes("Frytki", 10.00f);


		Client client = new Client("", "Michalski","a@a.pl", 123456789, "11:30", Arrays.asList(pizza, chips));


		assertThrows(IllegalArgumentException.class, () -> {
			clientService.addClient(client);
		});
	}
	@Test
	public void nameOfClientContainsNumberAndSpecialChars() {
		Dishes pizza = new Dishes("Pizza", 20.50f);
		Dishes chips = new Dishes("Frytki", 10.00f);


		Client client = new Client("jan3", "Michalski", "a@a.pl", 123456789, "11:30", Arrays.asList(pizza, chips));
		assertThrows(IllegalArgumentException.class, () -> {
			clientService.addClient(client);
		});
	}

	   @Test
	   public void phoneNumberOfClientisTooShort(){
		   Dishes pizza = new Dishes("Pizza", 20.50f);
		   Dishes chips = new Dishes("Frytki", 10.00f);
		   Client client = new Client("Jan","Kowalski","jan@a.pl",12345,"11:30",Arrays.asList(pizza,chips));
		   assertThrows(IllegalArgumentException.class, () ->{
			   clientService.addClient(client);
		   });
	   }
	   @Test
	public void emailOfClientIsWrong(){
		Dishes pizza = new Dishes("Pizza",20.50f);
		Dishes chips = new Dishes("Frytki",10.00f);
		   Client client = new Client("Jan","Kowalski","jana.pl",123456789,"11:30",Arrays.asList(pizza,chips));
		   assertThrows(IllegalArgumentException.class, () ->{
			   clientService.addClient(client);
		   });
	   }
	   @Test
	public void addClientButDishesIsEmptyMethodShouldReturnString(){
		   Dishes pizza = new Dishes("Pizza",20.50f);
		   Dishes chips = new Dishes("Frytki",10.00f);
		   Client client = new Client("Jan","Kowalski","jan@a.pl",123456789,"11:30",Arrays.asList());
		   clientService.addClient(client);
		   assertTrue(clientService.showClient().contains(client));
	}

     @Test
	public void timeOfClientIsWrong(){
		 Dishes pizza = new Dishes("Pizza",20.50f);
		 Dishes chips = new Dishes("Frytki",10.00f);
		 assertThrows(DateTimeException.class, () -> {
		 LocalTime time = LocalTime.of(26,30);
		 Client client = new Client("Jan","Kowalski","jan@a.pl",123456789,time,Arrays.asList(pizza,chips));

			 clientService.addClient(client);
		 });
	 }
	 @Test
	public void numberOfClientIsNullOrEmpty(){
		 Dishes pizza = new Dishes("Pizza",20.50f);
		 Dishes chips = new Dishes("Frytki",10.00f);
		 Client client = new Client("Jan","Kowalski","jan@a.pl",0,"11:30",Arrays.asList());
		 assertThrows(IllegalArgumentException.class, () -> {
			 clientService.addClient(client);
		 });
	 }

	}



