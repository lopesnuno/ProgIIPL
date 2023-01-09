package Metodos;

import Entidades.Cliente;
import Entidades.User;
import Exceptions.AlterarDadosException;
import Repositorio.Repositorio;

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
}
