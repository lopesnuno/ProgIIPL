package GUI;

import Entidades.Cliente;
import Entidades.Reserva;
import Repositorio.Repositorio;
import Estados.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarComprasCliente {
    private JPanel ListarComprasCliente;
    private JButton BotaoVoltar;
    private JTable Compras;

    public ListarComprasCliente(JFrame frame) {
        frame.setTitle("Lista de Compras");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.add(ListarComprasCliente);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) Compras.getModel();
        Compras.setModel(model);

        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Preco");
        model.addColumn("Matricula");
        model.addColumn("Comprador");

        Cliente cliente = (Cliente) Repositorio.getInstance().getCurrentUser();

        for (Reserva r : Repositorio.getInstance().getReservas()) {
            if (r.getCliente().getUsername().equals(Repositorio.getInstance().getCurrentUser().getUsername()) &&
                    (r.getCarro().getEstado().equals(Estados.CONCLUIDO)
                            || r.getCarro().getEstado().equals(Estados.COMPRADO))) {
                model.addRow(new Object[]{r.getCarro().getMarca(), r.getCarro().getModelo(), r.getCarro().getPreco(),
                        r.getCarro().getMatricula(), r.getCliente().getUsername()
                });
            }
        }

        voltar(frame);
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            ListarComprasCliente.setVisible(false);
            new OpcoesCliente(frame);
        });
    }
}
