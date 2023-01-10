package GUI;

import Entidades.Admin;
import Entidades.Cliente;
import Entidades.Dono;
import Entidades.User;
import Exceptions.JaExisteUserException;
import Metodos.MetodosUser;

import javax.swing.*;
import java.awt.*;

public class AdicionarUserAdmin extends JFrame {
    private JPanel RegistarCliente;
    private JTextField username;
    private JPasswordField password;
    private JTextField nome;
    private JTextField numCC;
    private JTextField nif;
    private JTextField telefone;
    private JTextField morada;
    private JTextField localidade;
    private JButton BotaoRegistar;
    private JButton BotaoLimpar;
    private JButton BotaoVoltar;
    private String userType;

    public AdicionarUserAdmin(JFrame frame, String userType) {
        frame.setTitle("Registo de Cliente");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(RegistarCliente);
        frame.pack();
        frame.setVisible(true);

        this.userType = userType;

        registarCliente(frame);
        limparDados();
        voltar(frame);
    }

    public void registarCliente(JFrame frame) {
        BotaoRegistar.addActionListener(e -> {
            String username = this.username.getText();
            String passwd = String.valueOf(password.getPassword());
            String nome = this.nome.getText();
            int numCC = Integer.parseInt(this.numCC.getText());
            int telefone = Integer.parseInt(this.telefone.getText());
            String morada = this.morada.getText();
            String localidade = this.localidade.getText();
            int nif = Integer.parseInt(this.nif.getText());

            User user;
            try {
                if (userType.equals("Cliente")) {
                    user = new Cliente(username, passwd, nome, numCC, nif, telefone, morada, localidade);
                    MetodosUser.addUser(user);
                }

                if (userType.equals("Admin")) {
                    user = new Admin(username, passwd, nome, numCC, nif, telefone, morada, localidade);
                    MetodosUser.addUser(user);
                }

                if (userType.equals("Dono")) {
                    user = new Dono(username, passwd, nome, numCC, nif, telefone, morada, localidade);
                    MetodosUser.addUser(user);
                }

                JOptionPane.showMessageDialog(null, "Registado com sucesso.");
                RegistarCliente.setVisible(false);

                new OpcoesAdmin(frame);
            } catch (JaExisteUserException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        });
    }

    public void limparDados() {
        BotaoLimpar.addActionListener(e -> {
            localidade.setText(null);
            username.setText(null);
            morada.setText(null);
            nome.setText(null);
            nif.setText(null);
            numCC.setText(null);
            telefone.setText(null);
            password.setText(null);
        });
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            RegistarCliente.setVisible(false);
            new AdicionarTipoUser(frame);
        });
    }

}
