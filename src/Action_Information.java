import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action_Information extends JDialog implements ActionListener
{
    private JLabel information_purchase_field;
    private JButton b_accept, b_ok, b_cancel;
    private Card_Enemy card_enemy;
    private String name_player;
    private int lvl_disp = 0;
    private int number_player;

    public Action_Information(JFrame owner, Card_Enemy card_enemy, String name_player, int number_player)
    {
        super(owner,"information",true);
        this.card_enemy = card_enemy;
        this.name_player = name_player;
        this.number_player = number_player;

        setSize(300,200);
        setLayout(null);

    }
    public void follow()
    {
        if (lvl_disp == 0)
        {
            if (card_enemy.getFlag_buy_card())
            {
                information_purchase_field = new JLabel("Wykupiona posiadlosc\nmusisz zaplacic graczowi " + card_enemy.getName_who_buy() + "\nkwote :", JLabel.LEFT);
                information_purchase_field.setBounds(10, 10, 250, 150);
                add(information_purchase_field);

                b_accept = new JButton("OK");
                b_accept.setBounds(260, 170, 40, 20);
                b_accept.addActionListener(this);
                add(b_accept);
            }
            else
            {
                information_purchase_field = new JLabel("Posiadłość do wykupienia", JLabel.LEFT);
                information_purchase_field.setBounds(10, 10, 250, 150);
                add(information_purchase_field);

                b_ok = new JButton("Yes");
                b_ok.setBounds(260, 130, 40, 20);
                b_ok.addActionListener(this);
                add(b_ok);

                b_cancel = new JButton("No");
                b_cancel.setBounds(260, 180, 40, 20);
                b_cancel.addActionListener(this);
                add(b_cancel);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        lvl_disp++;
        Object button = e.getSource();

        if (lvl_disp == 0)
        {
            if (button == b_ok)
            {
             card_enemy.setWho_buy(number_player, name_player);
            }
            else if (button == b_cancel)
            {
                //licytacja
            }
            else if (button == b_accept)
            {
                // pobierz zaplate od gracza
            }
        }

    }
}
