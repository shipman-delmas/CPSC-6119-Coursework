package Assignment_1;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Provide methods for creating arrays of specified length with random double values. Each method uses a
 *          different library for generating random double values.
 * Last Revision: August 22, 2026
 */
public class Creator
{
    // Uses java.util.Random library to initialize array of random double values.
    public double[] GenWithRandom(int length)
    {
        Random rand = new Random();
        double[] result = new double[length];

        for (int i = 0; i < length; ++i)
        {
            result[i] = rand.nextDouble();
        }

        return result;
    }

    // Uses Math.Random library to initialize array of random double values.
    public double[] GenWithMathRandom(int length)
    {
        double[] result = new double[length];

        for (int i = 0; i < length; ++i)
        {
            result[i] = Math.random();
        }

        return result;
    }

    // Uses java.util.concurrent.ThreadLocalRandom library to initialize array of random double values.
    public double[] GenWithThreadLocalRandom(int length)
    {
        double[] result = new double[length];

        for (int i = 0; i < length; ++i)
        {
            result[i] = ThreadLocalRandom.current().nextDouble();
        }

        return result;
    }
}