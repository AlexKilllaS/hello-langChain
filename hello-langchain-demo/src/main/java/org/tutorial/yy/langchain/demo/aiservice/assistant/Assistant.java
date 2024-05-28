package org.tutorial.yy.langchain.demo.aiservice.assistant;

import org.tutorial.yy.langchain.demo.aiservice.extractor.Person;

/**
 * @author yyHuangfu
 * @create 2024/1/29
 * @description
 */
public interface Assistant {

    String chat(String userMessage);

    String count(String characters);

    Person intro(String question);
}

// Hello! How can I assist you today?