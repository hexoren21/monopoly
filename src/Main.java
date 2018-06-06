import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame game = new JFrame("battletoads double dragon");
        Gameplay gameplay = new Gameplay();
        game.setResizable(false);
        game.setBackground(Color.black);
        game.setBounds(-10, 5, 1400, 700);
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.add(gameplay);
    }
}
