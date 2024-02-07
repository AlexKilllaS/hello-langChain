package org.tutorial.yy.langchain.demo.aiservice.response;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.model.qianfan.QianfanStreamingChatModel;
import org.tutorial.yy.langchain.demo.aiservice.LangChainBase;

public class HelloStreamingResponse extends LangChainBase {

    public static void main(String[] args) {

        QianfanStreamingChatModel model = getStreamingModel();

        String prompt = "Write a short funny poem about developers and null-pointers, 3 lines maximum";

        System.out.println("Nr of chars: " + prompt.length());

        StreamingResponseHandler<AiMessage> responseHandler = new StreamingResponseHandler<AiMessage>() {

            @Override
            public void onNext(String token) {
                System.out.print(token);
            }

            @Override
            public void onComplete(Response<AiMessage> response) {
                System.out.println("\n\nDone streaming");
            }

            @Override
            public void onError(Throwable error) {
                System.out.println("Something went wrong: " + error.getMessage());
            }
        };

        model.generate(prompt, responseHandler);
    }
}