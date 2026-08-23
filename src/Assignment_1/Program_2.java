package Assignment_1;

import java.util.ArrayList;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Prints a predetermined arraylist of tokenized and randomized substrings, an array of strings, and an
 *          arraylist of the original strings before tokenization and randomization. The user should use the
 *          randomized token values with the string array of clues to find the original string values.
 * Last Revision: August 22, 2026
 */
public class Program_2
{
    public static void main(String[] args)
    {
        // Instantiate objects.
        Reader reader = new Reader();
        Tokenizer tokenizer = new Tokenizer(reader);
        PuzzlePrint puzzlePrint = new PuzzlePrint(reader, tokenizer);

        // Call puzzle print instance methods to retrieve data.
        ArrayList<String> tokens = puzzlePrint.GetTokens();
        String[] clues = puzzlePrint.GetClues();
        ArrayList<String> answers = puzzlePrint.GetAnswers();

        // Call tokenizer instance methods to tokenize and randomize data.
        tokenizer.Tokenize();
        tokenizer.Randomize();

        // Print tokens in a table using for loop and conditional.
        // Print clues and answers with enhanced for loops.
        System.out.println("----------------------------------------------");
        System.out.println("Tokens:");

        for (int i = 0; i < tokens.size(); i++)
        {
            System.out.print(tokens.get(i) + "\t");

            if ((i + 1) % 4 == 0)
            {
                System.out.println();
            }
        }
        System.out.println("----------------------------------------------");

        System.out.println("Clues:");

        for (String clue : clues)
        {
            System.out.println(clue);
        }
        System.out.println("----------------------------------------------");

        System.out.println("Answer Key:");

        for (String answer : answers)
        {
            System.out.println(answer.toUpperCase());
        }
        System.out.println("----------------------------------------------");
    }
}
