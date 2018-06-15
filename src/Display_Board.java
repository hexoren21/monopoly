import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;


public class Display_Board extends JPanel implements ActionListener, KeyListener
{
    private ImageIcon board;
    private ImageIcon player1_point;
    private ImageIcon player2_point;
    private ImageIcon player3_point;
    private ImageIcon player4_point;
    private ImageIcon one_eyelet;
    private ImageIcon two_eyelet;
    private ImageIcon three_eyelet;
    private ImageIcon four_eyelet;
    private ImageIcon five_eyelet;
    private ImageIcon six_eyelet;

    private ArrayList<Player> list;
    private ArrayList<ImageIcon> eyelet = new ArrayList<ImageIcon>(6);
    private ArrayList<String> name_player = new ArrayList<String>(4);
    private int[] x_pos_1 = {1050, 950, 860, 760, 660, 560, 460, 370, 270, 180, 30, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80,
            220, 320, 410, 510, 610, 700, 800, 890, 990, 1120, 1120, 1120, 1120, 1120, 1120, 1120, 1120, 1120, 1120};
    private int[] y_pos_1 = {660, 660, 660, 660, 660, 660, 660, 660, 660, 660, 660, 570, 510, 455, 395, 335, 275, 220, 160, 100, 20,
            20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 130, 190, 250, 310, 370, 430, 485, 545, 605};
    private int[] x_pos_2 = {1090, 990, 900, 800, 700, 600, 500, 410, 310, 220, 70, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80,
            170, 270, 360, 460, 560, 650, 750, 840, 940, 1070, 1070, 1070, 1070, 1070, 1070, 1070, 1070, 1070, 1070};
    private int[] y_pos_2 = {660, 660, 660, 660, 660, 660, 660, 660, 660, 660, 660, 600, 540, 485, 425, 365, 305, 250, 190, 130, 50,
            20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 130, 190, 250, 310, 370, 430, 485, 545, 605};
    private int[] x_pos_3 = {1050, 950, 860, 760, 660, 560, 460, 370, 270, 180, 30, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
            220, 320, 410, 510, 610, 700, 800, 890, 990, 1120, 1120, 1120, 1120, 1120, 1120, 1120, 1120, 1120, 1120};
    private int[] y_pos_3 = {690, 690, 690, 690, 690, 690, 690, 690, 690, 690, 690, 570, 510, 455, 395, 335, 275, 220, 160, 100, 20,
            50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 130, 160, 220, 280, 340, 400, 455, 515, 575};
    private int[] x_pos_4 = {1090, 990, 900, 800, 700, 600, 500, 410, 310, 220, 70, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
            170, 270, 360, 460, 560, 650, 750, 840, 940, 1070, 1070, 1070, 1070, 1070, 1070, 1070, 1070, 1070, 1070};
    private int[] y_pos_4 = {690, 690, 690, 690, 690, 690, 690, 690, 690, 690, 690, 600, 540, 485, 425, 365, 305, 250, 190, 130, 50,
            50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 100, 160, 220, 280, 340, 400, 455, 515, 575};

    private int amount_player;
    private int number_player = 1;
    private int dice_first;
    private int dice_last;

    private boolean flag_sequence = true;
    private boolean flag_random_sequence = false;
    private boolean flag_disp_sequencce = false;
    private boolean flag_move = false;
    Random random = new Random();

