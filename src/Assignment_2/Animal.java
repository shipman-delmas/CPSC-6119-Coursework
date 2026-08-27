package Assignment_2;

import java.util.Random;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose:
 * Sources: https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getSimpleName--
 * Last Revision: August 27, 2026
 */
public abstract class Animal
{
    String Name;
    enum Size {small, medium, large, extralarge}
    boolean Healthy;
    String Sound;

    Random random = new Random();

    public String Sleep()
    {
        return this.Name + " the " + this.getClass().getSimpleName() + " has gone to sleep.";
    }

    // might need to move class-specific conditionals to subclasses later. logic implemented for now.
    public String Roam()
    {
        double diceRoll = random.nextDouble();
        String family = this.getClass().getSuperclass().getSimpleName();

        if ((family.equals("Pachyderm")) && (diceRoll <= 0.25))
        {
            return this.Name + " the " + this.getClass().getSimpleName() + " is roaming - and charged!";
        }
        if ((family.equals("Feline")) && (diceRoll <= 0.25))
        {
            return this.Name + " the " + this.getClass().getSimpleName() + " is sleeping.";
        }
        else
        {
            return this.Name + " the " + this.getClass().getSimpleName() + " is roaming.";
        }
    }

    public String Eat()
    {
        double diceRoll = random.nextDouble();

        if (diceRoll <= 0.1)
        {
            return this.Name + " the " + this.getClass().getSimpleName() + " is eating 0 food units.";
        }
        else if (diceRoll >= 0.9)
        {
            return this.Name + " the " + this.getClass().getSimpleName() + " is eating too many food units";
        }
        else
        {
            return this.Name + " the " + this.getClass().getSimpleName() + " is eating " + (diceRoll * 10) + " food units.";
        }
    }

    public String MakeSound()
    {
        return this.Sound;
    }
}
