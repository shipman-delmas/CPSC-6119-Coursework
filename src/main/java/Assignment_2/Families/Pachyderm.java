package Assignment_2.Families;

import Assignment_2.Animal;

import java.util.Random;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Abstract animal family domain class for zoo simulation.
 * Last Revision: September 4, 2026
 */
public abstract class Pachyderm extends Animal
{
    private final Random random = new Random();

    // override to inherited roam method; 25% to charge instead of roam.
    @Override
    public void Roam()
    {
        double diceRoll = random.nextDouble();

        if (diceRoll < 0.25)
        {
            System.out.println(
                    this.Name + " the " +
                            this.getClass().getSimpleName() +
                            " is roaming - and charged!"
            );
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