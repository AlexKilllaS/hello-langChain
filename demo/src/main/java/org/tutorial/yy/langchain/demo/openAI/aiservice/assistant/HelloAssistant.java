package org.tutorial.yy.langchain.demo.openAI.aiservice.assistant;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.tutorial.yy.langchain.service.LangModel;

/**
 * @author yyHuangfu
 * @create 2024/1/29
 * @description
 */
public class HelloAssistant {
    public static void main(String[] args) {
        ChatLanguageModel model = LangModel.getOpenAIModel();

        Assistant assistant = AiServices.create(Assistant.class, model);
        String answer = assistant.chat("Hello");

        System.out.println(answer);
    }
}
