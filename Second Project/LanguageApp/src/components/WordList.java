package components;

import custom.Word;

import java.util.ArrayList;
import java.util.List;

public class WordList {
    // We create our empty constructor because we do not need a something special to do with him
    public WordList() {}

    public List<Word> initWords(){
        // We create our List with words and return it to our main
        List<Word> word = new ArrayList<>();

        word.add(new Word("Spoon", "лъжица"));
        word.add(new Word("Cutting board", "дъска за рязане"));
        word.add(new Word("Kitchen Cabinet", "кухненски шкаф"));
        word.add(new Word("Fork", "вилица"));
        word.add(new Word("Oven", "печка за готвене"));
        word.add(new Word("Washing machine", "пералня"));
        word.add(new Word("Sink", "мивка"));
        word.add(new Word("Knife", "нож"));
        word.add(new Word("Kitchen roll", "кухненска ролка"));
        word.add(new Word("Hood", "аспиратор"));
        word.add(new Word("Cup", "чаша"));
        word.add(new Word("Plate", "чиния"));
        word.add(new Word("Bowl", "купа"));
        word.add(new Word("Sponge", "гъба за миене"));
        word.add(new Word("Mushroom", "гъба"));
        word.add(new Word("Milk", "мляко"));
        word.add(new Word("Meat", "месо"));
        word.add(new Word("Mixer", "миксер"));
        word.add(new Word("Pads", "подложки"));
        word.add(new Word("Kettle", "чайник"));
        word.add(new Word("Napkins", "салфетки"));
        word.add(new Word("こんにちは", "здравей"));

        return word;
    }
}
