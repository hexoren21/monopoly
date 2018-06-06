public class Player
{
    private String name;
    private int points_experience;
    public Player(String name)
    {
        points_experience = 1500;
        this.name = name;
    }

    public void add_points(int points)
    {
        points_experience += points;
    }
    public void remove_points(int points)
    {
        points_experience -= points;
    }
    public int get_points_experience()
    {
        return points_experience;
    }

}
