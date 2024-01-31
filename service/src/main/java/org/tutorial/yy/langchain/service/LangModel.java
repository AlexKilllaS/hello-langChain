package org.tutorial.yy.langchain.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.qianfan.QianfanChatModel;

/**
 * @author yyHuangfu
 * @create 2024/1/29
 * @description
 */
public class LangModel {
    public static ChatLanguageModel getOpenAIModel() {
        return OpenAiChatModel.withApiKey(ApiKeys.OPENAI_API_KEY);
    }

    public static QianfanChatModel getQianFanModel() {
        return QianfanChatModel.builder()
                .apiKey("bUyk2k96KQ2gG1ZQ8TB8t3cd")
                .secretKey(ApiKeys.QIAN_FAN_API_KEY)
                .modelName("Yi-34B-Chat")
                .build();
    }
}
