package Assignment_2.Families;

import Assignment_2.Animal;

import java.util.Random;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Abstract animal family domain class for zoo simulation.
 * Last Revision: September 4, 2026
 */
public abstract class Feline extends Animal
{
    private final Random random = new Random();


     // override to inherited roam method; 50% to sleep instead of roam.
    @Override
    public void Roam()
    {
        double diceRoll = random.nextDouble();

        if (diceRoll < 0.50)
        {
            System.out.println(
                    this.Name + " the " +
                            this.getClass().getSimpleName() +
                            " decided to sleep instead of roaming."
            );

            Sleep();
        }
        else
        {
            System.out.println(
                    this.Name + " the " +
                            this.getClass().getSimpleName() +
                            " is roaming."
            );
        }
    }
}