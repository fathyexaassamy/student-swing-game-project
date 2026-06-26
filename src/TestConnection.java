import java.sql.*;

public class TestConnection {

    public static void main(String[] args) {

        try {
            Connection conn = DatabaseManager.getConnection();

            System.out.println("Berhasil terhubung ke PostgreSQL!");

            conn.close();

        } catch (Exception e) {

            System.out.println("Koneksi gagal!");
            e.printStackTrace();

        }

    }

}
