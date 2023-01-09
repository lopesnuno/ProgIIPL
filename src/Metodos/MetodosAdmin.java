package Metodos;

import Entidades.User;
import Exceptions.AlterarDadosException;
import Exceptions.JaExisteUserException;
import Repositorio.Repositorio;
import Repositorio.RepositorioSerializable;

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

    public static void addUser(User user) throws JaExisteUserException {
        boolean existe = false;
        for (User u : Repositorio.getInstance().getUsers()) {
            if (u.getUsername().equals(user.getUsername()) || u.getNIF() == user.getNIF()) {
                existe = true;
                break;
            }
        }

        if (existe) {
            throw new JaExisteUserException("Este utilizador já existe !");
        } else {
            Repositorio.getInstance().getUsers().add(user);
            RepositorioSerializable.writeUsers();
        }
    }

    public static void removerUser(User user) {
        Repositorio.getInstance().getUsers().remove(user);
        RepositorioSerializable.writeUsers();
    }
}
