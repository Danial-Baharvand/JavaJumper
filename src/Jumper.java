/**
 * The class Jumper represents an instance of the game
 *
 * @author Danial Baharvand
 */
public class Jumper
{
    public static final boolean DEMO_MODE = false;
    private Building[] buildings;
    private Player player;

    /**
     * Default constructor
     */
    public Jumper()
    {
        gameIO gameIO = new gameIO();
        buildings = gameIO.readBuildings("buildings.txt");
        player = new Player(buildings, gameIO.getPlayerName());
    }

    /**
     * Constructor with parameters
     *
     * @param buildings an array of building objects
     * @param player    a player object
     */
    public Jumper(Building[] buildings, Player player)
    {
        this.buildings = buildings;
        this.player = player;
    }

    /**
     * The main method of the program
     * Sets up the game and and required objects and contains the main loop of the game
     */
    public static void main(String[] args)
    {
        Display dp = new Display();
        dp.printWelcome(); // Added after video demo
        Jumper jumper = new Jumper();
        jumper.buildings[jumper.player.getPlayerLocation()].setPlayer(true);
        gameIO gameIO = new gameIO();
        Updater updater = gameIO.getUpdater();
        dp.drawStatsMenu(jumper.player);
        dp.drawBuildings(jumper.buildings);
        char dir = ' ';
        while (jumper.player.getFuel() > 0 && !jumper.player.hasWon()) // Main loop
        {
            dp.printOptions(jumper);
            dir = gameIO.readDir();
            jumper.player.movePlayer(dir);
            jumper.player.setWon(jumper.player.update());
            updater.update(jumper.buildings);
            dp.drawStatsMenu(jumper.player);
            dp.drawBuildings(jumper.buildings);
        }
        gameIO.writeToFile(jumper.player);
        dp.printGoodbye(jumper.player);
    }

    /**
     * Displays the player and number of buildings in the game
     */
    public void display()
    {
        player.display();
        System.out.println("The game has " + buildings.length + "buildings.");
    }

    /**
     * @return the array of buildings
     */
    public Building[] getBuildings()
    {
        return buildings;
    }

    /**
     * @return the player object
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * Sets the buildings of the game
     *
     * @param buildings array of buildings
     */
    public void setBuildings(Building[] buildings)
    {
        this.buildings = buildings;
    }

    /**
     * Sets the player of the game
     *
     * @param player player object
     */
    public void setPlayer(Player player)
    {
        this.player = player;
    }
}