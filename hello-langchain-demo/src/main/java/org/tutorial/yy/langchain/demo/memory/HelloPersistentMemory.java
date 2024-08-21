package org.tutorial.yy.langchain.demo.memory;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;
import org.tutorial.yy.langchain.service.db.PersistentChatMemoryStore;

import static org.tutorial.yy.langchain.demo.LangChainBase.getModel;

/**
 * @author yyHuangfu
 * @create 2024/2/3
 * @description
 */
public class HelloPersistentMemory {

    public static void main(String[] args) {

        PersistentChatMemoryStore store = new PersistentChatMemoryStore();

        ChatMemoryProvider chatMemoryProvider = memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(10)
                .chatMemoryStore(store)
                .build();

        org.tutorial.yy.langchain.demo.aiservice.memory.Assistant assistant = AiServices.builder(org.tutorial.yy.langchain.demo.aiservice.memory.Assistant.class)
                .chatLanguageModel(getModel())
                .chatMemoryProvider(chatMemoryProvider)
                .build();

        System.out.println(assistant.chat(1, "Hello, my name is Klaus"));
        System.out.println(assistant.chat(2, "Hi, my name is Francine"));

        // Now, comment out the two lines above, uncomment the two lines below, and run again.

        // System.out.println(assistant.chat(1, "What is my name?"));
        // System.out.println(assistant.chat(2, "What is my name?"));
    }

}
