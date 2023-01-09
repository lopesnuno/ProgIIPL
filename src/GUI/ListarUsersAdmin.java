package GUI;

import Entidades.Admin;
import Entidades.Cliente;
import Entidades.Dono;
import Entidades.User;
import Metodos.MetodosAdmin;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarUsersAdmin {
    private JPanel ListaUsers;
    private JButton BotaoVoltar;
    private JTable Users;
    private JComboBox usersComboBox;
    private JButton BotaoEliminar;
    private JButton BotaoAlterar;


    public ListarUsersAdmin(JFrame frame) {
        frame.setTitle("Lista de Utilizadores");
        frame.setPreferredSize(new Dimension(800, 600));

        frame.add(ListaUsers);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) Users.getModel();
        Users.setModel(model);

        model.addColumn("Username");
        model.addColumn("Nome");
        model.addColumn("Numero de CC");
        model.addColumn("NIF");
        model.addColumn("Telefone");
        model.addColumn("Morada");
        model.addColumn("Localidade");
        model.addColumn("Tipo");

        for (User u : Repositorio.getInstance().getUsers()) {
            model.addRow(new Object[]{u.getUsername(), u.getNome(), u.getNumCC(), u.getNIF(), u.getTelefone(),
                    u.getMorada(), u.getLocalidade(), tipoUser(u)
            });
            usersComboBox.addItem(u.getUsername());
        }

        voltar(frame);
        alterarDados(frame);
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            ListaUsers.setVisible(false);
            new OpcoesAdmin(frame);
        });
    }

    public String tipoUser(User u) {
        if (u instanceof Cliente) {
            return "Cliente";
        }

        if (u instanceof Admin) {
            return "Admin";
        }

        if (u instanceof Dono) {
            return "Dono";
        }

        return "Undefined";
    }

    public void alterarDados(JFrame frame) {
        BotaoAlterar.addActionListener(e -> {
            User u = MetodosAdmin.selectUserPorUsername(String.valueOf(usersComboBox.getSelectedItem()));
            ListaUsers.setVisible(false);
            new AlterarDadosUserAdmin(frame, u);
        });
    }
}
