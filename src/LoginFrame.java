import java.awt.*;
import javax.swing.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginFrame() {

        setTitle("Tic Tac Toe Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        btnLogin = new JButton("Login");

        panel.add(lblUsername);
        panel.add(txtUsername);

        panel.add(lblPassword);
        panel.add(txtPassword);

        panel.add(new JLabel());
        panel.add(btnLogin);

        add(panel);

        // Event tombol Login
        btnLogin.addActionListener(e -> {

            String username = txtUsername.getText().trim();
            String password = new String(txtPassword.getPassword());

            if (username.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Username dan Password harus diisi!"
                );

                return;
            }

            PlayerService service = new PlayerService();
            Player player = service.login(username, password);

            if (player != null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login berhasil. Selamat datang " + player.getUsername()
                );

                MainMenuFrame menu = new MainMenuFrame(player);
                menu.setVisible(true);

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Username atau Password salah!"
                );

            }

        });

    }

}