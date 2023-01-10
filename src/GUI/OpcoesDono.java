package GUI;

import javax.swing.*;

public class OpcoesDono {
    private JPanel OpcoesDono;
    private JButton BotaoLogout;
    private JButton ListarClientes;
    private JButton ListarCarros;

    public OpcoesDono(JFrame frame) {
        frame.add(OpcoesDono);
        frame.pack();
        frame.setVisible(true);

        listarClientes(frame);
        logout(frame);
    }

    public void listarClientes(JFrame frame) {
        ListarClientes.addActionListener(e -> {
            OpcoesDono.setVisible(false);
            new ListarClientes(frame);
        });
    }

    public void logout(JFrame frame) {
        BotaoLogout.addActionListener(e -> {
            OpcoesDono.setVisible(false);
            new Login(frame);
        });
    }
}
