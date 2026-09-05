package Assignment_2.Facilities;

import Assignment_2.Animal;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Contains a list of animals of the same type and methods to add/remove them.
 * Last Revision: September 4, 2026
 */
public class Enclosure
{
    public Animal animalType;
    public List<Animal> animals = new ArrayList<>();

    public Enclosure(Animal animal)
    {
        animalType = animal;
    }

    public void addAnimal(Animal animal)
    {
        animals.add(animal);
    }

    public void removeAnimals(Animal animal)
    {
        animals.remove(animal);
    }
}