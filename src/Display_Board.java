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
    private ImageIcon one_eyelet;
    private ImageIcon two_eyelet;
    private ImageIcon three_eyelet;
    private ImageIcon four_eyelet;
    private ImageIcon five_eyelet;
    private ImageIcon six_eyelet;

    private ArrayList<Player> list;
    private ArrayList<ImageIcon> eyelet = new ArrayList<>(6);
    private ArrayList<String> name_player = new ArrayList<>(4);
    private ArrayList<Card_Enemy> list_card_enemy = new ArrayList<>(22);
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
    private boolean flag_prepare_player = true;
    private boolean flag_next_random = false;
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
        list_card_enemy.addAll(Arrays.asList(new Card_Enemy(60, 1), new Card_Enemy(60,3), new Card_Enemy(100, 6), new Card_Enemy(100,8), new Card_Enemy(120,9),
                                             new Card_Enemy(140,11),new Card_Enemy(140,13), new Card_Enemy(160,14), new Card_Enemy(180,16), new Card_Enemy(180,18),
                                             new Card_Enemy(200,19), new Card_Enemy(220,21), new Card_Enemy(220,23), new Card_Enemy(240,24), new Card_Enemy(260,26),
                                             new Card_Enemy(260,27), new Card_Enemy(280,29), new Card_Enemy(300,31), new Card_Enemy(300,32), new Card_Enemy(330,34),
                                             new Card_Enemy(350,37), new Card_Enemy(400,39)));
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
            // funkcj ktora automatycznie wychodzi z wiezieznia po trzech kolejkach
            if (list.get(number_player - 1).get_stay_in_jail() == 3)
            {
                buy_exit_jail();
            }
            else if(list.get(number_player - 1).get_flag_information())
            {
                check_flag_deposit(g);
            }
            else if (flag_prepare_player)
            {
                flag_prepare_player = false;

                g.setColor(Color.BLACK);
                g.setFont(new Font("arial", Font.PLAIN, 14));
                g.drawString("Player " + number_player, 520, 305);
                g.drawString("Press enter to random dice", 520, 325);
                //ustaw wyswietlenie na przygotowanie gracza do nacisniecia enteru i wylosowanie kosci
            }
            else if(!list.get(number_player - 1).get_flag_information())
            {
                flag_prepare_player = true;
                if (list.get(number_player - 1).get_flag_jail())
                    list.get(number_player - 1).set_flag_information(true);
                //losowanie i wyswietlenie kosci
                dice_first = random.nextInt(6);
                dice_last = random.nextInt(6);
                eyelet.get(dice_first).paintIcon(this, g, 505, 180);//zmienic na dice first i last
                eyelet.get(dice_last).paintIcon(this, g, 625, 180);
                list.get(number_player - 1).add_number_random_dice(dice_first + dice_last+2);//dice_first + dice_last +
                //wyswietlenie pozycji gracza
                check_rules(g);
                //sprawdzenie regul
                //prawy gorny pasek
                if (!flag_next_random)
                    next_player();
            }
            g.setColor(Color.YELLOW);
            g.setFont(new Font("arial", Font.BOLD, 12));
            g.drawString(list.get(number_player - 1).get_number_name_player() + "  exp:" + list.get(number_player - 1).get_points_experience(), 920, 125);
            disp_player_point(g);
        }
        g.dispose();
    }




    public void check_flag_deposit(Graphics g)
    {
        if(list.get(number_player-1).get_flag_jail() )
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("arial", Font.PLAIN, 14));
            g.drawString("Player " + number_player, 520, 305);
            g.drawString("Wykupienie kaucji", 520, 325);
            g.drawString("Lewo = nie lub Prawo = tak ", 520, 345);
        }
    }
    public void check_rules(Graphics g)
    {
        //sprawdzanie potrojnej tej samej ilosci oczek
        check_same_number();
        if ((list.get(number_player-1).get_repeating_the_number_of_eyelets() == 3) || (list.get(number_player-1).get_possition() == 30 ))
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("arial", Font.PLAIN, 14));
            g.drawString("Idziesz do wiezienia", 520, 325);
            list.get(number_player-1).set_repeating_the_number_of_eyelets();
            list.get(number_player-1).set_position(10);
            list.get(number_player-1).set_flag_jail(true);
            list.get(number_player-1).set_flag_information(true);
            flag_next_random = false;
            return;
        }
        //wyjscie z wiezienia
        if (list.get(number_player-1).get_flag_jail())
        {
            if (dice_first == dice_last)
            {
                list.get(number_player - 1).exit_jail();
                list.get(number_player - 1).set_repeating_the_number_of_eyelets();
            }
            else
            {
                list.get(number_player - 1).add_stay_in_jail();
            }
        }
        //sprawdzenie przejscia przez start
        if (list.get(number_player-1).get_flag_bonus_for_start())
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("arial", Font.PLAIN, 14));
            g.drawString("Bonus za przejscie przez start", 520, 325);
            list.get(number_player-1).set_flag_bonus_for_start();
        }
        for (Card_Enemy i : list_card_enemy)
        {
            if (i.getCard_position() == list.get(number_player-1).get_possition())
            {
                if (i.getFlag_buy_card())
                {

                }
                break;
            }
        }


    }
    public void check_same_number()
    {
        if (dice_first == dice_last)
        {
            list.get(number_player - 1).set_repeating_the_number_of_eyelets();
            flag_next_random = true;
        }
        else
        {
            list.get(number_player - 1).reset_repeating_the_number_of_eyelets();
            flag_next_random = false;
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
    public void buy_exit_jail()
    {
        list.get(number_player - 1).exit_jail();
        list.get(number_player - 1).remove_points(50);
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
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if (list.get(number_player - 1).get_flag_jail())
                buy_exit_jail();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            if (list.get(number_player - 1).get_flag_jail())
                 list.get(number_player - 1).set_flag_information(false);
        }
        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
