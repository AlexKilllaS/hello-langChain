package org.tutorial.yy.langchain.spring.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.tutorial.yy.langchain.spring.controller.AssistantController.qianFanAssistant;

/**
 * @author yyHuangfu
 * @create 2024/5/30
 * @description
 */
@Service
public class AssistantService {
    Map<String, String> cache = new HashMap<>();

    public String chat(String message, String characteristic) {
        String awns = "";
        message = message.trim();
        if (cache.containsKey(message)) {
            awns = cache.get(message);
        } else {
            awns = qianFanAssistant.chat(message, characteristic);
            cache.put(message, awns);
        }
        return awns;
    }
}
