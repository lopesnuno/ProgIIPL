package GUI;

import Entidades.Cliente;
import Repositorio.Repositorio;

import javax.swing.*;

public class OpcoesCliente extends JFrame {
    private JButton BotaoListarDados;
    private JButton BotaoListarEmpresas;
    private JButton BotaoListaAnimais;
    private JButton BotaoMarcarConsulta;
    private JButton BotaoEditarConsulta;
    private JButton BotaoPagaConsulta;
    private JPanel FrameCliente;
    private JButton BotaoLogout;

    public OpcoesCliente(JFrame frame) {
        frame.setTitle("Gestão de Stand de Automóveis");
        frame.add(FrameCliente);
        frame.pack();
        frame.setVisible(true);

        listarDados(frame);
        logout(frame);
    }

    public void listarDados(JFrame frame) {
        BotaoListarDados.addActionListener(e -> {
            FrameCliente.setVisible(false);
            new ListarDadosCliente(frame, (Cliente) Repositorio.getInstance().getCurrentUser());
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
