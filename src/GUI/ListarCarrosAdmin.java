package GUI;

import Entidades.Carro;
import Metodos.MetodosCarro;
import Repositorio.Repositorio;
import Estados.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarCarrosAdmin {
    private JPanel ListarCarrosAdmin;
    private JButton BotaoVoltar;
    private JTable Carros;
    private JComboBox carrosComboBox;
    private JButton BotaoRemover;
    private JButton BotaoEditar;
    private JButton BotaoAtivar;


    public ListarCarrosAdmin(JFrame frame) {
        frame.setTitle("Lista de Carros");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.add(ListarCarrosAdmin);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) Carros.getModel();
        Carros.setModel(model);

        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Ano");
        model.addColumn("Preco");
        model.addColumn("Matricula");
        model.addColumn("Estado");

        for (Carro c : Repositorio.getInstance().getCarros()) {
            model.addRow(new Object[]{c.getMarca(), c.getModelo(), c.getAno(), c.getPreco(), c.getMatricula(), c.getEstado()});
            carrosComboBox.addItem(c.getMatricula());
        }

        remover(frame);
        ativar(frame);
        editar(frame);
        voltar(frame);
    }

    public void editar(JFrame frame) {
        BotaoEditar.addActionListener(e -> {
            Carro c = MetodosCarro.selectCarroPorMatriucla(String.valueOf(carrosComboBox.getSelectedItem()));
            ListarCarrosAdmin.setVisible(false);
            new AlterarDadosCarroDono(frame, c);
        });
    }
    public void remover(JFrame frame) {
        BotaoRemover.addActionListener(e -> {
            Carro c = MetodosCarro.selectCarroPorMatriucla(String.valueOf(carrosComboBox.getSelectedItem()));

            if (c != null && c.getEstado().equals(Estados.DESATIVADO)) {
                JOptionPane.showMessageDialog(null, "Carro já está removido !");
                return;
            }

            MetodosCarro.removerCarro(c);
            JOptionPane.showMessageDialog(null, "Carro removido.");
            ListarCarrosAdmin.setVisible(false);
            new OpcoesAdmin(frame);
        });
    }

    public void ativar(JFrame frame) {
        BotaoAtivar.addActionListener(e -> {
            Carro c = MetodosCarro.selectCarroPorMatriucla(String.valueOf(carrosComboBox.getSelectedItem()));

            if (c != null && c.getEstado().equals(Estados.DISPONIVEL)) {
                JOptionPane.showMessageDialog(null, "Carro já disponibilizado !");
                return;
            }

            MetodosCarro.disponibilizarCarro(c);
            JOptionPane.showMessageDialog(null, "Carro disponibilizado.");
            ListarCarrosAdmin.setVisible(false);
            new OpcoesAdmin(frame);
        });
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            ListarCarrosAdmin.setVisible(false);
            new OpcoesAdmin(frame);
        });
    }
}
