package org.tutorial.yy.langchain.demo.aiservice.memory;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

/**
 * @author yyHuangfu
 * @create 2024/2/3
 * @description
 */
public interface Assistant {
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);
}
