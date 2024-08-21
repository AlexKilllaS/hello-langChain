package org.tutorial.yy.langchain.demo;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.model.qianfan.QianfanStreamingChatModel;
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

    public static QianfanStreamingChatModel getStreamingModel() {
        QianfanStreamingChatModel model = LangModel.getStreamModel();
        System.out.printf(">>>>>>>> Big Model start : OpenAiStreamingChatModel\n");
        return model;
    }


}
