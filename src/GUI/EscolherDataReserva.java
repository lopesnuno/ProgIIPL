package GUI;

import Entidades.Carro;
import Entidades.Cliente;
import Exceptions.CarroIndisponivelException;
import Metodos.MetodosCliente;
import Repositorio.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

public class EscolherDataReserva {
    private JPanel InfoCarro;
    private JButton BotaoVoltar;
    private JTable Carros;
    private JButton BotaoConfirmar;
    private JTextField DataReserva;


    public EscolherDataReserva(JFrame frame, Carro c) {
        frame.setTitle("Lista de Carros");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.add(InfoCarro);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) Carros.getModel();
        Carros.setModel(model);

        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Ano");
        model.addColumn("Preco");
        model.addColumn("Matricula");

        model.addRow(new Object[]{c.getMarca(), c.getModelo(), c.getAno(), c.getPreco(), c.getMatricula()});

        confirmar(frame, c);
        voltar(frame);
    }

    public void confirmar(JFrame frame, Carro carro) {
        BotaoConfirmar.addActionListener(e -> {
            try {
                String data = this.DataReserva.getText();

                MetodosCliente.addReserva((Cliente) Repositorio.getInstance().getCurrentUser(), carro, new Date(data));
                RepositorioSerializable.writeReservas();

                JOptionPane.showMessageDialog(null, "Carro reservado. Aguarda resposta de dono.");

                InfoCarro.setVisible(false);
                new ListarCarrosCliente(frame);
            } catch (CarroIndisponivelException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }

        });
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            InfoCarro.setVisible(false);
            new OpcoesCliente(frame);
        });
    }
}
