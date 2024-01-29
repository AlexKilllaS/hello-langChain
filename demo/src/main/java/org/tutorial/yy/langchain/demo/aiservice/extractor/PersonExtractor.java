package org.tutorial.yy.langchain.demo.aiservice.extractor;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

/**
 * @author yyHuangfu
 * @create 2024/1/29
 * @description
 */
public interface PersonExtractor {
    @UserMessage("Extract information about a person from {{text}}")
    Person extractPersonFrom(@V("text") String text);
}
