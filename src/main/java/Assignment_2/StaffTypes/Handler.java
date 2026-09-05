package Assignment_2.StaffTypes;

import Assignment_2.Animal;
import Assignment_2.Facilities.Enclosure;
import Assignment_2.Staff;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: A concrete subclass of staff containing methods for interacting with animal objects.
 * Last Revision: September 4, 2026
 */
public class Handler extends Staff
{
    public List<Enclosure> handlerEnclosures = new ArrayList<>();

    // Calls makeSound() method of each animal in assigned enclosure.
    public void wakeAnimals()
    {
        System.out.println("Handler " + this.name + " is waking animals.");

        for (Enclosure enclosure : handlerEnclosures)
        {
            for (Animal animal : enclosure.animals)
            {
                animal.makeSound();
            }
        }
    }

    // Calls Eat() method of each animal in assigned enclosure.
    public void feedAnimals()
    {
        System.out.println("Handler " + this.name + " is feeding animals.");

        for (Enclosure enclosure : handlerEnclosures)
        {
            for (Animal animal : enclosure.animals)
            {
                animal.Eat();
            }
        }
    }

    // Calls Roam() method of each animal in assigned enclosure.
    public void exerciseAnimals()
    {
        System.out.println("Handler " + this.name + " is exercising animals.");

        for (Enclosure enclosure : handlerEnclosures)
        {
            for (Animal animal : enclosure.animals)
            {
                animal.Roam();
            }
        }
    }

    // Calls Sleep() method of each animal in assigned enclosure.
    public void bedAnimals()
    {
        System.out.println("Handler " + this.name + " is putting animals to bed.");

        for (Enclosure enclosure : handlerEnclosures)
        {
            for (Animal animal : enclosure.animals)
            {
                animal.Sleep();
            }
        }
    }
}