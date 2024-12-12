package test2;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

import java.util.Map;

public class test2 {

    public static void main(String[] args) {
        String apiKey = System.getenv("GEMINI_API_KEY");
        // Création du modèle avec le builder
        ChatLanguageModel model = GoogleAiGeminiChatModel.builder()
                .modelName("gemini-1.5-flash")
                .temperature(0.7)
                .apiKey(System.getenv("GEMINI_API_KEY"))  // La clé API doit être définie comme variable d'environnement
                .build();

        String texteATraduire = "Il fait beau aujourd'hui.";

        Prompt prompt = PromptTemplate
                .from("Traduire en {{langue}} ce texte : {{text}}")
                .apply(Map.of(
                        "langue", "anglais",
                        "text", texteATraduire
                ));

        String reponse = model.generate(prompt.text());
        System.out.println(reponse);
    }
}
