package Entidades;

public class User {
    private String username;
    private String password;
    private String nome;
    private int numCC;
    private int NIF;
    private int telefone;
    private String morada;
    private String localidade;

    public User() {}

    public User(String username, String passwd, String nome, int numCC, int NIF, int telefone, String morada, String localidade) {
        this.username = username;
        this.password = passwd;
        this.nome = nome;
        this.numCC = numCC;
        this.NIF = NIF;
        this.telefone = telefone;
        this.morada = morada;
        this.localidade = localidade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumCC() {
        return numCC;
    }

    public void setNumCC(int numCC) {
        this.numCC = numCC;
    }

    public int getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
}
