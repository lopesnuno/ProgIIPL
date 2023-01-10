package GUI;

import Entidades.Reserva;
import Estados.Estados;
import Exceptions.JaFoiCompradoException;
import Metodos.MetodosCompra;
import Metodos.MetodosReserva;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RegistarCompraDono {
    private JPanel ListaCarros;
    private JButton BotaoVoltar;
    private JTable Carros;
    private JComboBox reservasComboBox;
    private JButton BotaoConfirmarComprar;
    private JButton BotaoOutraCompra;


    public RegistarCompraDono(JFrame frame) {
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

        for (Reserva r : Repositorio.getInstance().getReservas()) {
            if (r.getCarro().getEstado() != Estados.CONCLUIDO) {
                model.addRow(new Object[]{r.getCarro().getMarca(), r.getCarro().getModelo(), r.getCarro().getMatricula(),
                        r.getCarro().getPreco(), r.getDataCompra(), r.getCarro().getEstado(),
                        r.getCliente().getUsername()});
                reservasComboBox.addItem(r.getCarro().getMatricula());
            }
        }

        confirmarCompra(frame);
        voltar(frame);
    }

    public void confirmarCompra(JFrame frame) {
        BotaoConfirmarComprar.addActionListener(e -> {
            try {
                Reserva r = MetodosReserva.selectReservaPorMatricula(String.valueOf(reservasComboBox.getSelectedItem()));
                MetodosCompra.confirmarCompraReseva(r);

                JOptionPane.showMessageDialog(null, "Compra confirmada.");

                ListaCarros.setVisible(false);
                new OpcoesDono(frame);
            } catch (JaFoiCompradoException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        });
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            ListaCarros.setVisible(false);
            new OpcoesDono(frame);
        });
    }
}
