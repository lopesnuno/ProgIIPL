package GUI;

import Entidades.Cliente;
import Exceptions.AlterarDadosException;
import Metodos.MetodosCliente;
import Repositorio.RepositorioSerializable;

import javax.swing.*;
import java.awt.*;

public class ListarDadosCliente extends JFrame {
    private JPanel DadosCliente;
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

    public ListarDadosCliente(JFrame frame, Cliente cliente) {
        frame.setTitle("Alterar Dados");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.add(DadosCliente);
        frame.pack();
        frame.setVisible(true);
        limparDados();
        voltar(frame);
        alterarDados(frame, cliente);

        username.setText(cliente.getUsername());
        password.setText(cliente.getPassword());
        nome.setText(cliente.getNome());
        numCC.setText(String.valueOf(cliente.getNumCC()));
        nif.setText(String.valueOf(cliente.getNIF()));
        telefone.setText(String.valueOf(cliente.getTelefone()));
        morada.setText(String.valueOf(cliente.getMorada()));
        localidade.setText(String.valueOf(cliente.getLocalidade()));
    }

    public void alterarDados(JFrame frame, Cliente cliente) {
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
                cliente.setUsername(username);
                cliente.setPassword(password);
                cliente.setNome(nome);
                cliente.setNumCC(numCC);
                cliente.setNIF(nif);
                cliente.setTelefone(telefone);
                cliente.setMorada(morada);
                cliente.setLocalidade(localidade);

                MetodosCliente.alterarDadosCliente(cliente);
                RepositorioSerializable.writeUsers();

                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso.");
                DadosCliente.setVisible(false);
                new OpcoesCliente(frame);
            } catch (AlterarDadosException err) {
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
            DadosCliente.setVisible(false);
            new OpcoesCliente(frame);
        });
    }

}
