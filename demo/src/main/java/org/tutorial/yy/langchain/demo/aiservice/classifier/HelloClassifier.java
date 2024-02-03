package org.tutorial.yy.langchain.demo.aiservice.classifier;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;

import static org.tutorial.yy.langchain.demo.aiservice.LangChainBase.getModel;

/**
 * @author yyHuangfu
 * @create 2024/1/29
 * @description
 */
public class HelloClassifier {
    public static void main(String[] args) {
        ChatLanguageModel model = getModel();
        SentimentAnalyzer sentimentAnalyzer = AiServices.create(SentimentAnalyzer.class, model);

        Sentiment sentiment = sentimentAnalyzer.analyzeSentimentOf("It is good!");
        // POSITIVE
        boolean positive = sentimentAnalyzer.isPositive("It is bad!");
        // false
        System.out.println(sentiment);
        System.out.println(positive);
    }
}
