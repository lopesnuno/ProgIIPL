package GUI;

import Entidades.Cliente;
import Entidades.User;
import Metodos.MetodosAdmin;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarClientes {
    private JPanel ListaClientes;
    private JButton BotaoVoltar;
    private JTable Clientes;
    private JComboBox usersComboBox;
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
                usersComboBox.addItem(u.getUsername());
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

    //TODO: Refactor
    public void alterarDados(JFrame frame) {
        BotaoAlterar.addActionListener(e -> {
            User u = MetodosAdmin.selectUserPorUsername(String.valueOf(usersComboBox.getSelectedItem()));
            ListaClientes.setVisible(false);
            new AlterarDadosUserAdmin(frame, u);
        });
    }

    //TODO: Refactor -> select e remove
    public void removerUser(JFrame frame) {
        BotaoEliminar.addActionListener(e -> {
            User u = MetodosAdmin.selectUserPorUsername(String.valueOf(usersComboBox.getSelectedItem()));
            MetodosAdmin.removerUser(u);
            JOptionPane.showMessageDialog(null, "Utilizador removido.");
            ListaClientes.setVisible(false);
            new OpcoesDono(frame);
        });
    }
}
