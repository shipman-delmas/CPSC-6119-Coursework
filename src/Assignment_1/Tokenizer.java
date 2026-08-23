package Assignment_1;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Methods for tokenizing and randomizing the arraylist of predetermined words from the reader class.
 * Last Revision: August 22, 2026
 */
public class Tokenizer
{
    // Object initialization.
    private Reader reader = new Reader();

    // Constructor.
    public Tokenizer(Reader reader)
    {
        this.reader = reader;
    }

    // Arraylist initialization.
    public ArrayList<String> Tokens = new ArrayList<>();

    // Method splits each string in arraylist into substrings of length 2 - 3 using nested for loops and adds them to
    // a new arraylist.
    public void Tokenize()
    {
        int size = 2;
        for (String word : reader.Words)
        {
            for (int i = 0; i < word.length(); i += size)
            {
                if (i + size * 2 > word.length())
                {
                    Tokens.add(word.substring(i));
                }
                else
                {
                    Tokens.add(word.substring(i, i + size));
                }
            }
        }
    }

    // Method randomizes the tokenized values in the new arraylist using the built-in shuffle method.
    public void Randomize()
    {
        Collections.shuffle(Tokens);
    }
}
