import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerService {

    public Player login(String username, String password) {

        String sql =
                "SELECT * FROM players WHERE username = ? AND password = ?";

        try {

            Connection conn = DatabaseManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Player(

                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")

                );

            }

            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    public void updatePlayer(Player player) {

        String sql =
                "UPDATE players SET wins=?, losses=?, draws=?, score=? WHERE id=?";

        try {

            Connection conn = DatabaseManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, player.getWins());
            ps.setInt(2, player.getLosses());
            ps.setInt(3, player.getDraws());
            ps.setInt(4, player.getScore());
            ps.setInt(5, player.getId());

            ps.executeUpdate();

            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

}