package com.example.IocDiDemoPre;

import com.example.controller.NotificationController;
import com.example.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotificationController.class)
public class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean(name = "emailService")
    private NotificationService emailService;

    @Test
    public void testNotifyDynamicWithEmail() throws Exception {
        Mockito.doNothing().when(emailService).send("Test Message");

        mockMvc.perform(get("/notify/dynamic")
                        .param("message", "Test Message")
                        .param("type", "email"))
                .andExpect(status().isOk())
                .andExpect(content().string("Notification sent using email"));
    }
}
