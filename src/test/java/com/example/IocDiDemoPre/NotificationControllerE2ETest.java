package com.example.IocDiDemoPre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NotificationControllerE2ETest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNotifyDynamicE2E() throws Exception {
        mockMvc.perform(get("/notify/dynamic")
                        .param("message", "Real Message")
                        .param("type", "email"))
                .andExpect(status().isOk())
                .andExpect(content().string("Notification sent using email"));
    }
}
