package Entidades;

import java.util.Date;

public class Reserva {
    private String matricula;
    private Cliente cliente;
    private Date dataCompra;

    public Reserva(String matricula, Cliente cliente, Date data) {
        this.matricula = matricula;
        this.cliente = cliente;
        this.dataCompra = data;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
}
