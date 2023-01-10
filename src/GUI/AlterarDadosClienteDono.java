package GUI;

import Entidades.User;
import Exceptions.AlterarDadosException;
import Metodos.MetodosUser;
import Repositorio.RepositorioSerializable;

import javax.swing.*;
import java.awt.*;

public class AlterarDadosClienteDono extends JFrame {
    private JPanel AlterarDadosCliente;
    private JTextField username;
    private JPasswordField password;
    private JTextField nome;
    private JTextField numCC;
    private JTextField nif;
    private JTextField telefone;
    private JTextField morada;
    private JTextField localidade;
    private JButton BotaoAlterar;
    private JButton BotaoLimpar;
    private JButton BotaoVoltar;

    public AlterarDadosClienteDono(JFrame frame, User user) {
        frame.setTitle("Alterar Dados");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.add(AlterarDadosCliente);
        frame.pack();
        frame.setVisible(true);
        limpar();
        voltar(frame);
        alterarDados(frame, user);

        username.setText(user.getUsername());
        password.setText(user.getPassword());
        nome.setText(user.getNome());
        numCC.setText(String.valueOf(user.getNumCC()));
        nif.setText(String.valueOf(user.getNIF()));
        telefone.setText(String.valueOf(user.getTelefone()));
        morada.setText(String.valueOf(user.getMorada()));
        localidade.setText(String.valueOf(user.getLocalidade()));
    }

    public void alterarDados(JFrame frame, User user) {
        BotaoAlterar.addActionListener(e -> {
            int telefone = 0, nif = 0, numCC = 0;
            String username = this.username.getText();
            String password = String.valueOf(this.password.getPassword());
            String nome = this.nome.getText();
            String morada = this.morada.getText();
            String localidade = this.localidade.getText();

            try {
                telefone = Integer.parseInt(this.telefone.getText());
                nif = Integer.parseInt(this.nif.getText());
                numCC = Integer.parseInt(this.numCC.getText());
            } catch (NumberFormatException err) {
                JOptionPane.showMessageDialog(null, "Não pode introduzir letras num campo de números !");
                return;
            }

            try {
                user.setUsername(username);
                user.setPassword(password);
                user.setNome(nome);
                user.setNumCC(numCC);
                user.setNIF(nif);
                user.setTelefone(telefone);
                user.setMorada(morada);
                user.setLocalidade(localidade);

                MetodosUser.alterarDadosUser(user);
                RepositorioSerializable.writeUsers();

                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso.");
                AlterarDadosCliente.setVisible(false);
                new ListarClientes(frame);
            } catch (AlterarDadosException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        });
    }

    public void limpar() {
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
            AlterarDadosCliente.setVisible(false);
            new ListarClientes(frame);
        });
    }

}
