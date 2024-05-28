package org.tutorial.yy.langchain.demo.rag.easy;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.tutorial.yy.langchain.demo.rag.shared.Assistant;

import java.util.List;

import static dev.langchain4j.data.document.loader.FileSystemDocumentLoader.loadDocuments;
import static org.tutorial.yy.langchain.demo.aiservice.LangChainBase.getModel;
import static org.tutorial.yy.langchain.demo.rag.shared.Utils.*;

/**
 * @author yyHuangfu
 * @create 2024/5/9
 * @description
 */
public class EasyRAG {

    public static void main(String[] args) {
        List<Document> documents = loadDocuments(toPath("rag_doc/"), glob("*.md"));
        ChatLanguageModel model = getModel();

        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .contentRetriever(createContentRetriever(documents))
                .build();
        startConversationWith(assistant);
    }

    private static ContentRetriever createContentRetriever(List<Document> documents) {

        // Here, we create and empty in-memory store for our documents and their embeddings.
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();

        // Here, we are ingesting our documents into the store.
        // Under the hood, a lot of "magic" is happening, but we can ignore it for now.
        EmbeddingStoreIngestor.ingest(documents, embeddingStore);

        // Lastly, let's create a content retriever from an embedding store.
        return EmbeddingStoreContentRetriever.from(embeddingStore);
    }
}
