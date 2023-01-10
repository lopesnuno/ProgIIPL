package GUI;

import Entidades.Compra;
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
        model.addColumn("Ano");
        model.addColumn("Preco");
        model.addColumn("Matricula");
        model.addColumn("Comprador");

        for (Compra c : Repositorio.getInstance().getCompras()) {
            model.addRow(new Object[]{c.getCarro().getMarca(), c.getCarro().getModelo(), c.getCarro().getAno(),
                    c.getCarro().getPreco(), c.getCarro().getMatricula(), c.getCliente().getUsername()
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
