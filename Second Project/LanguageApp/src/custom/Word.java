package custom;

/*
    This is our custom class for Word, because we will need String in English(or other language)
    and string with translated word to bulgarian
 */
public class Word {
    // Init our components
    private String word;
    private String translatedWord;

    public Word(String word, String translatedWord) {
        this.word = word;
        this.translatedWord = translatedWord;
    }

    public String getWord() {
        return word;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }
}
