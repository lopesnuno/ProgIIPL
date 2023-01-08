package Metodos;

import Entidades.User;
import Exceptions.JaExisteUserException;
import Repositorio.Repositorio;

public class MetodosAnon {
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
            //TODO: Add serializable repo
        }
    }
}
