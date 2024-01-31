package org.tutorial.yy.langchain.demo.qianfan;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.tutorial.yy.langchain.service.LangModel;

/**
 * @author yyHuangfu
 * @create 2024/1/31
 */
public class HelloQianFan {
    public static void main(String[] args) {

        // Create an instance of a model
        ChatLanguageModel model = LangModel.getQianFanModel();

        // Start interacting
        String answer = model.generate("你好，你能做个自我介绍吗？");

        System.out.println(answer);
    }
}
