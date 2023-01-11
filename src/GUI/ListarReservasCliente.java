package GUI;

import Entidades.Reserva;
import Estados.Estados;
import Metodos.MetodosCarro;
import Metodos.MetodosReserva;
import Repositorio.*;

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

        for (Reserva r : Repositorio.getInstance().getReservas()) {
            if (r.getCliente().getUsername().equals(Repositorio.getInstance().getCurrentUser().getUsername())) {
                model.addRow(new Object[]{r.getCarro().getMarca(), r.getCarro().getModelo(),
                        r.getCarro().getMatricula(), r.getCarro().getPreco(),
                        r.getDataCompra(), r.getCarro().getEstado()});
                // Apenas adicionar à ComboBox ainda não comprou o carro
                if (r.getCarro().getEstado() != Estados.CONCLUIDO && r.getCarro().getEstado() != Estados.COMPRADO) {
                    reservasComboBox.addItem(r.getCarro().getMatricula());
                }
            }
        }

        cancelar(frame);
        voltar(frame);
    }

    public void cancelar(JFrame frame) {
        BotaoCancelarReserva.addActionListener(e -> {
            Reserva r = MetodosReserva.selectReservaPorMatricula(String.valueOf(reservasComboBox.getSelectedItem()));

            if (r != null) {
                MetodosReserva.removeReserva(r);
                MetodosCarro.disponibilizarCarro(r.getCarro());
                RepositorioSerializable.writeReservas();
            } else {
                JOptionPane.showMessageDialog(null, "Error a cancelar reserva !");
                return;
            }

            JOptionPane.showMessageDialog(null, "Reserva cancelada.");

            ListaReservas.setVisible(false);
            new OpcoesCliente(frame);
        });
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            ListaReservas.setVisible(false);
            new OpcoesCliente(frame);
        });
    }
}
