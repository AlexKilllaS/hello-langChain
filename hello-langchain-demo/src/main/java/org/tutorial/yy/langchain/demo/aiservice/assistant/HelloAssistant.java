package org.tutorial.yy.langchain.demo.aiservice.assistant;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.tutorial.yy.langchain.demo.aiservice.extractor.Person;

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
        Person person = assistant.intro("介绍一下Kobe Bryant");
        Integer num = assistant.count("计算字符数：adbcsd");

        System.out.println(answer);
        System.out.println(person);
        System.out.println(num);
    }
}
