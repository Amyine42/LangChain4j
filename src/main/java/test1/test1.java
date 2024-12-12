package test1;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class test1 {
    public static void main(String[] args) {
        // Création du modèle avec le builder
        ChatLanguageModel model = GoogleAiGeminiChatModel.builder()
                .modelName("gemini-1.5-flash")
                .temperature(0.7)
                .apiKey(System.getenv("GEMINI_API_KEY"))  // La clé API doit être définie comme variable d'environnement
                .build();

        // Pose d'une question simple
        String question = "Combien de kcal dans une banane?";
        String reponse = model.generate(question);

        // Affichage de la réponse
        System.out.println("Question : " + question);
        System.out.println("Réponse : " + reponse);
    }

}