package GUI;

import Entidades.Cliente;
import Metodos.MetodosAnon;

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
    private final MetodosAnon metodos;

    public ListarDadosCliente(JFrame frame, Cliente cliente) {
        frame.setTitle("Alterar Dados");
        frame.setPreferredSize(new Dimension(500, 500));

        metodos = new MetodosAnon();

        frame.add(DadosCliente);
        frame.pack();
        frame.setVisible(true);
        limparDados();
        voltar(frame);

        username.setText(cliente.getUsername());
        password.setText(cliente.getPassword());
        nome.setText(cliente.getNome());
        numCC.setText(String.valueOf(cliente.getNumCC()));
        nif.setText(String.valueOf(cliente.getNIF()));
        telefone.setText(String.valueOf(cliente.getTelefone()));
        morada.setText(String.valueOf(cliente.getMorada()));
        localidade.setText(String.valueOf(cliente.getLocalidade()));
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
            new ClienteRegistado(frame);
        });
    }

}
