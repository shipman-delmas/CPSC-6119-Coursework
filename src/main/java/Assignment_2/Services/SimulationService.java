package Assignment_2.Services;

import Assignment_2.Animal;
import Assignment_2.AnimalTypes.*;
import Assignment_2.Facilities.*;
import Assignment_2.StaffTypes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: The service program that coordinates all classes in the program.
 * Last Revision: September 4, 2026
 */
public class SimulationService
{
    private static final int SIMULATION_DAYS = 30;

    private final Zoo zoo;
    private final Hospital hospital;

    private final Enclosure rhinoEnclosure;
    private final Enclosure elephantEnclosure;
    private final Enclosure hippoEnclosure;

    private final Enclosure tigerEnclosure;
    private final Enclosure lionEnclosure;
    private final Enclosure cheetahEnclosure;

    private final Enclosure parrotEnclosure;
    private final Enclosure falconEnclosure;
    private final Enclosure owlEnclosure;

    private final Handler pachydermHandler;
    private final Handler felineHandler;
    private final Handler birdHandler;

    private final Veterinarian veterinarian;

    // Hashing seemed to be the best way of ensuring animal returns to correct enclosure after leaving.
    private final Map<Animal, Enclosure> normalEnclosures = new HashMap<>();


    // Constructs and initializes all staff and facility objects needed for simulation.
    public SimulationService()
    {
        zoo = new Zoo();

        /*
         * Create Hospital and associate it with Zoo.
         */
        hospital = new Hospital();
        zoo.hospital = hospital;

        /*
         * Create one Enclosure for each Animal Type.
         */
        rhinoEnclosure = new Enclosure(new Rhino());
        elephantEnclosure = new Enclosure(new Elephant());
        hippoEnclosure = new Enclosure(new Hippo());

        tigerEnclosure = new Enclosure(new Tiger());
        lionEnclosure = new Enclosure(new Lion());
        cheetahEnclosure = new Enclosure(new Cheetah());

        parrotEnclosure = new Enclosure(new Parrot());
        falconEnclosure = new Enclosure(new Falcon());
        owlEnclosure = new Enclosure(new Owl());

        /*
         * Add all Enclosures to the Zoo.
         */
        zoo.enclosures.add(rhinoEnclosure);
        zoo.enclosures.add(elephantEnclosure);
        zoo.enclosures.add(hippoEnclosure);

        zoo.enclosures.add(tigerEnclosure);
        zoo.enclosures.add(lionEnclosure);
        zoo.enclosures.add(cheetahEnclosure);

        zoo.enclosures.add(parrotEnclosure);
        zoo.enclosures.add(falconEnclosure);
        zoo.enclosures.add(owlEnclosure);

        /*
         * Create one Handler for each Animal Family.
         */
        pachydermHandler = new Handler();
        felineHandler = new Handler();
        birdHandler = new Handler();

        /*
         * Assign Enclosures to the appropriate Handler.
         */
        pachydermHandler.handlerEnclosures.add(rhinoEnclosure);
        pachydermHandler.handlerEnclosures.add(elephantEnclosure);
        pachydermHandler.handlerEnclosures.add(hippoEnclosure);

        felineHandler.handlerEnclosures.add(tigerEnclosure);
        felineHandler.handlerEnclosures.add(lionEnclosure);
        felineHandler.handlerEnclosures.add(cheetahEnclosure);

        birdHandler.handlerEnclosures.add(parrotEnclosure);
        birdHandler.handlerEnclosures.add(falconEnclosure);
        birdHandler.handlerEnclosures.add(owlEnclosure);

        /*
         * Add Handlers to the Zoo.
         */
        zoo.handlers.add(pachydermHandler);
        zoo.handlers.add(felineHandler);
        zoo.handlers.add(birdHandler);

        /*
         * Create the Veterinarian.
         */
        veterinarian = new Veterinarian();
        zoo.veterinarian = veterinarian;

        /*
         * Create all animals.
         */
        initializeAnimals();
    }


