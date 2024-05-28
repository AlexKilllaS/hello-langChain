package org.tutorial.yy.langchain.demo.aiservice.classifier;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.AllMiniLmL6V2EmbeddingModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingMatch;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import java.util.List;

/**
 * @author yyHuangfu
 * @create 2024/2/9
 * @description
 */
public class HelloEmbeddingExample {
    public static void main(String[] args) {
        // EmbeddingModel: Represents a model that can
        // convert a given text into an embedding (vector representation of the text).

        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
        EmbeddingModel embeddingModel = new AllMiniLmL6V2EmbeddingModel();

        TextSegment segment1 = TextSegment.from("I like football.");
        Embedding embedding1 = embeddingModel.embed(segment1).content();
        embeddingStore.add(embedding1, segment1);

        TextSegment segment2 = TextSegment.from("The weather is good today.");
        Embedding embedding2 = embeddingModel.embed(segment2).content();
        embeddingStore.add(embedding2, segment2);

        Embedding queryEmbedding = embeddingModel.embed("What is your favourite sport?").content();
        List<EmbeddingMatch<TextSegment>> relevant = embeddingStore.findRelevant(queryEmbedding, 1);
        EmbeddingMatch<TextSegment> embeddingMatch = relevant.get(0);

        System.out.println(embeddingMatch.score()); // 0.8144288515898701
        System.out.println(embeddingMatch.embedded().text()); // I like football.

        // In-memory embedding store can be serialized and deserialized to/from JSON
        // String serializedStore = embeddingStore.serializeToJson();
        // InMemoryEmbeddingStore<TextSegment> deserializedStore = InMemoryEmbeddingStore.fromJson(serializedStore);

        // In-memory embedding store can be serialized and deserialized to/from file
        // String filePath = "/home/me/embedding.store";
        // embeddingStore.serializeToFile(filePath);
        // InMemoryEmbeddingStore<TextSegment> deserializedStore = InMemoryEmbeddingStore.fromFile(filePath);
    }
}
