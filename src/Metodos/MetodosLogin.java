package Metodos;

import Entidades.User;
import Exceptions.UserInexistenteException;
import Repositorio.Repositorio;

public class MetodosLogin {

    public User Login(String username, String password) throws UserInexistenteException {
        for (User u : Repositorio.getInstance().getUsers()) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                Repositorio.getInstance().setCurrentUser(u);
                return u;
            }
        }

        throw new UserInexistenteException("Dados inválidos! Tente novamente.");
    }
}
