package GUI;

import javax.swing.*;

public class AdicionarTipoUser extends JFrame {
    private JButton BotaoCliente;
    private JButton BotaoDono;
    private JPanel AdicionarUsersAdmin;
    private JButton BotaoVoltar;
    private JButton BotaoAdmin;

    public AdicionarTipoUser(JFrame frame) {
        frame.add(AdicionarUsersAdmin);
        frame.pack();
        frame.setVisible(true);

        cliente(frame);
        dono(frame);
        admin(frame);
        voltar(frame);
    }

    public void cliente(JFrame frame) {
        BotaoCliente.addActionListener(e -> {
            AdicionarUsersAdmin.setVisible(false);
            new AdicionarUserAdmin(frame, "Cliente");
        });
    }

    public void dono(JFrame frame) {
        BotaoDono.addActionListener(e -> {
            AdicionarUsersAdmin.setVisible(false);
            new AdicionarUserAdmin(frame, "Dono");
        });
    }

    public void admin(JFrame frame) {
        BotaoAdmin.addActionListener(e -> {
            AdicionarUsersAdmin.setVisible(false);
            new AdicionarUserAdmin(frame, "Admin");
        });
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            AdicionarUsersAdmin.setVisible(false);
            new OpcoesAdmin(frame);
        });
    }
}
