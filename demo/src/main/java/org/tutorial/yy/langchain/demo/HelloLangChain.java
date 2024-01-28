package org.tutorial.yy.langchain.demo;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.tutorial.yy.langchain.service.ApiKeys;


/**
 * @author yyHuangfu
 * @create 2024/1/28
 */

public class HelloLangChain {

    public static void main(String[] args) {

        // Create an instance of a model
        ChatLanguageModel model = OpenAiChatModel.withApiKey(ApiKeys.OPENAI_API_KEY);

        // Start interacting
        String answer = model.generate("你好我是皇甫一宇，你能做个自我介绍吗？");

        System.out.println(answer);
    }
}
