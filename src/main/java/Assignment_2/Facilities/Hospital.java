package Assignment_2.Facilities;

import Assignment_2.Animal;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Contains a list of animals and methods for adding/removing animals. This is used whenever they are found
 *          to be not healthy in the simulation.
 * Last Revision: September 4, 2026
 */
public class Hospital
{
    public List<Animal> animals = new ArrayList<>();

    public void admitAnimal(Animal animal)
    {
        animals.add(animal);
    }

    public void releaseAnimal(Animal animal)
    {
        animals.remove(animal);
    }
}