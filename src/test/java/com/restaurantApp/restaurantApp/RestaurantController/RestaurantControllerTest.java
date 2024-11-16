package com.restaurantApp.restaurantApp.RestaurantController;

import com.restaurantApp.restaurantApp.Controller.RestaurantController;
import com.restaurantApp.restaurantApp.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClientService clientService;

    @Test
    public void testCommentsView() throws Exception{
        mockMvc.perform(get("/clients/opinions"))
                .andExpect(status().isOk())
                .andExpect(view().name("opinions"))
                .andExpect(model().attribute("opinions","Opinie"));

    }

}
