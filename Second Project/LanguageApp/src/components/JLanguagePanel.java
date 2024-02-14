package components;

import custom.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class JLanguagePanel extends JPanel {
    // Set boolean who will listen if we try to change word without
    AtomicBoolean changeWord = new AtomicBoolean(true);

    // Create our custom JPanel who will store our things for displaying
    public JLanguagePanel(int width, int height) {

        //Init components method
        initLanguageGUI(width, height);
    }

    private void initLanguageGUI(int width, int height) {

        // Set settings to our custom JPanel
        setLayout(null);
        setSize(width, height);
        setBackground(Color.BLUE);

        // We create our main scene where the word we will have to guess will appear
        JPanel wordDisplay = new JPanel();
        wordDisplay.setLayout(null);
        wordDisplay.setBounds(250, 100, 300, 100);

        // We add JLabel to our wordDisplay
        JLabel text = new JLabel();
        text.setBounds(0, 0, 300, 50);

        // Change font style and set text in the center
        text.setFont(new Font("Word", Font.BOLD, 20));
        text.setHorizontalAlignment(SwingConstants.CENTER);

        wordDisplay.add(text);
        add(wordDisplay);

        // Create our answer buttons and set their size and locations and add all buttons to list
        List<JButton> buttons = new ArrayList<>();

        JButton firstAnswer = new JButton();
        firstAnswer.setBounds(140, 245, 250, 100);
        buttonSettings(firstAnswer, buttons);

        JButton secondAnswer = new JButton();
        secondAnswer.setBounds(420, 245, 250, 100);
        buttonSettings(secondAnswer, buttons);

        JButton thirdAnswer = new JButton();
        thirdAnswer.setBounds(140, 365, 250, 100);
        buttonSettings(thirdAnswer, buttons);

        JButton forthAnswer = new JButton();
        forthAnswer.setBounds(420, 365, 250, 100);
        buttonSettings(forthAnswer, buttons);

        // Button for next word
        JButton next = new JButton("Next word");
        next.setBounds(550, 500, 200, 50);
        add(next);

        // Add all buttons to MainJPanel
        add(firstAnswer);
        add(secondAnswer);
        add(thirdAnswer);
        add(forthAnswer);

        // init WordList
        WordList wordList = new WordList();
        List<Word> words = wordList.initWords();

        // Create random generator
        Random random = new Random();

        // Action to 'next' button
        next.addActionListener(e -> {
            if (changeWord.get()) {
                changeWord.set(false);
                startGuessWord(words, text, buttons, random, changeWord);
            }
        });
    }

    private static void startGuessWord(List<Word> words, JLabel text, List<JButton> buttons, Random random, AtomicBoolean changeWord) {

        // Create List with already used number
        List<Integer> usedNumbers = new ArrayList<>();

        // We need to reset all button action
        for (JButton button : buttons) {
            // First we get all actions that our buttons have
            ActionListener[] listeners = button.getActionListeners();

            for (ActionListener listener : listeners) {
                // Now we remove all actions from our buttons
                button.removeActionListener(listener);
            }
        }

        // Generate random num from words size
        int num = random.nextInt(words.size());

        // Add number of this word to list to prevent possible word matching
        usedNumbers.add(num);

        // We get and save this word because we will display it to out JPanel
        Word guessingWord = words.get(num);

        text.setText(guessingWord.getWord());

        // Generate random number, where will be our true answer
        int trueAnswerPosition = random.nextInt(buttons.size());

        // Now we loop through all the buttons and put action events on them
        for (int i = 0; i < buttons.size(); i++) {
            // We take the index of a new word that we don't have until now
            int newWordIndex = checkForUsedNum(random, usedNumbers, words);

            // We parse our index to word and then add this index to our list with used index's
            Word wrongWord = words.get(newWordIndex);
            usedNumbers.add(newWordIndex);

            // Check if the button index matches our word
            if (i == trueAnswerPosition) {
                buttons.get(i).setText(guessingWord.getTranslatedWord());
                buttons.get(i).addActionListener(e -> {
                    changeWord.set(true);
                    JOptionPane.showMessageDialog(new Frame(),
                            "You successfully guess the word", "Success", JOptionPane.INFORMATION_MESSAGE);
                });
            } else {
                // If not we put the "wrong word" on the other buttons
                buttons.get(i).setText(wrongWord.getTranslatedWord());
                buttons.get(i).addActionListener(e -> JOptionPane.showMessageDialog(new Frame(),
                        "Wrong guess! Try again!", "Wrong", JOptionPane.ERROR_MESSAGE));
            }
        }
    }

    // Method for checking if someone of the generated numbers are already used
    private static int checkForUsedNum(Random random, List<Integer> usedNumbers, List<Word> words) {
        // Generate random number
        int generatedNumber = random.nextInt(words.size());

        // Check if the number is already used and generate number until we get number that we do not have
        while (usedNumbers.contains(generatedNumber)) {

            generatedNumber = random.nextInt(words.size());
        }

        // Return our number
        return generatedNumber;
    }

    // Method for set mandatory setting to our buttons
    private static void buttonSettings(JButton button, List<JButton> buttons) {
        // Set Background color
        button.setBackground(Color.GREEN);

        // Remove the square surrounding it
        button.setFocusPainted(false);

        // Change font style in our button
        button.setFont(new Font("Inside", Font.BOLD, 15));

        buttons.add(button);
    }
}