package org.tutorial.yy.langchain.demo.aiservice;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.tutorial.yy.langchain.service.LangModel;
import org.tutorial.yy.langchain.service.util.Configs;

/**
 * LLM model provider
 *
 * @author yyHuangfu
 * @create 2024/1/28
 */

public class LangChainBase {
    private static final String MODEL_NAME = Configs.get("model_provider");

    public static ChatLanguageModel getModel() {
        ChatLanguageModel model = LangModel.getModel(MODEL_NAME);
        System.out.printf(">>>>>>>> Big Model start : %s\n", model.getClass().getSimpleName());
        return model;
    }


}
