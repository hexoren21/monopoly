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
    private String[] name_player = {"RASH", "ZITZ", "PIMPlE", "BILLY", "JIMMY"};
    private int amount_player;
    private int number_player = 1;

    private ImageIcon background;
    private ImageIcon player1_window;
    private ImageIcon player2_window;
    private ImageIcon player3_window;
    private ImageIcon player4_window;

    public Choose_Player(int amount_player, Gameplay gameplay)
    {
        x_position_player.addAll(Arrays.asList(60, 429, 798, 207, 650));
        y_position_player.addAll(Arrays.asList(103, 103, 103, 420, 420));
        this.gameplay = gameplay;
        this.amount_player = amount_player;
        setFocusable(true);
        addKeyListener(this);
    }

    public void paint(Graphics g)
    {
        background = new ImageIcon("choose_player.jpg");
        background.paintIcon(this, g, 0, 0);
        player1_window = new ImageIcon("player1_window.png");
        player1_window.paintIcon(this, g, x_position_player.get(position), y_position_player.get(position));
        x_position_player.remove(position);
        y_position_player.remove(position);
        position_end--;
        if (number_player == 2)
        {
            player2_window = new ImageIcon("player2_window.png");
            player2_window.paintIcon(this, g, x_position_player.get(position), y_position_player.get(position) );
        }
        if (number_player == 3 && number_player <= amount_player)
        {
            player3_window= new ImageIcon("player2_window.png");
            player3_window.paintIcon(this, g, x_position_player.get(position), y_position_player.get(position) );
        }
        if (number_player == 4 && number_player <= amount_player)
        {
            player4_window = new ImageIcon("player2_window.png");
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
            if (number_player == amount_player)
            {
                gameplay.exit_main_choose_player();
            }
            gameplay.add_list_player(new Player(name_player[position]));
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
