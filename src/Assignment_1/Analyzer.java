package Assignment_1;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Provides methods for calculating statistics for arrays of double values.
 * Last Revision: August 22, 2026
 */
public class Analyzer
{
    // Calculates mean of an array with an enhanced for loop.
    public double GetMean(double[] arr)
    {
        double mean = 0;

        for (double num : arr)
        {
            mean += num;
        }

        return mean / arr.length;
    }

    // Calculated standard deviation of an array. Calls previous method to calculate mean, uses an enhanced for loop,
    // and math library for square root.
    public double GetSd(double[] arr)
    {
        double mean = GetMean(arr);
        double sum = 0;

        for (double num : arr)
        {
            sum += ((num - mean) * (num - mean));
        }

        return Math.sqrt(sum / (arr.length - 1));
    }

    // Finds the minimum floor value for an array using an enhanced for loop.
    public double GetMin(double[] arr)
    {
        double min = arr[0];

        for (double num : arr)
        {
            if (num < min) min = num;
        }

        return min;
    }

    // Finds the maximum ceiling value for an array using an enhanced for loop.
    public double GetMax(double[] arr)
    {
        double max = arr[0];

        for (double num : arr)
        {
            if (num > max) max = num;
        }

        return max;
    }
}