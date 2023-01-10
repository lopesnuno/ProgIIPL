package Entidades;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable {
    private Carro carro;
    private Cliente cliente;
    private Date dataCompra;

    public Reserva(Carro carro, Cliente cliente, Date data) {
        this.carro = carro;
        this.cliente = cliente;
        this.dataCompra = data;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
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
