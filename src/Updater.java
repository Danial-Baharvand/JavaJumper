import java.util.Random;

/**
 * Helper class to update the buildings
 *
 * @author Danial Baharvand
 */
public class Updater
{
    private int fuelTimer;
    private int maxHeight;
    private int maxCells;
    private int timer;
    private Random rand;

    /**
     * Default constructor
     */
    public Updater()
    {
        fuelTimer = 3;
        maxHeight = 5;
        maxCells = 4;
        timer = 0;
        rand = new Random();
    }

    /**
     * Constructor with seed parameter
     */
    public Updater(int seed)
    {
        fuelTimer = 3;
        maxHeight = 5;
        maxCells = 4;
        timer = 0;
        rand = new Random(seed);
    }

    /**
     * Constructor with parameters
     *
     * @param fuelTimer hold the time remaining before fuel cells are moved
     * @param maxHeight maximum height of the buildings
     * @param maxCells  maximum number of fuel cells allowed
     */
    public Updater(int fuelTimer, int maxHeight, int maxCells)
    {
        this.fuelTimer = fuelTimer;
        this.maxHeight = maxHeight;
        this.maxCells = maxCells;
        timer = 0;
        rand = new Random();
    }

    /**
     * Displays the current settings of the updater class
     */
    public void display()
    {
        System.out.println("Fuel Timer: " + fuelTimer + "Max Height: " + maxHeight +
                "Max Cells: " + maxCells + "Timer: " + timer);
    }

    /**
     * @return fuel timer
     */
    public int getFuelTimer()
    {
        return fuelTimer;
    }

    /**
     * @return maximum fuel cells allowed
     */
    public int getMaxCells()
    {
        return maxCells;
    }

    /**
     * @return maximum building height allowed
     */
    public int getMaxHeight()
    {
        return maxHeight;
    }

    /**
     * @return random object
     */
    public Random getRand()
    {
        return rand;
    }

    /**
     * @return current time of the timer
     */
    public int getTimer()
    {
        return timer;
    }

    /**
     * Sets fuel timer
     *
     * @param fuelTimer hold the time remaining before fuel cells are moved
     */
    public void setFuelTimer(int fuelTimer)
    {
        this.fuelTimer = fuelTimer;
    }

    /**
     * Sets maximum fuel cells limit
     *
     * @param maxCells maximum number of fuel cells allowed
     */
    public void setMaxCells(int maxCells)
    {
        this.maxCells = maxCells;
    }

    /**
     * Sets maximum building height limit
     *
     * @param maxHeight maximum height of the buildings
     */
    public void setMaxHeight(int maxHeight)
    {
        this.maxHeight = maxHeight;
    }

    /**
     * Sets the random object
     *
     * @param rand random object
     */
    public void setRand(Random rand)
    {
        this.rand = rand;
    }

    /**
     * sets the time
     *
     * @param timer holds the time
     */
    public void setTimer(int timer)
    {
        this.timer = timer;
    }

    /**
     * Updates the buildings with random height within the correct constraints
     * Updates the freeze and webbed status of buildings and randomly assigns them
     * Moves the fuel cells to random buildings
     *
     * @param buildings array of buildings
     */
    public void update(Building[] buildings)
    {
        timer++;
        for (Building building : buildings)
        {
            building.setWeb(false);
            building.setFreeze(false);
            if (fuelTimer == timer) building.setFuel(false);
            building.setHeight(rand.nextInt(maxHeight) + 1);
        }
        buildings[rand.nextInt(buildings.length)].setFreeze(true);
        buildings[rand.nextInt(buildings.length)].setWeb(true);
        if (fuelTimer == timer)
        {
            for (int i = 0; i < maxCells; i++)
            {
                buildings[rand.nextInt(buildings.length)].setFuel(true);
            }
            timer = 0;
        }
    }
}