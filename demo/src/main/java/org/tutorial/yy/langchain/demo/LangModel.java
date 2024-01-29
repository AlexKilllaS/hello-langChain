package org.tutorial.yy.langchain.demo;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.tutorial.yy.langchain.service.ApiKeys;

/**
 * @author yyHuangfu
 * @create 2024/1/29
 * @description
 */
public class LangModel {
    public static ChatLanguageModel getChatModel() {
        return OpenAiChatModel.withApiKey(ApiKeys.OPENAI_API_KEY);
    }
}
