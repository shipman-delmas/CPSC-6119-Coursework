package Assignment_1;

import java.util.Scanner;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Prompt user for an integer as input. Pass this input into 'creator' instance methods to create three
 *          arrays of random double values. Print statistical values derived from these arrays.
 * Last Revision: August 22, 2026
 */
public class Program_1
{
  public static void main(String[] args)
  {
      // Instantiate objects.
      Creator creator = new Creator();
      Analyzer analyzer = new Analyzer();

      Scanner scanner = new Scanner(System.in);

      // Prompt user for input.
      System.out.println("Enter an integer: ");
      int numRands = Integer.parseInt(scanner.nextLine());

      // Pass integer input to creator instance methods and save to arrays.
      double[] arr1 = creator.GenWithRandom(numRands);
      double[] arr2 = creator.GenWithMathRandom(numRands);
      double[] arr3 = creator.GenWithThreadLocalRandom(numRands);

      // Pass arrays to analyzer instance methods and print in formatted string.
      System.out.printf
              (""" 
              "Library": "java.util.Random",
              "numRands": %d,
              "Mean": %f,
              "Std. Deviation": %f,
              "Min": %f,
              "Max: %f,
              """,
              numRands,
              analyzer.GetMean(arr1),
              analyzer.GetSd(arr1),
              analyzer.GetMin(arr1),
              analyzer.GetMax(arr1)
              );

      System.out.printf
              (""" 
              "Library": "Math.Random",
              "numRands": %d,
              "Mean": %f,
              "Std. Deviation": %f,
              "Min": %f,
              "Max: %f,
              """,
              numRands,
              analyzer.GetMean(arr2),
              analyzer.GetSd(arr2),
              analyzer.GetMin(arr2),
              analyzer.GetMax(arr2)
              );

      System.out.printf
              (""" 
              "Library": "java.util.concurrent.ThreadLocalRandom",
              "numRands": %d,
              "Mean": %f,
              "Std. Deviation": %f,
              "Min": %f,
              "Max: %f,
              """,
              numRands,
              analyzer.GetMean(arr3),
              analyzer.GetSd(arr3),
              analyzer.GetMin(arr3),
              analyzer.GetMax(arr3)
              );
  }
}