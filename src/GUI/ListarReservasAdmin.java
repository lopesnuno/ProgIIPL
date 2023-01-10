package GUI;

import Entidades.Reserva;
import Metodos.MetodosCarro;
import Metodos.MetodosReserva;
import Repositorio.Repositorio;
import Repositorio.RepositorioSerializable;
import Estados.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarReservasAdmin {
    private JPanel ListarReservasAdmin;
    private JButton BotaoVoltar;
    private JTable ReservasInfo;
    private JComboBox reservasComboBox;
    private JButton BotaoCancelarReserva;
    private JButton BotaoConfirmarReserva;


    public ListarReservasAdmin(JFrame frame) {
        frame.setTitle("Lista de Reservas");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.add(ListarReservasAdmin);
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
        model.addColumn("Cliente");

        for (Reserva r : Repositorio.getInstance().getReservas()) {
            model.addRow(new Object[]{r.getCarro().getMarca(), r.getCarro().getModelo(), r.getCarro().getMatricula(),
                    r.getCarro().getPreco(), r.getDataCompra(), r.getCarro().getEstado(),
                    r.getCliente().getUsername()});
            if (r.getCarro().getEstado() != Estados.CONCLUIDO || r.getCarro().getEstado() != Estados.COMPRADO)
                reservasComboBox.addItem(r.getCarro().getMatricula());
        }

        cancelarReserva(frame);
        confirmarReserva(frame);
        voltar(frame);
    }

    public void cancelarReserva(JFrame frame) {
        BotaoCancelarReserva.addActionListener(e -> {
            Reserva reserva = MetodosReserva.selectReservaPorMatricula(String.valueOf(reservasComboBox.getSelectedItem()));

            if (reserva != null) {
                MetodosReserva.removeReserva(reserva);
                MetodosCarro.disponibilizarCarro(reserva.getCarro());
                RepositorioSerializable.writeReservas();
                RepositorioSerializable.writeCarros();

                JOptionPane.showMessageDialog(null, "Reserva cancelada.");
                ListarReservasAdmin.setVisible(false);
                new OpcoesAdmin(frame);
            } else {
                JOptionPane.showMessageDialog(null, "Erro a cancelar reserva.");
            }
        });
    }

    public void confirmarReserva(JFrame frame) {
        BotaoConfirmarReserva.addActionListener(e -> {
            Reserva reserva = MetodosReserva.selectReservaPorMatricula(String.valueOf(reservasComboBox.getSelectedItem()));

            if (reserva != null) {
                MetodosReserva.confirmarReserva(reserva);
                RepositorioSerializable.writeCarros();
                RepositorioSerializable.writeReservas();

                JOptionPane.showMessageDialog(null, "Reserva confirmada.");
                ListarReservasAdmin.setVisible(false);
                new OpcoesAdmin(frame);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao confirmar reserva.");
            }
        });
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            ListarReservasAdmin.setVisible(false);
            new OpcoesAdmin(frame);
        });
    }
}
