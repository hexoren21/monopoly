import javax.swing.*;

public class Player implements Comparable
{
    private ImageIcon player_point;
    private String name;
    private String number_name_player;
    private int points_experience;
    private int number_random_dice;
    private int position;
    private int repeating_the_number_of_eyelets = 0;
    private int stay_in_jail = 0;
    private boolean flag_jail = false;
    static boolean flag_position = false;
    private boolean flag_bonus_for_starting = false;
    private boolean flag_information = false;

    public Player(String name, String number_name_player)
    {
        position = 0;
        points_experience = 1500;
        this.name = name;
        this.number_name_player = number_name_player;
    }
    public void add_stay_in_jail()
    {
        stay_in_jail++;
    }
    public int get_stay_in_jail()
    {
        return stay_in_jail;
    }

    public void exit_jail()
    {
        flag_jail = false;
        flag_information = false;
        stay_in_jail = 0;
        repeating_the_number_of_eyelets = 0;
    }
    public void set_image_icon(ImageIcon player_point)
    {
        this.player_point = player_point;
    }
    public boolean get_flag_information()
    {
        return flag_information;
    }
    public void set_flag_information(boolean flag)
    {
        this.flag_information = flag;
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
    public int get_repeating_the_number_of_eyelets()
    {
        return repeating_the_number_of_eyelets;
    }
    public void reset_repeating_the_number_of_eyelets()
    {
        repeating_the_number_of_eyelets = 0;
    }
    public void set_repeating_the_number_of_eyelets()
    {
        repeating_the_number_of_eyelets++;
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
    public boolean get_flag_jail()
    {
        return flag_jail;
    }
    public void set_flag_jail(boolean flag)
    {
        this.flag_jail = flag;
    }
    public void add_position(int number_random_dice)
    {
        if (flag_jail) return;
        int position1;
        position1 = position = position + number_random_dice;
        position = position % 40;
        if (position1 > position) flag_bonus_for_starting = true;
    }
    public void set_position(int position)
    {
        this.position = position;
        flag_bonus_for_starting = false;
    }
    public boolean get_flag_bonus_for_start()
    {
        return flag_bonus_for_starting;
    }
    public void set_flag_bonus_for_start()
    {
        flag_bonus_for_starting = false;
        points_experience += 200;
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
