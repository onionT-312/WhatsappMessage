package com.example.whatsapp.service;

import com.example.whatsapp.controller.WhatsappRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WhatsappService {
    public void sendMessage(WhatsappRequest whatsappRequest) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonInputString = objectMapper.writeValueAsString(whatsappRequest);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(whatsappRequest.getWhatsappURL()))                                                     // read URL Whatsapp
                    .header("Authorization", "Bearer " + whatsappRequest.getWhatsappToken())                // read Token Whatsapp
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int responseCode = response.statusCode();
            String responseBody = response.body();

            if (responseCode != 200) {
                throw new IOException("Failed to send message, response code: " + responseCode + ", response message: " + responseBody);
            }//kiem tra status

            System.out.println("Message sent successfully: " + responseBody);
        } catch (URISyntaxException | IOException |InterruptedException e) {
            e.printStackTrace();
        }
    }
}
