package Assignment_1;

import java.util.ArrayList;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Stores hardcoded words and clues in string arrays. Initializes and provides an arraylist of the words.
 * Last Revision: August 22, 2026
 */
public class Reader
{
    // String arrays containing predetermined words and their corresponding clues. ArrayList to store the words
    // for access by other classes.
    private String[] words =
            {
                    "Printer",
                    "Keyboard",
                    "Computer",
                    "Clock",
                    "Umbrella",
                    "Calendar",
                    "Headphones"
            };
    public String[] clues =
            {
                    "Device made to waste ink and paper.",
                    "Turns thoughts to typos.",
                    "Thinks without a brain.",
                    "Two hands, but cannot carry anything",
                    "Only works when raining.",
                    "Paper that reminds you how little time you have.",
                    "Audio device for ignoring people."
            };
    public ArrayList<String> Words = new ArrayList<>(7);

    // Constructor call method to initialize arraylist.
    public Reader()
    {
        LoadWords(words);
    }

    // Adds words from string array to arraylist.
    public void LoadWords(String[] words)
    {
        for (String word : words)
        {
            Words.add(word);
        }
    }
}
