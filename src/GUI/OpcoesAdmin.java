package GUI;

import Repositorio.Repositorio;

import javax.swing.*;

public class OpcoesAdmin {
    private JButton ListarUsers;
    private JButton AdicionarUser;
    private JPanel OpcoesAdmin;
    private JButton BotaoLogout;
    private JButton BotaoListarCompras;

    public OpcoesAdmin(JFrame frame) {
        frame.add(OpcoesAdmin);
        frame.pack();
        frame.setVisible(true);

        listarUsers(frame);
        adicionarUser(frame);
        listarCompras(frame);
        logout(frame);
    }

    public void listarUsers(JFrame frame) {
        ListarUsers.addActionListener(e -> {
            OpcoesAdmin.setVisible(false);
            new ListarUsersAdmin(frame);
        });
    }

    public void adicionarUser(JFrame frame) {
        AdicionarUser.addActionListener(e -> {
            OpcoesAdmin.setVisible(false);
            new AdicionarTipoUser(frame);
        });
    }

    public void listarCompras(JFrame frame) {
        BotaoListarCompras.addActionListener(e -> {
            OpcoesAdmin.setVisible(false);
            new ListarComprasAdmin(frame);
        });
    }

    public void logout(JFrame frame) {
        BotaoLogout.addActionListener(e -> {
            OpcoesAdmin.setVisible(false);
            Repositorio.getInstance().setCurrentUser(null);
            new Login(frame);
        });
    }
}
