package GUI;

import Entidades.Reserva;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarReservasCliente {
    private JPanel ListaReservas;
    private JButton BotaoVoltar;
    private JTable ReservasInfo;
    private JComboBox reservasComboBox;
    private JButton BotaoCancelarReserva;


    //TODO: Cancelar e editar reserva
    public ListarReservasCliente(JFrame frame) {
        frame.setTitle("Lista de Carros");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.add(ListaReservas);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) ReservasInfo.getModel();
        ReservasInfo.setModel(model);

        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Matricula");
        model.addColumn("Preco");
        model.addColumn("Data");
        model.addColumn("Estado");

        for (Reserva r : Repositorio.getInstance().getReservas()) {
            if (r.getCliente().getUsername().equals(Repositorio.getInstance().getCurrentUser().getUsername())) {
                model.addRow(new Object[]{r.getCarro().getMarca(), r.getCarro().getModelo(),
                        r.getCarro().getMatricula(), r.getCarro().getPreco(),
                        r.getDataCompra(), r.getCarro().getEstado()});
                reservasComboBox.addItem(r.getCarro().getMatricula());
            }
        }

        voltar(frame);
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            ListaReservas.setVisible(false);
            new OpcoesCliente(frame);
        });
    }
}
