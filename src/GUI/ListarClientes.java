package GUI;

import Entidades.Cliente;
import Entidades.User;
import Metodos.MetodosUser;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarClientes {
    private JPanel ListaClientes;
    private JButton BotaoVoltar;
    private JTable Clientes;
    private JComboBox clientesComboBox;
    private JButton BotaoEliminar;
    private JButton BotaoAlterar;


    public ListarClientes(JFrame frame) {
        frame.setTitle("Lista de Clientes");
        frame.setPreferredSize(new Dimension(800, 600));

        frame.add(ListaClientes);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) Clientes.getModel();
        Clientes.setModel(model);

        model.addColumn("Username");
        model.addColumn("Nome");
        model.addColumn("Numero de CC");
        model.addColumn("NIF");
        model.addColumn("Telefone");
        model.addColumn("Morada");
        model.addColumn("Localidade");

        for (User u : Repositorio.getInstance().getUsers()) {
            if (u instanceof Cliente) {
                model.addRow(new Object[]{u.getUsername(), u.getNome(), u.getNumCC(), u.getNIF(), u.getTelefone(),
                        u.getMorada(), u.getLocalidade()
                });
                clientesComboBox.addItem(u.getUsername());
            }
        }

        voltar(frame);
        alterarDados(frame);
        removerUser(frame);
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            ListaClientes.setVisible(false);
            new OpcoesDono(frame);
        });
    }

    public void alterarDados(JFrame frame) {
        BotaoAlterar.addActionListener(e -> {
            User u = MetodosUser.selectUserPorUsername(String.valueOf(clientesComboBox.getSelectedItem()));
            ListaClientes.setVisible(false);
            new AlterarDadosClienteDono(frame, u);
        });
    }

    public void removerUser(JFrame frame) {
        BotaoEliminar.addActionListener(e -> {
            User u = MetodosUser.selectUserPorUsername(String.valueOf(clientesComboBox.getSelectedItem()));
            MetodosUser.removerUser(u);
            JOptionPane.showMessageDialog(null, "Utilizador removido.");
            ListaClientes.setVisible(false);
            new OpcoesDono(frame);
        });
    }
}
