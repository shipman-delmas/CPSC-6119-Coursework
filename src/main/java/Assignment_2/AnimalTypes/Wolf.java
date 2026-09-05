package Assignment_2.AnimalTypes;

import Assignment_2.Families.Canine;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Concrete animal type domain class for zoo simulation.
 * Last Revision: September 4, 2026
 */
public class Wolf extends Canine
{
    @Override
    public void makeSound()
    {
        System.out.println(this.Name + " the " + this.getClass().getSimpleName() + " says: Howl.");
    }
}
