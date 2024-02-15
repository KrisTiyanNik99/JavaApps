package custom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordList {
    // We create our empty constructor because we do not need a something special to do with him
    public WordList() {
    }

    public List<Word> initWords() {
        // We create our List with words and return it to our main
        List<Word> words = new ArrayList<>();

        // Get file location
        String jsonFilePath = "C:\\Users\\Kris\\Desktop\\Java GUI projects\\JavaApps\\Second Project\\LanguageApp\\Words.json";

        try {
            // Read json file
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Save all info from json file to json array
            JSONArray wordsArray = jsonObject.getJSONArray("words");

            // Loop through all words
            for (int i = 0; i < wordsArray.length(); i++) {
                // We go through each element of the word array in the json file
                JSONObject currentWord = wordsArray.getJSONObject(i);

                // Take the values from the fields "word", "translate" and "emoji" from our json file
                String word = currentWord.getString("word");
                String translatedWord = currentWord.getString("translate");
                String emoji = currentWord.getString("emoji");

                // Create object with these parameters from our custom class Word and add it to the list "words"
                words.add(new Word(word, translatedWord, emoji));
            }

        } catch (JSONException e) {
            System.out.println("File error exception!");
        } catch (IOException e) {
            System.out.println("File was not found!");
        }

        return words;
    }
}