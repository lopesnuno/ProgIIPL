package GUI;

import javax.swing.*;

public class OpcoesDono {
    private JPanel OpcoesDono;
    private JButton BotaoLogout;
    private JButton ListarClientes;
    private JButton ListarCarros;
    private JButton BotaoAdicionarCarro;

    public OpcoesDono(JFrame frame) {
        frame.add(OpcoesDono);
        frame.pack();
        frame.setVisible(true);

        listarClientes(frame);
        adicionarCarro(frame);
        logout(frame);
    }

    public void listarClientes(JFrame frame) {
        ListarClientes.addActionListener(e -> {
            OpcoesDono.setVisible(false);
            new ListarClientes(frame);
        });
    }

    public void adicionarCarro(JFrame frame) {
        BotaoAdicionarCarro.addActionListener(e -> {
            OpcoesDono.setVisible(false);
            new AdicionarCarroDono(frame);
        });
    }

    public void logout(JFrame frame) {
        BotaoLogout.addActionListener(e -> {
            OpcoesDono.setVisible(false);
            new Login(frame);
        });
    }
}
