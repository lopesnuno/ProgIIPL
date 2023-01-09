package GUI;

import javax.swing.*;

public class OpcoesAdmin {
    private JButton ListarUsers;
    private JButton AdicionarUser;
    private JButton pagamentosButton;
    private JPanel OpcoesAdmin;
    private JButton adicionarTiposDeConsultaButton;
    private JButton alterarTiposDeConsultaButton;
    private JButton logoutButton;
    private JButton btn_addAcionistas;

    public OpcoesAdmin(JFrame frame) {
        frame.add(OpcoesAdmin);
        frame.pack();
        frame.setVisible(true);
        listarUsers(frame);
    }

    public void listarUsers(JFrame frame) {
        ListarUsers.addActionListener(e -> {
            OpcoesAdmin.setVisible(false);
            new ListarUsersAdmin(frame);
        });
    }
}
