package org.tutorial.yy.langchain.demo;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.tutorial.yy.langchain.service.ApiKeys;

public class HelloLangChain {

    public static void main(String[] args) {

        // Create an instance of a model
        OpenAiChatModel model = OpenAiChatModel
                .withApiKey(ApiKeys.OPENAI_API_KEY);

        // Start interacting
        AiMessage answer = model.generate(
                UserMessage.from("Hello world!")
        ).content();
        // Hello! How can I assist you today?
        System.out.println(answer.text());
    }
}
