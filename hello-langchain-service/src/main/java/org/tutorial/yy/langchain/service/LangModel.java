package org.tutorial.yy.langchain.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.model.qianfan.QianfanChatModel;
import dev.langchain4j.model.qianfan.QianfanStreamingChatModel;

import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_3_5_TURBO;
import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_3_5_TURBO_16K;
import static java.time.Duration.ofSeconds;

/**
 * @author yyHuangfu
 * @create 2024/1/29
 * @description
 */
public class LangModel {

    private static String QIAN_FAN_API_KEY = "9EsW0vKxbr3zU3CBkR9mc6ZN";

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
                .apiKey(QIAN_FAN_API_KEY)
                .secretKey(ApiKeys.QIAN_FAN_API_KEY)
                .temperature(0.6)
                .modelName("Yi-34B-Chat")
                .logRequests(true)
                .logResponses(true)
                .build();
    }

    private static QianfanChatModel getQianFanModel() {
        return QianfanChatModel.builder()
                .apiKey(QIAN_FAN_API_KEY)
                .secretKey(ApiKeys.QIAN_FAN_API_KEY)
                .temperature(0.6)
                .modelName("Yi-34B-Chat")
                .logRequests(true)
                .logResponses(true)
                .build();
    }

//    private static ChatLanguageModel getLlama3Model() {
//        ChatLanguageModel model = OllamaChatModel.builder()
//                .baseUrl(baseUrl())
//                .modelName(MODEL_NAME)
//                .build();
//    }
}
