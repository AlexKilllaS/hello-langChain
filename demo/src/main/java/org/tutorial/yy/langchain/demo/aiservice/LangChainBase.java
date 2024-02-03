package org.tutorial.yy.langchain.demo.aiservice;


import dev.langchain4j.model.chat.ChatLanguageModel;
import org.tutorial.yy.langchain.service.LangModel;

/**
 * @author yyHuangfu
 * @create 2024/1/28
 */

public class LangChainBase {
    public static ChatLanguageModel getModel() {
        ChatLanguageModel model = LangModel.getOpenAIModel();
        System.out.printf(">>>>>>>> Bid Model start : %s%n", model.getClass().getSimpleName());
        return model;
    }

}
