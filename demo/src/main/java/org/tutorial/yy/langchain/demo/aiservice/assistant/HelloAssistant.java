package org.tutorial.yy.langchain.demo.aiservice.assistant;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.tutorial.yy.langchain.demo.LangModel;
import org.tutorial.yy.langchain.service.ApiKeys;

/**
 * @author yyHuangfu
 * @create 2024/1/29
 * @description
 */
public class HelloAssistant {
    public static void main(String[] args) {
        ChatLanguageModel model = LangModel.getChatModel();

        Assistant assistant = AiServices.create(Assistant.class, model);
        String answer = assistant.chat("Hello");

        System.out.println(answer);
    }
}
