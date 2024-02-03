package org.tutorial.yy.langchain.demo.aiservice.extractor;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.tutorial.yy.langchain.demo.aiservice.LangChainBase;

/**
 * @author yyHuangfu
 * @create 2024/1/29
 * @description
 */
public class HelloExtractor extends LangChainBase {
    public static void main(String[] args) {
        ChatLanguageModel model = getModel();
        PersonExtractor extractor = AiServices.create(PersonExtractor.class, model);

        String text = "In 1968, amidst the fading echoes of Independence Day, "
                + "a child named John arrived under the calm evening sky. "
                + "This newborn, bearing the surname Doe, marked the start of a new journey.";

        Person person = extractor.extractPersonFrom(text);
        // Person { firstName = "John", lastName = "Doe", birthDate = 1968-07-04 }
        System.out.println(person);
    }
}
