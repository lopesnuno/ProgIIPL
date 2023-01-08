package Entidades;

public class Admin extends User {

    public Admin(String username, String password, String nome, int numCC, int NIF, int telefone, String morada, String localidade) {
        super(username, password, nome, numCC, NIF, telefone, morada, localidade);
    }
}
