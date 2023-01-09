package Exceptions;

public class UserInexistenteException extends Exception {
    public UserInexistenteException(String mensagem) {
        super(mensagem);
    }
}
