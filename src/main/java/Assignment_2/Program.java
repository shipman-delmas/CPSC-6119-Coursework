package Assignment_2;

import Assignment_2.Services.SimulationService;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: The main program for the simulation. It simply creates an instance of the service class and calls the
 *          method to run the simulation. The service class does all coordination.
 * Last Revision: September 4, 2026
 */
public class Program
{
    public static void main(String[] args)
    {
        SimulationService simulationService = new SimulationService();

        simulationService.runSimulation();
    }
}