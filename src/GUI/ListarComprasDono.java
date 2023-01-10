package GUI;

import Entidades.Compra;
import Entidades.Reserva;
import Estados.Estados;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarComprasDono {
    private JPanel ListarComprasDono;
    private JButton BotaoVoltar;
    private JTable Compras;

    public ListarComprasDono(JFrame frame) {
        frame.setTitle("Lista de Compras");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.add(ListarComprasDono);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) Compras.getModel();
        Compras.setModel(model);

        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Preco");
        model.addColumn("Matricula");
        model.addColumn("Comprador");

        for (Reserva r : Repositorio.getInstance().getReservas()) {
            if (r.getCarro().getEstado().equals(Estados.CONCLUIDO) || r.getCarro().getEstado().equals(Estados.COMPRADO))
                model.addRow(new Object[]{r.getCarro().getMarca(), r.getCarro().getModelo(), r.getCarro().getPreco(),
                        r.getCarro().getMatricula(), r.getCliente().getUsername()
                });
        }

        voltar(frame);
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            ListarComprasDono.setVisible(false);
            new OpcoesDono(frame);
        });
    }
}
