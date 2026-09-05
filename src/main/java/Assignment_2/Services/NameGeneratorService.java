package Assignment_2.Services;

import java.util.Random;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Service class that randomly chooses name for animals and staff objects from a predetermined array.
 * Last Revision: September 4, 2026
 */
public class NameGeneratorService
{
    private final Random random = new Random();

    // Two predetermined arrays of 30 names each.
    private static final String[] animalNames = {
            "Buddy", "Max", "Luna", "Bella", "Charlie",
            "Milo", "Daisy", "Rocky", "Coco", "Bear",
            "Bailey", "Loki", "Lucy", "Leo", "Sadie",
            "Teddy", "Finn", "Willow", "Scout", "Ruby",
            "Oliver", "Rosie", "Jack", "Zoe", "Archie",
            "Nala", "Gus", "Poppy", "Winston", "Cleo"
    };

    private static final String[] staffNames = {
            "James", "Michael", "Robert", "William", "David",
            "Joseph", "Thomas", "Daniel", "Matthew", "Andrew",
            "Christopher", "Benjamin", "Samuel", "Alexander", "Nicholas",
            "Elizabeth", "Jennifer", "Jessica", "Amanda", "Sarah",
            "Emily", "Ashley", "Samantha", "Rachel", "Rebecca",
            "Lauren", "Megan", "Olivia", "Hannah", "Victoria"
    };

    // Two methods to randomly grab a name from the arrays.
    public String generateAnimalName()
    {
        return animalNames[random.nextInt(animalNames.length)];
    }

    public String generateStaffName()
    {
        return staffNames[random.nextInt(staffNames.length)];
    }
}