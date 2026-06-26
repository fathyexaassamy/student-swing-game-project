import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {

    private Player currentPlayer;
    private GameLogic game;

    private JButton[][] buttons;

    private JLabel lblTurn;

    public GameFrame(Player player) {

        this.currentPlayer = player;
        this.game = new GameLogic();

        setTitle("Tic Tac Toe");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        lblTurn = new JLabel(
                "Current Turn : " + game.getCurrentPlayer(),
                SwingConstants.CENTER
        );

        lblTurn.setFont(new Font("Arial", Font.BOLD, 18));

        add(lblTurn, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel();

        boardPanel.setLayout(new GridLayout(3,3));

        buttons = new JButton[3][3];

        Font font = new Font("Arial", Font.BOLD, 48);

        for(int row = 0; row < 3; row++){

            for(int col = 0; col < 3; col++){

                JButton button = new JButton("");

                button.setFont(font);

                final int r = row;
                final int c = col;

                button.addActionListener(e -> {

                    handleMove(r,c);

                });

                buttons[row][col] = button;

                boardPanel.add(button);

            }

        }

        add(boardPanel, BorderLayout.CENTER);

        JButton btnBack = new JButton("Back");

        btnBack.addActionListener(e->{

            dispose();

            new MainMenuFrame(currentPlayer).setVisible(true);

        });

        add(btnBack,BorderLayout.SOUTH);
    }
            private void handleMove(int row, int col) {

    char player = game.getCurrentPlayer();

    if (!game.makeMove(row, col)) {
        return;
    }

    buttons[row][col].setText(String.valueOf(player));

    if (game.checkWinner()) {

        String message;
        PlayerService service = new PlayerService();

        if (player == 'X') {

            message = currentPlayer.getUsername() + " Wins!";

            currentPlayer.setWins(currentPlayer.getWins() + 1);
            currentPlayer.setScore(currentPlayer.getScore() + 10);

        } else {

            message = "Player O Wins!";

            currentPlayer.setLosses(currentPlayer.getLosses() + 1);

        }

        service.updatePlayer(currentPlayer);

        JOptionPane.showMessageDialog(this, message);

        dispose();
        new MainMenuFrame(currentPlayer).setVisible(true);
        return;
    }

    if (game.isBoardFull()) {

        currentPlayer.setDraws(currentPlayer.getDraws() + 1);
        currentPlayer.setScore(currentPlayer.getScore() + 3);

        PlayerService service = new PlayerService();
        service.updatePlayer(currentPlayer);

        JOptionPane.showMessageDialog(this, "Draw!");

        dispose();
        new MainMenuFrame(currentPlayer).setVisible(true);
        return;
    }

    game.switchPlayer();
    lblTurn.setText("Current Turn : " + game.getCurrentPlayer());
}

}


