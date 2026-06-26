import java.awt.*;
import javax.swing.*;

public class MainMenuFrame extends JFrame {

    private Player currentPlayer;

    public MainMenuFrame(Player player) {

        this.currentPlayer = player;

        setTitle("Main Menu");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblWelcome = new JLabel(
                "Welcome, " + currentPlayer.getUsername(),
                SwingConstants.CENTER
        );

        lblWelcome.setFont(new Font("Arial", Font.BOLD, 18));

        JButton btnStartGame = new JButton("Start Game");
        JButton btnStatistics = new JButton("My Statistics");
        JButton btnTopScorers = new JButton("Top 5 Scorers");
        JButton btnLogout = new JButton("Logout");

        JPanel panel = new JPanel(new GridLayout(5,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.add(lblWelcome);
        panel.add(btnStartGame);
        panel.add(btnStatistics);
        panel.add(btnTopScorers);
        panel.add(btnLogout);

        add(panel);

        btnStartGame.addActionListener(e -> {

    dispose();

    new GameFrame(currentPlayer).setVisible(true);

});

        btnStatistics.addActionListener(e -> {

    dispose();

    new StatisticsFrame(currentPlayer).setVisible(true);

});

        btnTopScorers.addActionListener(e -> {

    dispose();

    new TopScorersFrame(currentPlayer).setVisible(true);

});

        btnLogout.addActionListener(e -> {

            dispose();

            new LoginFrame().setVisible(true);

        });

    }

}