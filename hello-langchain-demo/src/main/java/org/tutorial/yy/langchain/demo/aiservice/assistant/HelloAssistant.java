package org.tutorial.yy.langchain.demo.aiservice.assistant;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;

import static org.tutorial.yy.langchain.demo.aiservice.LangChainBase.getModel;

/**
 * @author yyHuangfu
 * @create 2024/1/29
 * @description
 */
public class HelloAssistant {
    public static void main(String[] args) {
        ChatLanguageModel model = getModel();

        Assistant assistant = AiServices.create(Assistant.class, model);
        String answer = assistant.chat("你好");

        System.out.println(answer);
    }
}
