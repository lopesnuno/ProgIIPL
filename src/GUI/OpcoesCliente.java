package GUI;

import Entidades.Cliente;
import Repositorio.Repositorio;

import javax.swing.*;

public class OpcoesCliente extends JFrame {
    private JButton BotaoListarDados;
    private JPanel FrameCliente;
    private JButton BotaoLogout;
    private JButton BotaoListarCarros;

    public OpcoesCliente(JFrame frame) {
        frame.setTitle("Gestão de Stand de Automóveis");
        frame.add(FrameCliente);
        frame.pack();
        frame.setVisible(true);

        listarDados(frame);
        listarCarros(frame);
        logout(frame);
    }

    public void listarDados(JFrame frame) {
        BotaoListarDados.addActionListener(e -> {
            FrameCliente.setVisible(false);
            new ListarDadosCliente(frame, (Cliente) Repositorio.getInstance().getCurrentUser());
        });
    }
    public void listarCarros(JFrame frame) {
        BotaoListarCarros.addActionListener(e -> {
            FrameCliente.setVisible(false);
            new ListarCarrosCliente(frame);
        });
    }

    public void logout(JFrame frame) {
        BotaoLogout.addActionListener(e -> {
            FrameCliente.setVisible(false);
            Repositorio.getInstance().setCurrentUser(null);
            new Login(frame);
        });
    }
}
