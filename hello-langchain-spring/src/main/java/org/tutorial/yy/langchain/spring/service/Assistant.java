package org.tutorial.yy.langchain.spring.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

/**
 * @author yyHuangfu
 * @create 2024/5/28
 * @description
 */
@AiService
public interface Assistant {

    @SystemMessage("You are a {{characteristic}} assistant")
    String chat(@UserMessage String userMessage, @V("characteristic") String characteristic);
}
