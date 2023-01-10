package GUI;

import Entidades.*;
import Estados.Estados;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarCarrosCliente {
    private JPanel ListaCarros;
    private JButton BotaoVoltar;
    private JTable Carros;
    private JComboBox usersComboBox;
    private JButton BotaoComprar;
    private JButton BotaoReservar;


    public ListarCarrosCliente(JFrame frame) {
        frame.setTitle("Lista de Carros");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.add(ListaCarros);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) Carros.getModel();
        Carros.setModel(model);

        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Ano");
        model.addColumn("Preco");
        model.addColumn("Matricula");

        for (Carro c : Repositorio.getInstance().getCarros()) {
            if (c.getEstado().equals(Estados.DISPONIVEL)) {
                model.addRow(new Object[]{c.getMarca(), c.getModelo(), c.getAno(), c.getPreco(), c.getMatricula()});
                usersComboBox.addItem(c.getMatricula());
            }
        }

        voltar(frame);
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            ListaCarros.setVisible(false);
            new OpcoesCliente(frame);
        });
    }
}
