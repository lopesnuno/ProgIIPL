package GUI;

import Entidades.Reserva;
import Metodos.MetodosCarro;
import Metodos.MetodosDono;
import Metodos.MetodosReserva;
import Repositorio.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarReservasDono {
    private JPanel ListaReservas;
    private JButton BotaoVoltar;
    private JTable ReservasInfo;
    private JComboBox reservasComboBox;
    private JButton BotaoCancelarReserva;
    private JButton BotaoConfirmarReserva;


    public ListarReservasDono(JFrame frame) {
        frame.setTitle("Lista de Reservas");
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
        model.addColumn("Cliente");

        for (Reserva r : Repositorio.getInstance().getReservas()) {
            model.addRow(new Object[]{r.getCarro().getMarca(), r.getCarro().getModelo(), r.getCarro().getMatricula(),
                    r.getCarro().getPreco(), r.getDataCompra(), r.getCarro().getEstado(),
                    r.getCliente().getUsername()});
            reservasComboBox.addItem(r.getCarro().getMatricula());
        }

        cancelarReserva(frame);
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
                ListaReservas.setVisible(false);
                new OpcoesCliente(frame);
            } else {
                JOptionPane.showMessageDialog(null, "Erro a cancelar reserva.");
            }
        });
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            ListaReservas.setVisible(false);
            new OpcoesCliente(frame);
        });
    }
}
