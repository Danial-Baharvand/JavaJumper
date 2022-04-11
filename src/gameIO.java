import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Helper class to read and write from file
 *
 * @author Danial Baharvand
 */
public class gameIO
{
    private int minNameLength;
    private int maxNameLength;
    private int maxBuildings;

    /**
     * Default constructor
     */
    public gameIO()
    {
        minNameLength = 3;
        maxNameLength = 12;
        maxBuildings = 15;
    }

    /**
     * Constructor with parameters
     *
     * @param minNameLenght minimum allowed characters allowed for the name
     * @param maxNameLenght maximum allowed characters allowed for the name
     * @param maxBuildings  maximum number of buildings allowed
     */
    public gameIO(int minNameLenght, int maxNameLenght, int maxBuildings)
    {
        this.minNameLength = minNameLenght;
        this.maxNameLength = maxNameLenght;
        this.maxBuildings = maxBuildings;
    }

    /**
     * Displays the current options of the class
     */
    public void display()
    {
        System.out.println("Min Name Lenght: " + minNameLength + "Max Name Lenght: " + maxNameLength +
                "Max Buildings: " + maxBuildings);
    }

    /**
     * Returns the maximum building limit
     *
     * @return the maximum number of buildings
     */
    public int getMaxBuildings()
    {
        return maxBuildings;
    }

    /**
     * Returns maximum name length
     *
     * @return maximum name length
     */
    public int getMaxNameLength()
    {
        return maxNameLength;
    }

    /**
     * Returns minimum name length
     *
     * @return minimum name length
     */
    public int getMinNameLength()
    {
        return minNameLength;
    }

    /**
     * Prompt the user to enter a name until a valid name has been entered
     *
     * @return player name
     */
    public String getPlayerName()
    {
        String playerName = "";
        Scanner console = new Scanner(System.in);
        while (playerName.length() > maxNameLength || playerName.length() < minNameLength)
        {
            System.out.println("Please enter a name between 3 to 12 characters:");
            playerName = console.nextLine();
        }
        return playerName;
    }

    /**
     * Will return an updater with specific seed of the demo mode is on
     * Will return an updater with random seed of the demo mode is off
     *
     * @return Updater object
     */
    public Updater getUpdater()
    {
        if (Jumper.DEMO_MODE)
        {
            try
            {
                System.out.println("Please enter seed:");
                return new Updater(Integer.parseInt(new Scanner(System.in).nextLine()));
            }
            catch (Exception e)
            {
                System.out.println("Invalid seed!");
            }

        }
        return new Updater();
    }

    /**
     * Reads the buildings construction instructions from a file and constructs an array of buildings
     *
     * @param path the path of the input
     * @return an array of building objects
     */
    public Building[] readBuildings(String path)
    {
        ArrayList<Building> buildings = new ArrayList<>(); // Unknown number of buildings in the file
        try
        {
            FileReader reader = new FileReader(path);
            try
            {
                Scanner fileInput = new Scanner(reader);
                while (fileInput.hasNextLine() && buildings.size() < maxBuildings)
                {
                    buildings.add(new Building(fileInput.nextLine().split(",")));
                }
            } catch (Exception e)
            {
                System.out.println("Input file does not have the correct format! Exiting...");
                System.exit(0);
            } finally
            {
                try
                {
                    reader.close();
                } catch (Exception e)
                {
                    System.out.println("Error in closing the file!");
                }
            }
        } catch (Exception e)
        {
            System.out.println("Error in reading from file! Exiting...");
            System.exit(0);
        }
        return buildings.toArray(new Building[buildings.size()]);
    }

    /**
     * Reads and validated user input for the movement direction of the player
     *
     * @return valid movement direction
     */
    public char readDir()
    {

        Scanner console = new Scanner(System.in);
        String dir = console.nextLine().toLowerCase(); // Accepting both cases as input
        while (dir.length() != 1 || !Arrays.asList(new String[]{"a", "s", "d"}).contains(dir))
        {
            System.out.println("Please enter a valid input:");
            dir = console.nextLine().toLowerCase();
        }
        return dir.charAt(0);
    }

    /**
     * Sets the maximum number of buildings allowed
     *
     * @param maxBuildings maximum number of buildings allowed
     */
    public void setMaxBuildings(int maxBuildings)
    {
        this.maxBuildings = maxBuildings;
    }

    /**
     * Sets the maximum character length allowed for player name
     *
     * @param maxNameLength maximum character length allowed for player name
     */
    public void setMaxNameLength(int maxNameLength)
    {
        this.maxNameLength = maxNameLength;
    }

    /**
     * Sets the minimum character length allowed for player name
     *
     * @param minNameLength minimum character length allowed for player name
     */
    public void setMinNameLength(int minNameLength)
    {
        this.minNameLength = minNameLength;
    }

    /**
     * Writes the game stats to a file after game completion
     *
     * @param player a player object
     */
    public void writeToFile(Player player)
    {
        try
        {
            FileWriter writer = new FileWriter("outcome.txt");
            try
            {
                String value = "Player: " + player.getPlayerName() +
                        " Turns:" + player.getSteps() +
                        " Cells Found: " + player.getCellsFound() +
                        " Game Won: " + player.hasWon() +
                        "\n";
                writer.append(value);
            } catch (Exception e)
            {
                System.out.println("Error in writing to file! Exiting...");
            } finally
            {
                try
                {
                    writer.close();
                } catch (Exception e)
                {
                    System.out.println("Error in closing file! Exiting...");
                }
            }

        } catch (Exception e)
        {
            System.out.println("Error in acquiring file! Exiting...");
        }
    }
}