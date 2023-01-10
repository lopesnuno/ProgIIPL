package GUI;

import Entidades.Carro;
import Exceptions.JaExisteCarroException;
import Metodos.MetodosCarro;

import javax.swing.*;
import java.awt.*;

public class AdicionarCarroDono extends JFrame {
    private JPanel AdicionarCarro;
    private JTextField marca;
    private JTextField modelo;
    private JTextField ano;
    private JTextField preco;
    private JTextField matricula;
    private JButton BotaoAdicionar;
    private JButton BotaoLimpar;
    private JButton BotaoVoltar;

    public AdicionarCarroDono(JFrame frame) {
        frame.setTitle("Adicionar Carro");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(AdicionarCarro);
        frame.pack();
        frame.setVisible(true);

        adicionarCarro(frame);
        limparDados();
        voltar(frame);
    }

    public void adicionarCarro(JFrame frame) {
        BotaoAdicionar.addActionListener(e -> {
            String marca = this.marca.getText();
            String modelo = this.modelo.getText();
            float preco = Float.parseFloat(this.preco.getText());
            int ano = Integer.parseInt(this.ano.getText());
            String matricula = this.matricula.getText();

            Carro carro = new Carro(matricula, marca, modelo, ano, preco);
            try {
                MetodosCarro.addCarro(carro);
                JOptionPane.showMessageDialog(null, "Adicionado com sucesso.");
                AdicionarCarro.setVisible(false);

                new OpcoesDono(frame);
            } catch (JaExisteCarroException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        });
    }

    public void limparDados() {
        BotaoLimpar.addActionListener(e -> {
            marca.setText(null);
            ano.setText(null);
            matricula.setText(null);
            preco.setText(null);
            modelo.setText(null);
        });
    }

    public void voltar(JFrame frame) {
        BotaoVoltar.addActionListener(e -> {
            AdicionarCarro.setVisible(false);
            new OpcoesDono(frame);
        });
    }

}
