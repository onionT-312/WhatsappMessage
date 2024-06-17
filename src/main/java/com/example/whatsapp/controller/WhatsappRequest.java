package com.example.whatsapp.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WhatsappRequest {

    private String messaging_product;
    private String to;
    private String whatsappURL;
    private String whatsappToken;
    private String type;
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
