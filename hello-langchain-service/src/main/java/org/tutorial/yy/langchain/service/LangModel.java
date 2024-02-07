package org.tutorial.yy.langchain.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.model.qianfan.QianfanChatModel;
import dev.langchain4j.model.qianfan.QianfanStreamingChatModel;

import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_3_5_TURBO;
import static java.time.Duration.ofSeconds;

/**
 * @author yyHuangfu
 * @create 2024/1/29
 * @description
 */
public class LangModel {

    public static ChatLanguageModel getModel(String modelName) {
        switch (modelName) {
            case "qian_fan":
                return getQianFanModel();
            case "open_ai":
                return getOpenAIModel();
            default:
                throw new RuntimeException("unKnown model name, plz check your config");
        }
    }

    private static ChatLanguageModel getOpenAIModel() {
        return OpenAiChatModel.builder()
                .apiKey(ApiKeys.OPENAI_API_KEY)
                .modelName(GPT_3_5_TURBO)
                .temperature(0.6)
                .timeout(ofSeconds(60))
                .logRequests(true)
                .logResponses(true)
                .build();
    }

    public static QianfanStreamingChatModel getStreamModel() {
        return QianfanStreamingChatModel.builder()
                .apiKey("bUyk2k96KQ2gG1ZQ8TB8t3cd")
                .secretKey(ApiKeys.QIAN_FAN_API_KEY)
                .modelName("Yi-34B-Chat")
                .build();
    }

    private static QianfanChatModel getQianFanModel() {
        return QianfanChatModel.builder()
                .apiKey("bUyk2k96KQ2gG1ZQ8TB8t3cd")
                .secretKey(ApiKeys.QIAN_FAN_API_KEY)
                .modelName("Yi-34B-Chat")
                .build();
    }
}
