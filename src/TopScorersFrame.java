import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class TopScorersFrame extends JFrame {

    public TopScorersFrame(Player player) {

        setTitle("Top 5 Scorers");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

        StringBuilder sb = new StringBuilder();
        sb.append("===== TOP 5 SCORERS =====\n\n");

        try {

            Connection conn = DatabaseManager.getConnection();

            String sql =
                    "SELECT username, score FROM players ORDER BY score DESC LIMIT 5";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            int rank = 1;

            while (rs.next()) {

                sb.append(rank++)
                  .append(". ")
                  .append(rs.getString("username"))
                  .append(" - ")
                  .append(rs.getInt("score"))
                  .append("\n");

            }

            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        textArea.setText(sb.toString());

        JButton btnBack = new JButton("Back");

        btnBack.addActionListener(e -> {

            dispose();

            new MainMenuFrame(player).setVisible(true);

        });

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(btnBack, BorderLayout.SOUTH);

    }

}