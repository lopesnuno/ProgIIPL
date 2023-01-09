package GUI;

import Repositorio.Repositorio;

import javax.swing.*;

public class OpcoesAdmin {
    private JButton ListarUsers;
    private JButton AdicionarUser;
    private JButton pagamentosButton;
    private JPanel OpcoesAdmin;
    private JButton adicionarTiposDeConsultaButton;
    private JButton alterarTiposDeConsultaButton;
    private JButton BotaoLogout;
    private JButton btn_addAcionistas;

    public OpcoesAdmin(JFrame frame) {
        frame.add(OpcoesAdmin);
        frame.pack();
        frame.setVisible(true);

        listarUsers(frame);
        logout(frame);
    }

    public void listarUsers(JFrame frame) {
        ListarUsers.addActionListener(e -> {
            OpcoesAdmin.setVisible(false);
            new ListarUsersAdmin(frame);
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
