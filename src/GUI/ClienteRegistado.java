package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteRegistado extends JFrame {
    private JButton BotaoInsereAnimal;
    private JButton BotaoListarEmpresas;
    private JButton BotaoListaAnimais;
    private JButton BotaoMarcarConsulta;
    private JButton BotaoEditarConsulta;
    private JButton BotaoPagaConsulta;
    private JPanel PanelClienteRegistado;
    private JButton BotaoLogout;

    public ClienteRegistado(JFrame frame) {
        frame.setTitle("Gestão de Stand de Automóveis");
        frame.add(PanelClienteRegistado);
        frame.pack();
        frame.setVisible(true);
    }
}
