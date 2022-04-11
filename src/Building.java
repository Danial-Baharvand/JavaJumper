/**
 * Repersents a building
 *
 * @author Danial Baharvand
 */
public class Building
{
    private int height;
    private boolean exit;
    private boolean fuel;
    private boolean web;
    private boolean freeze;
    private boolean player;

    /**
     * Default constructor
     */
    public Building()
    {
        height = 1;
        exit = false;
        fuel = false;
        web = false;
        freeze = false;
        player = false;
    }

    /**
     * Constructor with parameters
     *
     * @param params an array of string values corresponding to height, exit, fuel, web and freeze
     *               options of a building in that order.
     */
    public Building(String[] params)
    {
        this.height = Integer.parseInt(params[0]);
        this.exit = Boolean.parseBoolean(params[1]);
        this.fuel = Boolean.parseBoolean(params[2]);
        this.web = Boolean.parseBoolean(params[3]);
        this.freeze = Boolean.parseBoolean(params[4]);
        player = false;
    }

    /**
     * Displays the attributes of the building
     */
    public void display()
    {
        System.out.println("Height: " + height + "Exit: " + exit +
                "Fuel: " + fuel + "Web: " + web +
                "Freeze: " + freeze + "player: " + player);
    }

    /**
     * @return the height of the building
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * @param level the floor of the building which is being processed
     * @return the correct graphical representation of the level for the building
     */
    public String getLevel(int level)
    {
        if (level > height) return "     "; // The sky
        else if (level == height) return getTopFloor();
        return "|   |"; // Middle level
    }

    /**
     * @return the correct graphical repersention for the top of the building
     */
    private String getTopFloor()
    {
        if (Jumper.DEMO_MODE)
        {
            if (web && freeze) return "_W|F_";
            if (web && fuel) return "_W|C_";
            if (freeze && fuel) return "_F|C_";
            if (player && fuel) return "_P|C_";
            if (web && exit) return "_W|E_";
            if (freeze && exit) return "_F|E_";
            if (web && player) return "_W|P_";
            if (freeze && player) return "_F|P_";
            if (web) return "_WEB_";
            if (freeze) return "_FRZ_";
        }
        if (player) return "_PLA_";
        if (exit) return "_EXT_";
        if (fuel) return "_CEL_";
        return "_____";
    }

    /**
     * @return if the building has an exit portal
     */
    public boolean isExit()
    {
        return exit;
    }

    /**
     * @return the building is frozen
     */
    public boolean isFreeze()
    {
        return freeze;
    }

    /**
     * @return if the building has a fuel cell
     */
    public boolean isFuel()
    {
        return fuel;
    }

    /**
     * @return if the player is on the building
     */
    public boolean isPlayer()
    {
        return player;
    }

    /**
     * @return if the building is webbed
     */
    public boolean isWeb()
    {
        return web;
    }

    /**
     * Sets the building to have the exit portal
     *
     * @param exit exit portal
     */
    public void setExit(boolean exit)
    {
        this.exit = exit;
    }

    /**
     * Sets the building to frozen
     *
     * @param freeze frozen status
     */
    public void setFreeze(boolean freeze)
    {
        this.freeze = freeze;
    }

    /**
     * Sets the building to have a fuel cell
     *
     * @param fuel fuel cell
     */
    public void setFuel(boolean fuel)
    {
        this.fuel = fuel;
    }

    /**
     * Sets the buildings height
     *
     * @param height height of the building
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     * Puts the player on the building
     *
     * @param player whether the player is on the building
     */
    public void setPlayer(boolean player)
    {
        this.player = player;
    }

    /**
     * Sets the building to be webbed
     *
     * @param web webbed status of the building
     */
    public void setWeb(boolean web)
    {
        this.web = web;
    }
}