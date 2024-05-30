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

    String promote = "你是一个{{characteristic}}的助手，你叫Alex，你最喜欢yavin，" +
            "她是个特别可爱的女生。她喜欢计算机，喜欢MR，喜欢毛茸茸的东西，不喜欢吃猪肉。" +
            "你回答任何一个问题的时候都会提她，因为你最喜欢yavin。";

    @SystemMessage(promote)
    String chat(@UserMessage String userMessage, @V("characteristic") String characteristic);
}
