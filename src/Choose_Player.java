import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Choose_Player extends JPanel implements ActionListener, KeyListener
{
    Gameplay gameplay;
    private int position = 0;
    private int position_end = 4;
    private ArrayList<Integer> x_position_player = new ArrayList<>(5);
    private ArrayList<Integer> y_position_player = new ArrayList<>(5);
    private ArrayList<String> name_player = new ArrayList<>(5);
    private String[] tab_name = {"Player 1", "Player 2", "Player 3", "Player 4"};
    private int amount_player;
    private int number_player = 1;

    private int player1_x;
    private int player1_y;
    private int player2_x;
    private int player2_y;
    private int player3_x;
    private int player3_y;

    private ImageIcon background;
    private ImageIcon player1_window;
    private ImageIcon player2_window;
    private ImageIcon player3_window;
    private ImageIcon player4_window;

    public Choose_Player(int amount_player, Gameplay gameplay)
    {
        background = new ImageIcon("choose_player.jpg");
        player1_window = new ImageIcon("player1_window.png");
        player2_window = new ImageIcon("player2_window.png");
        player3_window= new ImageIcon("player3_window.png");
        player4_window = new ImageIcon("player4_window.png");
        x_position_player.addAll(Arrays.asList(60, 429, 798, 207, 650));
        y_position_player.addAll(Arrays.asList(103, 103, 103, 420, 420));
        name_player.addAll(Arrays.asList("RASH", "ZITZ", "PIMPlE", "BILLY", "JIMMY"));
        this.gameplay = gameplay;
        this.amount_player = amount_player;
        setFocusable(true);
        addKeyListener(this);
    }

    public void paint(Graphics g)
    {

        background.paintIcon(this, g, 0, 0);


        if (number_player == 1)
        {
            player1_window.paintIcon(this, g, x_position_player.get(position), y_position_player.get(position));
        }
        if (number_player == 2)
        {
            player1_window.paintIcon(this, g, player1_x, player1_y);
            player2_window.paintIcon(this, g, x_position_player.get(position), y_position_player.get(position));
        }
        if (number_player == 3 && number_player <= amount_player)
        {
            player1_window.paintIcon(this, g, player1_x, player1_y);
            player2_window.paintIcon(this, g, player2_x, player2_y);
            player3_window.paintIcon(this, g, x_position_player.get(position), y_position_player.get(position) );
        }
        if (number_player == 4 && number_player <= amount_player)
        {
            player1_window.paintIcon(this, g, player1_x, player1_y);
            player2_window.paintIcon(this, g, player2_x, player2_y);
            player3_window.paintIcon(this, g, player3_x, player3_y);
            player4_window.paintIcon(this, g, x_position_player.get(position), y_position_player.get(position) );
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if (number_player == 1)
            {
                player1_x = x_position_player.remove(position);
                player1_y = y_position_player.remove(position);
            }
            else if (number_player == 2)
            {
                player2_x = x_position_player.remove(position);
                player2_y = y_position_player.remove(position);
            }
            else if (number_player == 3)
            {
                player3_x = x_position_player.remove(position);
                player3_y = y_position_player.remove(position);
            }

            gameplay.add_list_player(new Player(name_player.remove(position), tab_name[number_player-1] ));
            if (number_player == amount_player)
            {
                gameplay.exit_main_choose_player();
            }
            position = 0;
            position_end--;
            number_player++;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            position--;
            if (position < 0)
                position = position_end;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            position++;
            if (position > position_end)
                position = 0;
        }
        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
