package guis;

import custom.Word;
import custom.WordList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class JLanguagePanel extends JFrame {

    // Set boolean who will listen if we try to change word without
    AtomicBoolean changeWord = new AtomicBoolean(true);

    // Create our custom JFrame who will store our things for displaying
    public JLanguagePanel(int width, int height, JMenuBar menuBar) {

        //Init components method
        initLanguageGUI(width, height, menuBar);
    }

    // Set all component to our main GUI for beginners
    private void initLanguageGUI(int width, int height, JMenuBar menuBar) {

        // Set settings to our custom JFrame
        setLayout(null);
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLUE);

        // Set already setup menu bar who come from our MainFrame
        setJMenuBar(menuBar);

        // Get first menu item
        JMenu firstMenu = menuBar.getMenu(0);
        JMenuItem firstItem = firstMenu.getItem(0);

        // Remove all actions
        removeActions(firstItem);

        // Set new action
        firstItem.addActionListener(e -> {
            dispose();
            new MainFrame();
        });

        // Repeat the for second menu item
        JMenuItem secondItem = menuBar.getMenu(1).getItem(0);
        removeActions(secondItem);
        secondItem.addActionListener(e -> {
            dispose();
            new AddWordPanel(getWidth(), getHeight(), menuBar);
        });

        // We create our main scene where the word we will have to guess will appear
        JPanel wordDisplay = new JPanel();
        wordDisplay.setLayout(null);
        wordDisplay.setBounds(250, 80, 300, 100);

        // We add JLabel to our wordDisplay
        JLabel text = new JLabel();
        text.setBounds(0, 0, 300, 100);

        // Change font style and set text in the center
        text.setFont(new Font("Word", Font.BOLD, 20));
        text.setHorizontalAlignment(SwingConstants.CENTER);

        wordDisplay.add(text);
        add(wordDisplay);

        // Create our answer buttons and set their size and locations and add all buttons to list
        List<JButton> buttons = new ArrayList<>();

        JButton firstAnswer = new JButton();
        firstAnswer.setBounds(140, 225, 250, 100);
        buttonSettings(firstAnswer, buttons);

        JButton secondAnswer = new JButton();
        secondAnswer.setBounds(420, 225, 250, 100);
        buttonSettings(secondAnswer, buttons);

        JButton thirdAnswer = new JButton();
        thirdAnswer.setBounds(140, 345, 250, 100);
        buttonSettings(thirdAnswer, buttons);

        JButton forthAnswer = new JButton();
        forthAnswer.setBounds(420, 345, 250, 100);
        buttonSettings(forthAnswer, buttons);

        // Button for next word
        JButton next = new JButton("Next word");
        next.setBounds(560, 485, 200, 50);
        next.setFocusPainted(false);
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

        // Set words at start
        startGuessWord(words, text, buttons, random, changeWord, wordDisplay);

        // Action to 'next' button
        next.addActionListener(e -> {
            if (changeWord.get()) {
                wordDisplay.setBackground(Color.WHITE);
                changeWord.set(false);
                startGuessWord(words, text, buttons, random, changeWord, wordDisplay);
            }
        });

        // Set visible to true because we want when we call this class to appear instantly
        setVisible(true);
    }

    // Method from which the appearance of words will begin
    private static void startGuessWord(List<Word> words, JLabel text, List<JButton> buttons, Random random,
                                       AtomicBoolean changeWord, JPanel wordDisplay) {

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

        // Generate random num from words size that will represent out main word
        int num = random.nextInt(words.size());

        // Add number of this word to list to prevent possible word matching
        usedNumbers.add(num);

        // We get and save this word because we will display it to out JPanel
        Word guessingWord = words.get(num);

        text.setText(guessingWord.getWord() + " " + guessingWord.getEmoji());

        // Generate random number, where will be our true answer
        int trueAnswerPosition = random.nextInt(buttons.size());

        // Now we loop through all the buttons and put action events on them
        for (int i = 0; i < buttons.size(); i++) {

            // We take the index of a new word that we don't have until now
            int newWordIndex = checkForUsedNum(random, usedNumbers, words);

            // We parse our index to word and then add this index to our list with used index's
            Word wrongWord = words.get(newWordIndex);
            usedNumbers.add(newWordIndex);

            // Check if the button index matches with our "true word"
            if (i == trueAnswerPosition) {
                buttons.get(i).setText(guessingWord.getTranslatedWord());
                buttons.get(i).addActionListener(e -> {
                    wordDisplay.setBackground(new Color(5, 155, 67));
                    changeWord.set(true);
                });

            } else {

                // If not we put the "wrong word" on the other buttons
                buttons.get(i).setText(wrongWord.getTranslatedWord());
                buttons.get(i).addActionListener(e -> {
                    wordDisplay.setBackground(Color.RED);
                    JOptionPane.showMessageDialog(new Frame(),
                            "Wrong guess! Try again!", "Wrong", JOptionPane.ERROR_MESSAGE);
                });
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

    private static void removeActions(JMenuItem item) {

        ActionListener[] listeners = item.getActionListeners();
        for (ActionListener listener : listeners) {

            // Now we remove all actions from our buttons
            item.removeActionListener(listener);
        }
    }
}
