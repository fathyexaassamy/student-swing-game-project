import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL =
            "jdbc:postgresql://localhost:5433/game_project";

    private static final String USER =
            "postgres";

    // GANTI dengan password PostgreSQL milikmu
    private static final String PASSWORD =
            "Sammy2007!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
