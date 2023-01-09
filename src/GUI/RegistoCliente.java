package GUI;

import Entidades.Cliente;
import Exceptions.JaExisteUserException;
import Metodos.MetodosAnon;

import javax.swing.*;
import java.awt.*;

public class RegistoCliente extends JFrame {
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
    private final MetodosAnon metodos;

    public RegistoCliente(JFrame frame) {
        frame.setTitle("Registo de Cliente");
        frame.setPreferredSize(new Dimension(500, 500));

        metodos = new MetodosAnon();

        frame.add(RegistarCliente);
        frame.pack();
        frame.setVisible(true);
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

            Cliente user = new Cliente(username, passwd, nome, numCC, nif, telefone, morada, localidade);
            try {
                metodos.addUser(user);

                JOptionPane.showMessageDialog(null, "Registado com sucesso.");
                RegistarCliente.setVisible(false);

                //TODO: Frame Cliente
                new Login(frame);
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
            new Login(frame);
        });
    }

}
