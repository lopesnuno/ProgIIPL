package GUI;

import Entidades.Admin;
import Entidades.Cliente;
import Entidades.Dono;
import Entidades.User;
import Exceptions.UserInexistenteException;
import Metodos.MetodosLogin;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JTextField username;
    private JPanel LoginUsers;
    private JPasswordField password;
    private JButton BotaoLogin;
    private JButton BotaoLimpar;
    private JButton BotaoRegisto;
    private final MetodosLogin l;

    public Login(JFrame frame) {
        frame.setTitle("Gestão de Stand de Automóveis");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(LoginUsers);
        frame.pack();
        frame.setVisible(true);

        l = new MetodosLogin();

        resetDados();
        login(frame);
        clickBotaoRegistar(frame);
    }

    public void resetDados() {
        BotaoLimpar.addActionListener(e -> {
            username.setText(null);
            password.setText(null);
        });
    }

    public void login(JFrame frame) {
        BotaoLogin.addActionListener(e -> {
            String username, password;
            username = this.username.getText();
            password = String.valueOf(this.password.getPassword());

            try {
                User login = l.login(username, password);

                if (login instanceof Cliente) {
                    LoginUsers.setVisible(false);
                    new OpcoesCliente(frame);
                }

                if (login instanceof Admin) {
                    LoginUsers.setVisible(false);
                    new OpcoesAdmin(frame);
                }

                if (login instanceof Dono) {
                    LoginUsers.setVisible(false);
                    new OpcoesDono(frame);
                }

            } catch (UserInexistenteException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        });
    }

    public void clickBotaoRegistar(JFrame frame) {
        BotaoRegisto.addActionListener(e -> {
            LoginUsers.setVisible(false);
            new RegistoCliente(frame);
        });
    }
}
