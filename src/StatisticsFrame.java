import java.awt.*;
import javax.swing.*;

public class StatisticsFrame extends JFrame {

    public StatisticsFrame(Player player) {

        setTitle("My Statistics");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsername = new JLabel("Username : " + player.getUsername());
        JLabel lblWins = new JLabel("Wins : " + player.getWins());
        JLabel lblLosses = new JLabel("Losses : " + player.getLosses());
        JLabel lblDraws = new JLabel("Draws : " + player.getDraws());
        JLabel lblScore = new JLabel("Score : " + player.getScore());

        JButton btnBack = new JButton("Back");

        btnBack.addActionListener(e -> {

            dispose();

            new MainMenuFrame(player).setVisible(true);

        });

        panel.add(lblUsername);
        panel.add(lblWins);
        panel.add(lblLosses);
        panel.add(lblDraws);
        panel.add(lblScore);
        panel.add(btnBack);

        add(panel);

    }

}
