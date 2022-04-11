/**
 * Represents a player object
 *
 * @author Danial Baharvand
 */
public class Player
{
    private final int MAX_FUEL = 20;
    private int playerLocation;
    private int fuel;
    private int steps;
    private int cellsFound;
    private boolean frozen;
    private Building[] buildings;
    private String playerName;

    private boolean won;

    /**
     * Default constructor
     */
    public Player()
    {
        playerLocation = 0;
        fuel = MAX_FUEL / 2; // Fuel starts at 50%
        steps = 0;
        cellsFound = 0;
        frozen = false;
        won = false;
        playerName = "UNKNOWN";
        buildings = null;
    }

    /**
     * constructor with parameters
     *
     * @param buildings  an array of building objects
     * @param playerName name of the player
     */
    public Player(Building[] buildings, String playerName)
    {
        playerLocation = 0;
        fuel = MAX_FUEL / 2; // Fuel starts at 50%
        steps = 0;
        cellsFound = 0;
        frozen = false;
        won = false;
        this.playerName = playerName;
        this.buildings = buildings;
    }

    /**
     * Checks if the player can move to the left based on the fuel remaining, game bounds
     * and whether the player is frozen
     *
     * @return returns true if player can move to the left
     */
    public boolean canMoveLeft()
    {
        int distance = buildings[playerLocation].getHeight(); // Player moves equal to the distance of current building
        return playerLocation - distance >= 0 &&
                Math.abs(distance - buildings[playerLocation - distance].getHeight()) < fuel && !frozen;
    }

    /**
     * Checks if the player can move to the right based on the fuel remaining, game bounds
     * and whether the player is frozen
     *
     * @return returns true if player can move to the right
     */
    public boolean canMoveRight()
    {
        int distance = buildings[playerLocation].getHeight(); // Player moves equal to the distance of current building
        return playerLocation + distance < buildings.length &&
                Math.abs(distance - buildings[playerLocation + distance].getHeight()) < fuel && !frozen;
    }

    /**
     * Displays the player stats
     */
    public void display()
    {
        System.out.println("Player Location: " + playerLocation + "fuel: " + fuel +
                "steps: " + steps + "Cells Found: " + cellsFound +
                "frozen: " + frozen + "won: " + won);
    }

    /**
     * @return an array of buildings
     */
    public Building[] getBuildings()
    {
        return buildings;
    }

    /**
     * @return number of fuel cells found
     */
    public int getCellsFound()
    {
        return cellsFound;
    }

    /**
     * @return amount of fuel remaining
     */
    public int getFuel()
    {
        return fuel;
    }

    /**
     * @return maximum fuel player can carry
     */
    public int getMAX_FUEL()
    {
        return MAX_FUEL;
    }

    /**
     * @return player's location in the game
     */
    public int getPlayerLocation()
    {
        return playerLocation;
    }

    /**
     * @return player's name
     */
    public String getPlayerName()
    {
        return playerName;
    }

    /**
     * @return number of steps/turns taken
     */
    public int getSteps()
    {
        return steps;
    }

    /**
     * @return whether the game as been won
     */
    public boolean hasWon()
    {
        return won;
    }

    /**
     * @return whether the player is frozen
     */
    public boolean isFrozen()
    {
        return frozen;
    }

    /**
     * Moves the player to the left
     */
    private void moveLeft()
    {
        int distance = buildings[playerLocation].getHeight(); // Player moves equal to the distance of current building
        fuel -= Math.abs(distance - buildings[playerLocation - distance].getHeight()) + 1;
        buildings[playerLocation].setPlayer(false);
        buildings[playerLocation - distance].setPlayer(true);
        playerLocation = playerLocation - distance;
    }

    /**
     * Moves the player to the correct direction
     *
     * @param dir direction the player should be moved to
     */
    public void movePlayer(char dir)
    {
        switch (dir)
        {
            case 'd':
                if (canMoveRight()) moveRight();
                else
                {   // Player will bounce back and still will use fuel
                    System.out.println("Can't go right, staying on current building");
                    stay();
                }
                break;
            case 'a':
                if (canMoveLeft()) moveLeft();
                else
                {   // Player will bounce back and still will use fuel
                    System.out.println("Can't go left, staying on current building");
                    stay();
                }
                break;
            case 's':
                stay();
                break;
            default:
                stay();
                System.out.println("Incorrect input, staying on current building");
        }
    }

    /**
     * Moves the player to the right
     */
    private void moveRight()
    {
        int distance = buildings[playerLocation].getHeight(); // Player moves equal to the distance of current building
        fuel -= Math.abs(distance - buildings[playerLocation + distance].getHeight()) + 1;
        buildings[playerLocation].setPlayer(false);
        buildings[playerLocation + distance].setPlayer(true);
        playerLocation = playerLocation + distance;

    }

    /**
     * Sets the buildings
     *
     * @param buildings an array of building objects
     */
    public void setBuildings(Building[] buildings)
    {
        this.buildings = buildings;
    }

    /**
     * Sets the number of cells found
     *
     * @param cellsFound the number of cells found
     */
    public void setCellsFound(int cellsFound)
    {
        this.cellsFound = cellsFound;
    }

    /**
     * Sets the frozen status of the player
     *
     * @param frozen whether the player is frozen or not
     */
    public void setFrozen(boolean frozen)
    {
        this.frozen = frozen;
    }

    /**
     * Sets the amount of fuel
     *
     * @param fuel the amount of fuel remaining
     */
    public void setFuel(int fuel)
    {
        this.fuel = fuel;
    }

    /**
     * Sets the location of the player
     *
     * @param playerLocation player's location
     */
    public void setPlayerLocation(int playerLocation)
    {
        this.playerLocation = playerLocation;
    }

    /**
     * Set the player's name
     *
     * @param playerName player's name
     */
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    /**
     * Sets the number of steps/turns takes
     *
     * @param steps number of steps/turns
     */
    public void setSteps(int steps)
    {
        this.steps = steps;
    }

    /**
     * Set's the game to won or not won
     *
     * @param won whether the game has been won
     */
    public void setWon(boolean won)
    {
        this.won = won;
    }

    /**
     * Decreases the fuel and removes the frozen status if the player is to stay at place
     */
    private void stay()
    {
        fuel -= 1;
        if (frozen) frozen = false;
    }

    /**
     * Updates the player status based on the building it lands on
     *
     * @return whether the player has landed on the exit portal
     */
    public boolean update()
    {
        steps++;
        if (buildings[playerLocation].isFuel())
        {
            cellsFound++;
            if (fuel+5 > MAX_FUEL)fuel = MAX_FUEL;
            else fuel += 5;
            buildings[playerLocation].setFuel(false);
            System.out.println("GRABBED A FUEL CELL!");
        }
        if (buildings[playerLocation].isWeb())
        {
            fuel -= 5;
            System.out.println("YOU ARE WEBBED!");
        }
        if (buildings[playerLocation].isFreeze())
        {
            frozen = true;
            System.out.println("YOU ARE FROZEN!");
        } else return buildings[playerLocation].isExit();
        return false;
    }
}