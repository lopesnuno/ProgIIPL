package GUI;

import Entidades.*;
import Estados.Estados;
import Exceptions.JaFoiCompradoException;
import Metodos.MetodosCarro;
import Metodos.MetodosCompra;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

public class ListarCarrosCliente {
    private JPanel ListaCarros;
    private JButton BotaoVoltar;
    private JTable Carros;
    private JComboBox carrosComboBox;
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
                carrosComboBox.addItem(c.getMatricula());
            }
        }

        reservar(frame);
        comprar(frame);
        voltar(frame);
    }

    public void reservar(JFrame frame) {
        BotaoReservar.addActionListener(e -> {
            Carro c = MetodosCarro.selectCarroPorMatriucla(String.valueOf(carrosComboBox.getSelectedItem()));
            ListaCarros.setVisible(false);
            new EscolherDataReserva(frame, c);
        });
    }

    //TODO: fix
    public void comprar(JFrame frame) {
        BotaoComprar.addActionListener(e -> {
            try {
                Carro c = MetodosCarro.selectCarroPorMatriucla(String.valueOf(carrosComboBox.getSelectedItem()));
                Compra cc = new Compra(c, (Cliente) Repositorio.getInstance().getCurrentUser(), new Date());

                MetodosCompra.addCompra(cc);

                JOptionPane.showMessageDialog(null, "Carro comprado.");

                ListaCarros.setVisible(false);
                new OpcoesCliente(frame);
            } catch (JaFoiCompradoException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        });
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            ListaCarros.setVisible(false);
            new OpcoesCliente(frame);
        });
    }
}
