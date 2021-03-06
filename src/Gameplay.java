import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Gameplay extends JPanel implements ActionListener, KeyListener
{
    Timer timer;
    private int delay = 100;
    JFrame main_choose_player;
    JFrame game_board;
    private boolean flag_start_stage = true;
    private boolean flag_amount_player = false;
    private boolean flag_choose_player = false;
    private boolean flag_play_game = false;

    private int number_of_player = 0;
    private int number_of_player_x = 600;
    private int[] number_of_player_y = {285, 315, 345};
    private ImageIcon main_background;
    private ImageIcon amount_choose;

    private ArrayList<Player> list = new ArrayList<Player>(1);

    public Gameplay()
    {
        setFocusable(true);
        addKeyListener(this);
    }


    public void paint(Graphics g)
    {
        main_background = new ImageIcon("main_board1.png");
        main_background.paintIcon(this, g, 0,0);

        //start stage
        if (flag_start_stage)
        {
            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", Font.BOLD, 25));
            g.drawString("Press enter to start",600, 270 );
        }
        //player choose
        if (flag_amount_player)
        {
            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", Font.BOLD, 25));
            g.drawString("Choose number player", 580, 270);

            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", Font.BOLD, 25));
            g.drawString("2 player", 650, 300);
            g.setColor(Color.white);
            g.setFont(new Font("arial", Font.BOLD, 25));
            g.drawString("3 player", 650, 330);
            g.setColor(Color.white);
            g.setFont(new Font("arial", Font.BOLD, 25));
            g.drawString("4 player", 650, 360);
//
            amount_choose = new ImageIcon("choose_.png");
            amount_choose.paintIcon(this, g, number_of_player_x, number_of_player_y[number_of_player]);
        }

        if (flag_choose_player)
        {
            if (main_choose_player == null)
            {
                main_choose_player = new JFrame();
                Choose_Player choose_player = new Choose_Player(number_of_player + 2, this);
                main_choose_player.setVisible(true);
                main_choose_player.setBounds(92, 0, 1182, 735);
                main_choose_player.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                main_choose_player.add(choose_player);
            }
        }

        if (flag_play_game)
        {
            if (game_board == null)
            {
                game_board = new JFrame();
                Display_Board display_board = new Display_Board(list, number_of_player + 2);
                game_board.setVisible(true);
                game_board.setBounds(92, -30, 1200, 760);
                game_board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                game_board.add(display_board);
            }
        }
        g.dispose();
    }

    public void exit_main_choose_player()
    {
        main_choose_player.dispose();
    }
    public void add_list_player(Player player)
    {
        list.add(player);
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
            if (flag_start_stage)
            {
                flag_start_stage = false;
                flag_amount_player = true;
            }
            else if (flag_amount_player)
            {
                flag_amount_player = false;
                flag_choose_player = true;
            }
            else if (flag_choose_player)
            {
                flag_choose_player = false;
                flag_play_game = true;
            }
            repaint();

        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            if (flag_amount_player)
           {
               number_of_player--;
               if (number_of_player == -1) number_of_player = 2;

           }

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if (flag_amount_player)
            {
                number_of_player++;
                if (number_of_player == 3) number_of_player = 0;
            }

        }
        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
