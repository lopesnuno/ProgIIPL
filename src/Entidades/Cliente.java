package Entidades;

public class Cliente extends User{

    public Cliente(String username, String password, String nome, int numCC, int NIF, int telefone, String morada, String localidade) {
        super(username, password, nome, numCC, NIF, telefone, morada, localidade);
    }
}
