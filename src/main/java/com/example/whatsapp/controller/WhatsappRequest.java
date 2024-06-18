package com.example.whatsapp.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WhatsappRequest {

    private String messaging_product = "whatsapp";
    private String whatsappURL = "YOUR_WHATSAPP_URL";
    private String whatsappToken = "YOUR_WHATSAPP_TOKEN";
    private String type = "template";
    
    private String to;
    private Template template;


    @Getter
    @Setter
    public static class Template {
        private String name;
        private Language language;

        @Getter
        @Setter
        public static class Language {
            private String code;
        }
    }

}
