package Metodos;

import Entidades.Cliente;
import Entidades.User;
import Exceptions.AlterarDadosException;
import Exceptions.UserInexistenteException;
import Repositorio.Repositorio;

public class MetodosAdmin {
    public static User selectUserPorUsername(String username) {
        for (User u : Repositorio.getInstance().getUsers()) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }

        return null;
    }

    public static void alterarDadosUser(User user) throws AlterarDadosException {
        for (User u : Repositorio.getInstance().getUsers()) {
            if (u.getUsername().equals(user.getUsername()) && u.getNIF() == user.getNIF()) {
                u.setUsername(user.getUsername());
                u.setPassword(user.getPassword());
                u.setNome(user.getNome());
                u.setNumCC(user.getNumCC());
                u.setNIF(user.getNIF());
                u.setTelefone(user.getTelefone());
                u.setMorada(user.getMorada());
                u.setLocalidade(user.getLocalidade());
                return;
            }
        }

        throw new AlterarDadosException("Não foi possível encontrar o cliente que queria alterar.");
    }
}
