package Assignment_2.Facilities;

import Assignment_2.Animal;
import Assignment_2.StaffTypes.Handler;
import Assignment_2.StaffTypes.Veterinarian;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: Contains all facility classes and staff classes required to run the simulation, as well as a method to
 *          display the status of the zoo.
 * Last Revision: September 4, 2026
 */
public class Zoo
{
    public List<Enclosure> enclosures = new ArrayList<>();

    public Hospital hospital;

    public List<Handler> handlers = new ArrayList<>();

    public Veterinarian veterinarian;


    // Method lists all values of objects in the zoo.
    public String zooStatus()
    {
        StringBuilder status = new StringBuilder();

        status.append("\n");
        status.append("============================================================\n");
        status.append("                        ZOO STATUS\n");
        status.append("============================================================\n");

        status.append(String.format(
                "%-15s %-15s %-35s%n",
                "Enclosure",
                "Handler",
                "Animals"
        ));

        status.append("------------------------------------------------------------\n");

        for (Enclosure enclosure : enclosures)
        {
            Handler handler = findHandler(enclosure);

            StringBuilder animals = new StringBuilder();

            for (Animal animal : enclosure.animals)
            {
                if (animals.length() > 0)
                {
                    animals.append(", ");
                }

                animals.append(animal.Name)
                        .append(" (")
                        .append(animal.getClass().getSimpleName())
                        .append(")");
            }

            String enclosureName =
                    enclosure.animalType != null
                            ? enclosure.animalType.getClass().getSimpleName()
                            : "Unknown";

            String handlerName =
                    handler != null
                            ? handler.name
                            : "None";

            status.append(String.format(
                    "%-15s %-15s %-35s%n",
                    enclosureName,
                    handlerName,
                    animals
            ));
        }

        status.append("------------------------------------------------------------\n");

        String veterinarianName =
                veterinarian != null
                        ? veterinarian.name
                        : "None";

        String hospitalAnimals =
                hospital != null
                        ? formatHospitalAnimals()
                        : "None";

        status.append(String.format(
                "%-15s %-15s %-35s%n",
                "Hospital",
                veterinarianName,
                hospitalAnimals
        ));

        status.append("============================================================\n");

        return status.toString();
    }


    // Helper method for getting handler of a specific enclosure.
    private Handler findHandler(Enclosure enclosure)
    {
        for (Handler handler : handlers)
        {
            if (handler.handlerEnclosures.contains(enclosure))
            {
                return handler;
            }
        }

        return null;
    }


    // Method for formatting string output of hospital animals list.
    private String formatHospitalAnimals()
    {
        if (hospital.animals.isEmpty())
        {
            return "[]";
        }

        StringBuilder animals = new StringBuilder();

        for (Animal animal : hospital.animals)
        {
            if (animals.length() > 0)
            {
                animals.append(", ");
            }

            animals.append(animal.Name).append(" (").append(animal.getClass().getSimpleName()).append(")");
        }

        return "[" + animals + "]";
    }
}