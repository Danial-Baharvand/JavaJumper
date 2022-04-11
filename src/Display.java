/**
 * Helper class for displaying to the user via console
 * @author Danial Baharvand
 */
public class Display
{
    private int maxHeight;

    /**
     * Default constructor
     */
    public Display()
    {
        maxHeight = 5;
    }

    /**
     * Constructor with parameters
     * @param maxHeight maximum height of the buildings
     */
    public Display(int maxHeight)
    {
        this.maxHeight = maxHeight;
    }

    /**
     * Displays the maximum height of the buildings
     */
    public void display()
    {
        System.out.println("Max Height: " + maxHeight);
    }

    /**
     * Draws the buildings to the console
     * @param buildings an array of building objects
     */
    public void drawBuildings(Building[] buildings)
    {
        for (int i = maxHeight; i >= 0; i--)
        {
            for (Building building : buildings)
            {
                System.out.print(building.getLevel(i) + "   ");
            }
        }
    }

    /**
     * Draws the player stats to the screen
     * @param player a player object
     */
    public void drawStatsMenu(Player player)
    {
        System.out.println("Player: " + player.getPlayerName() +
                " Steps:" + player.getSteps() +
                " Cells Found: " + player.getCellsFound() +
                " Fuel: " + player.getFuel());
    }

    /**
     * @return maximum height of the buildings
     */
    public int getMaxHeight()
    {
        return maxHeight;
    }

    /**
     * Prints out the correct goodbye message based on whether the player the game was won or not
     * @param player a player object
     */
    public void printGoodbye(Player player)
    {
        if (player.hasWon())
        {
            System.out.println("Congratulations! You have won!");
        } else
        {
            System.out.println("Game Over!");
        }
        System.out.println("Thank you for playing!");
    }

    /**
     * Prints the directions a player can move in
     * @param jumper a jumper object
     */
    public void printOptions(Jumper jumper)
    {
        if (Jumper.DEMO_MODE)
        {
            System.out.println("WEB/W: Webbed # FRZ/F: Frozen # CEL/C: Fuel Cell # EXT/E: Exit Portal");
        }
        else
        {
            System.out.println("CEL: Fuel Cell # EXT: Exit Portal");
        }
        if (jumper.getPlayer().canMoveRight())
        {
            System.out.println("Type D to jump " +
                    jumper.getBuildings()[jumper.getPlayer().getPlayerLocation()].getHeight()
                    + " buildings to the right");
        }
        if (jumper.getPlayer().canMoveLeft())
        {
            System.out.println("Type A to jump " +
                    jumper.getBuildings()[jumper.getPlayer().getPlayerLocation()].getHeight()
                    + " buildings to the left");
        }
        if (jumper.getPlayer().getFuel() > 0)
        {
            System.out.println("Type S to stay on the current building");
        }
    }

    /**
     * Prints out the welcome message
     */
    public void printWelcome()
    {
        System.out.println("Welcome to Nowhere!");
    }

    /**
     * Sets the maximum height of the buildings
     * @param maxHeight maximum height
     */
    public void setMaxHeight(int maxHeight)
    {
        this.maxHeight = maxHeight;
    }
}