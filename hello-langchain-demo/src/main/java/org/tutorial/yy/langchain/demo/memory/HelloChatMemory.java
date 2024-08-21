package org.tutorial.yy.langchain.demo.memory;

import dev.langchain4j.chain.ConversationalChain;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.tutorial.yy.langchain.demo.LangChainBase;

import java.io.IOException;

import static dev.langchain4j.data.message.UserMessage.userMessage;

/**
 * @author yyHuangfu
 * @create 2024/2/3
 * @description
 */
public class HelloChatMemory extends LangChainBase {
    public static void main(String[] args) throws IOException {

        ConversationalChain chain = ConversationalChain.builder()
                .chatLanguageModel(getModel())
                .chatMemory(getCustomMemory())
                .build();

        String answerWithName = chain.execute("can u introduce yourself?"); // 你能介绍一下你自己吗？
        System.out.println(answerWithName);
        String answerInCN = chain.execute("in chinese plz"); // 请用中文说
        System.out.println(answerInCN);
    }

    public static ChatMemory getCustomMemory() {
        // yiyu robot
        ChatMemory chatMemory = MessageWindowChatMemory.builder()
                .maxMessages(10)
                .build();
        chatMemory.add(userMessage("you are the human called Alex HF, u also called yiyu"));
        chatMemory.add(userMessage("u like programming, reading and any sports"));
        chatMemory.add(userMessage("u can speak Chinese and English"));
        return chatMemory;
    }
}