    // Constructs and initializes all animal objects needed for simulation.
    private void initializeAnimals()
    {
        addAnimal(new Rhino(), rhinoEnclosure);
        addAnimal(new Rhino(), rhinoEnclosure);
        addAnimal(new Rhino(), rhinoEnclosure);

        addAnimal(new Elephant(), elephantEnclosure);
        addAnimal(new Elephant(), elephantEnclosure);
        addAnimal(new Elephant(), elephantEnclosure);

        addAnimal(new Hippo(), hippoEnclosure);
        addAnimal(new Hippo(), hippoEnclosure);
        addAnimal(new Hippo(), hippoEnclosure);

        addAnimal(new Tiger(), tigerEnclosure);
        addAnimal(new Tiger(), tigerEnclosure);
        addAnimal(new Tiger(), tigerEnclosure);

        addAnimal(new Lion(), lionEnclosure);
        addAnimal(new Lion(), lionEnclosure);
        addAnimal(new Lion(), lionEnclosure);

        addAnimal(new Cheetah(), cheetahEnclosure);
        addAnimal(new Cheetah(), cheetahEnclosure);
        addAnimal(new Cheetah(), cheetahEnclosure);

        addAnimal(new Parrot(), parrotEnclosure);
        addAnimal(new Parrot(), parrotEnclosure);
        addAnimal(new Parrot(), parrotEnclosure);

        addAnimal(new Falcon(), falconEnclosure);
        addAnimal(new Falcon(), falconEnclosure);
        addAnimal(new Falcon(), falconEnclosure);

        addAnimal(new Owl(), owlEnclosure);
        addAnimal(new Owl(), owlEnclosure);
        addAnimal(new Owl(), owlEnclosure);
    }


    // Puts each animal in correct enclosure and tracks it in the hash map.
    private void addAnimal(Animal animal, Enclosure enclosure)
    {
        enclosure.addAnimal(animal);

        normalEnclosures.put(animal, enclosure);
    }


    // Calls method for simulating a single cycle 30 times.
    public void runSimulation()
    {
        for (int day = 1; day <= SIMULATION_DAYS; day++)
        {
            System.out.println();
            System.out.println("========================================");
            System.out.println("           START OF DAY " + day);
            System.out.println("========================================");

            runDay();

            System.out.println("========================================");
            System.out.println("            END OF DAY " + day);
            System.out.println("========================================");
            System.out.println();
        }
    }


    // Calls each method for each activity for a day in the simulation.
    private void runDay()
    {
        wakeAnimals();

        feedAnimals();

        displayZooStatus();

        exerciseAnimals();

        treatAnimals();

        bedAnimals();
    }


    // Methods for performing simulated activities.
    private void wakeAnimals()
    {
        pachydermHandler.wakeAnimals();
        felineHandler.wakeAnimals();
        birdHandler.wakeAnimals();
    }

    private void feedAnimals()
    {
        pachydermHandler.feedAnimals();
        felineHandler.feedAnimals();
        birdHandler.feedAnimals();

        moveSickAnimalsToHospital();
    }

    private void moveSickAnimalsToHospital()
    {
        for (Enclosure enclosure : zoo.enclosures)
        {
            List<Animal> animals = new ArrayList<>(enclosure.animals);

            for (Animal animal : animals)
            {
                if (!animal.Healthy)
                {
                    enclosure.removeAnimals(animal);

                    hospital.admitAnimal(animal);

                    System.out.println(animal.Name + " the " + animal.getClass().getSimpleName() +
                            " is sick and is moving to the Hospital.");
                }
            }
        }
    }

    private void displayZooStatus()
    {
        System.out.println(zoo.zooStatus());
    }

    private void exerciseAnimals()
    {
        pachydermHandler.exerciseAnimals();
        felineHandler.exerciseAnimals();
        birdHandler.exerciseAnimals();
    }

    private void treatAnimals()
    {
        veterinarian.treatAnimals(hospital);

        List<Animal> animals = new ArrayList<>(hospital.animals);

        for (Animal animal : animals)
        {
            if (animal.Healthy)
            {
                Enclosure enclosure = normalEnclosures.get(animal);

                hospital.releaseAnimal(animal);

                if (enclosure != null)
                {
                    enclosure.addAnimal(animal);

                    System.out.println(animal.Name + " the " + animal.getClass().getSimpleName() +
                                        " is feeling better and is moving back to its enclosure.");
                }
            }
        }
    }

    private void bedAnimals()
    {
        pachydermHandler.bedAnimals();
        felineHandler.bedAnimals();
        birdHandler.bedAnimals();
    }
}