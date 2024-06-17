package com.example.whatsapp.controller;

import com.example.whatsapp.service.WhatsappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhatsappController {

    @Autowired
    private WhatsappService whatsappService;

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody WhatsappRequest whatsappRequest) {
        try {
            whatsappService.sendMessage(whatsappRequest);
            return "Message sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send message";
        }
    }
}
