package GUI;

import Entidades.Carro;
import Exceptions.AlterarDadosException;
import Metodos.MetodosCarro;
import Repositorio.RepositorioSerializable;

import javax.swing.*;
import java.awt.*;

public class AlterarDadosCarroDono extends JFrame {
    private JPanel AlterarDadosCarroDono;
    private JTextField marca;
    private JTextField modelo;
    private JTextField ano;
    private JTextField preco;
    private JTextField matricula;
    private JButton BotaoAlterar;
    private JButton BotaoLimpar;
    private JButton BotaoVoltar;

    public AlterarDadosCarroDono(JFrame frame, Carro carro) {
        frame.setTitle("Alterar Dados Carro");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(AlterarDadosCarroDono);
        frame.pack();
        frame.setVisible(true);

        alterarDados(frame, carro);
        limparDados();
        voltar(frame);

        marca.setText(carro.getMarca());
        modelo.setText(carro.getModelo());
        ano.setText(String.valueOf(carro.getAno()));
        preco.setText(String.valueOf(carro.getPreco()));
        matricula.setText(carro.getMatricula());
    }

    public void alterarDados(JFrame frame, Carro carro) {
        BotaoAlterar.addActionListener(e -> {
            String marca = this.marca.getText();
            String modelo = this.modelo.getText();
            float preco = Float.parseFloat(this.preco.getText());
            int ano = Integer.parseInt(this.ano.getText());
            String matricula = this.matricula.getText();

            try {
                carro.setMarca(marca);
                carro.setModelo(modelo);
                carro.setPreco(preco);
                carro.setAno(ano);
                carro.setMatricula(matricula);

                MetodosCarro.alterarDadosCarro(carro);
                RepositorioSerializable.writeCarros();

                JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
                AlterarDadosCarroDono.setVisible(false);

                new OpcoesDono(frame);
            } catch (AlterarDadosException err) {
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
            AlterarDadosCarroDono.setVisible(false);
            new ListarCarrosDono(frame);
        });
    }

}
