package GUI;

import Entidades.Admin;
import Entidades.Cliente;
import Entidades.Dono;
import Entidades.User;
import Exceptions.UserInexistenteException;
import Metodos.MetodosLogin;

import javax.swing.*;

public class Login extends JFrame {
    private JTextField username;
    private JPanel LoginUsers;
    private JPasswordField password;
    private JButton login; //Button
    private JButton limpar; //Button
    private JButton botaoRegisto;
    private final MetodosLogin l;

    public Login(JFrame frame) {
        l = new MetodosLogin();
        frame.add(LoginUsers);
        frame.pack();
        frame.setVisible(true);
        resetDados();
        botaoLogin(frame);
        clicarBotaoRegistar(frame);
    }

    public void resetCampos() {
        username.setText(null);
        password.setText(null);
    }

    public void resetDados() {
        limpar.addActionListener(e -> resetCampos());
    }

    public void botaoLogin(JFrame frame) {
        login.addActionListener(e -> clicarBotaoLogin(frame));
    }

    public void clicarBotaoLogin(JFrame frame) {
        String username, password;
        username = this.username.getText();
        password = String.valueOf(this.password.getPassword());

        try {
            User login = l.login(username, password);

            if (login instanceof Cliente) {
                LoginUsers.setVisible(false);
                //TODO: Frame Cliente
            }

            if (login instanceof Admin) {
                LoginUsers.setVisible(false);
                //TODO: Frame Admin
            }

            if (login instanceof Dono) {
                LoginUsers.setVisible(false);
                //TODO: Frame Admin
            }

        } catch (UserInexistenteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void clicarBotaoRegistar(JFrame frame) {
        botaoRegisto.addActionListener(e -> {
            LoginUsers.setVisible(false);
            //TODO: Frame registo
        });
    }
}
