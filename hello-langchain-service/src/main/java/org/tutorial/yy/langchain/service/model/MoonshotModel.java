package org.tutorial.yy.langchain.service.model;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.output.Response;

import java.util.List;

/**
 * @author yyHuangfu
 * @create 2024/5/30
 * @description
 */
public class MoonshotModel implements ChatLanguageModel {

    @Override
    public Response<AiMessage> generate(List<ChatMessage> list) {
        return null;
    }
}
