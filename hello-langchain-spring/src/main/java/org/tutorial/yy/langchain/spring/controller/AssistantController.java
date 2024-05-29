package org.tutorial.yy.langchain.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tutorial.yy.langchain.spring.service.Assistant;

@RestController
class AssistantController {

    @Autowired
    Assistant assistant;

    @GetMapping("/chat")
    public String assistant(@RequestParam(value = "message", defaultValue = "hello") String message) {
        return assistant.chat(message, "polite");
    }
}