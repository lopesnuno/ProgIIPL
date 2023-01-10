package Metodos;

import Entidades.Carro;
import Entidades.Cliente;
import Entidades.Reserva;
import Entidades.User;
import Estados.Estados;
import Exceptions.AlterarDadosException;
import Exceptions.CarroIndisponivelException;
import Repositorio.Repositorio;

import java.util.Date;

public class MetodosCliente {
    public static void alterarDadosCliente(Cliente cliente) throws AlterarDadosException {
        for (User u : Repositorio.getInstance().getUsers()) {
            if (u.getUsername().equals(cliente.getUsername()) && u.getNIF() == cliente.getNIF()) {
                u.setUsername(cliente.getUsername());
                u.setPassword(cliente.getPassword());
                u.setNome(cliente.getNome());
                u.setNumCC(cliente.getNumCC());
                u.setNIF(cliente.getNIF());
                u.setTelefone(cliente.getTelefone());
                u.setMorada(cliente.getMorada());
                u.setLocalidade(cliente.getLocalidade());
                return;
            }
        }

        throw new AlterarDadosException("Não foi possível encontrar o cliente que queria alterar.");
    }

    public static void addReserva(Cliente cliente, Carro carro) throws CarroIndisponivelException {
        boolean existe = false;

        for (Reserva r : Repositorio.getInstance().getReservas()) {
            if (r.getMatricula().equals(carro.getMatricula())) {
                existe = true;
                break;
            }
        }

        if (existe)
            throw new CarroIndisponivelException("Esse carro já está reservado !");

        carro.setEstado(Estados.RESERVADO);
        Reserva reserva = new Reserva(carro.getMatricula(), cliente, new Date());
        Repositorio.getInstance().getReservas().add(reserva);
        // RepositorioSerializable.writeCarros();
    }
}
