package Assignment_2;

import Assignment_2.Services.NameGeneratorService;

/*
 * Author: Delmas Shipman
 * Class: CPSC 6119
 * Purpose: The abstract staff class for the simulation. The constructor randomly generates a name for each object.
 * Last Revision: September 4, 2026
 */
public abstract class Staff
{
    public String name;

    protected Staff()
    {
        NameGeneratorService nameGenerator = new NameGeneratorService();
        name = nameGenerator.generateStaffName();
    }
}