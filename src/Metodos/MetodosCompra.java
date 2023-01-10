package Metodos;

import Entidades.Compra;
import Entidades.Reserva;
import Estados.Estados;
import Exceptions.JaFoiCompradoException;
import Repositorio.Repositorio;
import Repositorio.RepositorioSerializable;

import java.util.Date;

public class MetodosCompra {
    public static void addCompra(Compra compra) throws JaFoiCompradoException {
        boolean existe = false;

        for (Compra c : Repositorio.getInstance().getCompras()) {
            if (c.getCarro().equals(compra.getCarro())) {
                existe = true;
                break;
            }
        }

        if (existe) {
            throw new JaFoiCompradoException("Esse carro já foi comprado !");
        } else {
            Repositorio.getInstance().getCompras().add(compra);
            RepositorioSerializable.writeCompras();
        }
    }

    public static void confirmarCompraReseva(Reserva reserva) throws JaFoiCompradoException {
        for (Reserva r : Repositorio.getInstance().getReservas()) {
            if (r.equals(reserva)) {
                reserva.getCarro().setEstado(Estados.CONCLUIDO);
                Compra c = new Compra(reserva.getCarro(), reserva.getCliente(), new Date());

                Repositorio.getInstance().getCompras().add(c);
                RepositorioSerializable.writeReservas();
                RepositorioSerializable.writeCompras();
            }
        }
    }
}