    public Display_Board(ArrayList<Player> list, int amount_player)
    {
        board = new ImageIcon("monopoly-plansza.jpg");
        one_eyelet = new ImageIcon("1_oczko.png");
        two_eyelet = new ImageIcon("2_oczko.png");
        three_eyelet = new ImageIcon("3_oczko.png");
        four_eyelet = new ImageIcon("4_oczko.png");
        five_eyelet = new ImageIcon("5_oczko.png");
        six_eyelet = new ImageIcon("6_oczko.png");
        name_player.addAll(Arrays.asList("Player 1", "Player 2", "Player 3", "Player 4"));
        eyelet.addAll(Arrays.asList(one_eyelet, two_eyelet, three_eyelet, four_eyelet, five_eyelet, six_eyelet));

        this.amount_player = amount_player;
        this.list = list;
        set_icon();
        setFocusable(true);
        addKeyListener(this);


    }
    public void paint(Graphics g)
    {

        board.paintIcon(this, g, 0, 0);
        g.setColor(Color.WHITE);
        g.fillRect(480, 180, 260,170);

        if (flag_sequence)
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("arial", Font.PLAIN, 14));
            g.drawString("Random sequence", 560, 300);
            g.drawString("Press enter to random number", 520, 325);
        }
        if (flag_random_sequence)
        {
            dice_first = random.nextInt(6);
            dice_last = random.nextInt(6);
            list.get(number_player - 1).add_number_random_dice(dice_first + dice_last + 2);

            eyelet.get(dice_first).paintIcon(this, g, 505, 180);
            eyelet.get(dice_last).paintIcon(this, g, 625, 180);

            g.setColor(Color.BLACK);
            g.setFont(new Font("arial", Font.PLAIN, 14));
            g.drawString("Press enter to random number", 520, 325);

            g.setColor(Color.YELLOW);
            g.setFont(new Font("arial", Font.BOLD, 12));
            g.drawString(name_player.get(number_player-1), 920, 125);
        }
        if (flag_disp_sequencce)
        {
            Collections.sort(list);
            g.setColor(Color.BLACK);
            g.setFont(new Font("arial", Font.PLAIN, 14));
            g.drawString("kolejność losowania wynosi:", 530, 200);
            int temp = 20; // dodanie do wartosci y aby tekst sie nie zlewal
            for (Player i : list)
            {
                g.drawString(i.get_number_name_player(), 530, 200 + temp);
                temp = temp + 20;
            }
            list.get(0).change_flag_position(true);
        }
        if (flag_move)
        {
            //losowanie i wyswietlenie kosci
            dice_first = random.nextInt(6);
            dice_last = random.nextInt(6);
            eyelet.get(dice_first).paintIcon(this, g, 505, 180);
            eyelet.get(dice_last).paintIcon(this, g, 625, 180);
            list.get(number_player - 1).add_number_random_dice(dice_first + dice_last + 2);
            //wyswietlenie pozycji gracza
            disp_player_point(g);
            //sprawdzenie regul
            check_rules();
            //prawy gorny pasek
            g.setColor(Color.YELLOW);
            g.setFont(new Font("arial", Font.BOLD, 12));
            g.drawString(list.get(number_player-1).get_number_name_player() + "  exp:" +list.get(number_player-1).get_points_experience(), 920, 125);
            next_player();
        }
        g.dispose();
    }
    public void check_rules()
    {
        if (list.get(number_player-1).get_flag_bonus_for_start())
        {
            list.get(number_player-1).set_flag_bonus_for_start();
        }
    }
    public void set_icon()
    {
        switch (amount_player)
        {
            case 4:
            {
                list.get(3).set_image_icon(new ImageIcon("player4_point.png"));
            }
            case 3:
            {
                list.get(2).set_image_icon(new ImageIcon("player3_point.png"));
            }
            case 2:
            {
                list.get(1).set_image_icon(new ImageIcon("player2_point.png"));
                list.get(0).set_image_icon(new ImageIcon("player1_point.png"));
            }
        }
    }
    public void disp_player_point(Graphics g)
    {
        switch (amount_player)
        {
            case 4:
            {
                list.get(3).get_imageIcon().paintIcon(this, g, x_pos_4[list.get(3).get_possition()], y_pos_4[list.get(3).get_possition()]);
            }
            case 3:
            {
                list.get(2).get_imageIcon().paintIcon(this, g, x_pos_3[list.get(2).get_possition()], y_pos_3[list.get(2).get_possition()]);
            }
            case 2:
            {
                list.get(1).get_imageIcon().paintIcon(this, g, x_pos_2[list.get(1).get_possition()], y_pos_2[list.get(1).get_possition()]);
                list.get(0).get_imageIcon().paintIcon(this, g, x_pos_1[list.get(0).get_possition()], y_pos_1[list.get(0).get_possition()]);
            }
        }

    }
    public boolean next_player()
    {
        this.number_player++;
        if (number_player > amount_player)
        {
            this.number_player = 1;
            return true;
        }
        return false;
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
            if (flag_sequence)
            {
                flag_sequence = false;
                flag_random_sequence = true;
            }
            else if (flag_random_sequence)
            {

                if (next_player())
                {
                    flag_random_sequence = false;
                    flag_disp_sequencce = true;
                }
            }
            else if (flag_disp_sequencce)
            {
                flag_disp_sequencce = false;
                flag_move = true;
            }
            else if (flag_move)
            {

            }

        }
        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
