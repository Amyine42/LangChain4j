package test3;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.googleai.GoogleAiEmbeddingModel;
import dev.langchain4j.store.embedding.CosineSimilarity;

import java.time.Duration;

public class test3 {
    public static void main(String[] args) {
        EmbeddingModel embeddingModel = GoogleAiEmbeddingModel.builder()
                .modelName("text-embedding-004")
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .maxRetries(2)
                .taskType(GoogleAiEmbeddingModel.TaskType.SEMANTIC_SIMILARITY)
                .titleMetadataKey("")
                .outputDimensionality(300)
                .timeout(Duration.ofSeconds(15))
                .logRequestsAndResponses(true)
                .build();


        String text1 = "cat";
        String text2 = "dog";

        Embedding embeddingText1 = embeddingModel.embed(text1).content();
        Embedding embeddingText2 = embeddingModel.embed(text2).content();

        System.out.println("cosine similarity between text1:"+text1+" and text2:"+text2+" is : " + CosineSimilarity.between(embeddingText1, embeddingText2));
    }
}
