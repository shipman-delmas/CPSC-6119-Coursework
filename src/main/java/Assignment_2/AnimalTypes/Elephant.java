package Assignment_2.AnimalTypes;

import Assignment_2.Families.Pachyderm;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Concrete animal type domain class for zoo simulation.
 * Last Revision: September 4, 2026
 */
public class Elephant extends Pachyderm
{
    @Override
    public void makeSound()
    {
        System.out.println(this.Name + " the " + this.getClass().getSimpleName() + " says: Trumpet.");
    }
}
