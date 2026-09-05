package Assignment_2.StaffTypes;

import Assignment_2.Animal;
import Assignment_2.Facilities.Hospital;
import Assignment_2.Staff;

import java.util.List;
import java.util.Random;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: A concrete subclass of staff that has a method for reevaluating animal bool value for healthy each cycle
 *          of the simulation.
 * Last Revision: September 4, 2026
 */
public class Veterinarian extends Staff
{
    private final Random random = new Random();

    // A 50/50 coin toss is performed for each animal in the hospital list to determine if still sick or if healthy.
    public void treatAnimals(Hospital hospital)
    {
        System.out.println(this.name + " the Vet is treating sick animals.");

        List<Animal> animals = hospital.animals;

        for (Animal animal : animals)
        {
            double diceRoll = random.nextDouble();

            if (diceRoll >= 0.5)
            {
                animal.Healthy = true;
            }
        }
    }
}