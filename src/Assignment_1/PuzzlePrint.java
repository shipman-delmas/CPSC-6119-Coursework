package Assignment_1;

import java.util.ArrayList;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Methods for retrieving data from reader and tokenizer classes.
 * Last Revision: August 22, 2026
 */
public class PuzzlePrint
{
    // Object initialization.
    private Reader reader = new Reader();
    private Tokenizer tokenizer = new Tokenizer(reader);

    // Constructor.
    public PuzzlePrint(Reader reader, Tokenizer tokenizer)
    {
        this.reader = reader;
        this.tokenizer = tokenizer;
    }

    // Access and return tokens instance field from tokenizer object.
    public ArrayList<String> GetTokens()
    {
        return tokenizer.Tokens;
    }

    // Access and return clues instance field from reader object.
    public String[] GetClues()
    {
        return reader.clues;
    }

    // Access and return words instance field from reader object.
    public ArrayList<String> GetAnswers()
    {
        return reader.Words;
    }
}
