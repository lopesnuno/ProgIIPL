package Entidades;

import Estados.Estados;

import java.io.Serializable;

public class Carro implements Serializable {
    private String matricula;
    private String marca;
    private String modelo;
    private int ano;
    private float preco;
    private Estados estado;

    public Carro(String matricula, String marca, String modelo, int ano, float preco) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
        estado = Estados.DISPONIVEL;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
