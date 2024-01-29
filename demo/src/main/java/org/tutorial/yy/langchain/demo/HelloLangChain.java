package org.tutorial.yy.langchain.demo;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.tutorial.yy.langchain.service.LangModel;


/**
 * @author yyHuangfu
 * @create 2024/1/28
 */

public class HelloLangChain {

    public static void main(String[] args) {

        // Create an instance of a model
        ChatLanguageModel model = LangModel.getChatModel();

        // Start interacting
        String answer = model.generate("你好，你能做个自我介绍吗？");

        System.out.println(answer);
    }
}
