package Assignment_2;

import Assignment_2.Services.NameGeneratorService;

import java.util.Random;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: The abstract base class for all animal families and types in the simulation.
 * Last Revision: September 4, 2026
 */
public abstract class Animal
{
    public String Name;

    public enum Size
    {
        small, medium, large, extralarge
    }

    public boolean Healthy;
    public String Sound;

    private final Random random = new Random();

    // Name is randomly generated for each animal.
    public Animal()
    {
        NameGeneratorService nameGenerator = new NameGeneratorService();

        Name = nameGenerator.generateAnimalName();
        Healthy = true;
    }

    // Sleep is unchanged among all animals.
    public void Sleep()
    {
        System.out.println(this.Name + " the " + this.getClass().getSimpleName() + " has gone to sleep.");
    }

    // This is the default roam behavior. Some families override this.
    public void Roam()
    {
        System.out.println(this.Name + " the " + this.getClass().getSimpleName() + " is roaming.");
    }

    // An animal has an 80% chance of eating normally, 10% chance of eating too much, or 10% chance of eating too little.
    // When eating too much or too little, there is a 50% chance of becoming sick.
    public void Eat()
    {
        double diceRoll = random.nextDouble();

        if (diceRoll < 0.10)
        {
            System.out.println(this.Name + " the " + this.getClass().getSimpleName() + " is eating 0 food units.");

            becomeUnhealthy();
        }
        else if (diceRoll >= 0.90)
        {
            System.out.println(this.Name + " the " + this.getClass().getSimpleName() + " is eating too much food.");

            becomeUnhealthy();
        }
        else
        {
            int foodUnits = random.nextInt(5) + 1;

            System.out.println(this.Name + " the " + this.getClass().getSimpleName() +
                                " is eating " + foodUnits + " food units.");
        }
    }

    // Randomly decides on a coin toss if an animal becomes sick.
    private void becomeUnhealthy()
    {
        double healthRoll = random.nextDouble();

        if (healthRoll < 0.50)
        {
            Healthy = false;

            System.out.println(this.Name + " the " + this.getClass().getSimpleName() + " has become unhealthy.");
        }
    }

    // Each concrete animal type implements its own sound.
    public abstract void makeSound();
}