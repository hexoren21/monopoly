import javax.swing.*;

public class Player implements Comparable
{
    private ImageIcon player_point;
    private String name;
    private String number_name_player;
    private int points_experience;
    private int number_random_dice;
    private int position;
    static boolean flag_position = false;
    public Player(String name, String number_name_player)
    {
        position = 0;
        points_experience = 1500;
        this.name = name;
        this.number_name_player = number_name_player;
    }
    public void set_image_icon(ImageIcon player_point)
    {
        this.player_point = player_point;
    }
    public ImageIcon get_imageIcon()
    {
        return player_point;
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
    public void add_number_random_dice(int number)
    {
        if (flag_position)
            add_position(number);
        this.number_random_dice = number;
    }
    public void change_flag_position(boolean flag)
    {
        this.flag_position = flag;
    }
    public int get_Number_random_dice()
    {
        return number_random_dice;
    }
    public String get_name()
    {
        return name;
    }
    public String get_number_name_player()
    {
        return number_name_player;
    }
    public void add_position(int number_random_dice)
    {
        position = position + number_random_dice;
        position = position % 40;
    }
    public int get_possition()
    {
        return position;
    }

    @Override
    public int compareTo(Object o)
    {
        int compare_random_number_dice = ((Player)o).get_Number_random_dice();
        return compare_random_number_dice - this.number_random_dice;
    }
    @Override
    public String toString()
    {
        return "Nazwa gracza: " + number_name_player + " ilosc oczek: " + number_random_dice;
    }
}
