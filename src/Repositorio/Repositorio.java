package Repositorio;

import Entidades.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repositorio implements Serializable {
    private List<User> users;
    private List<Carro> carros;
    private List<Reserva> reservas;
    private static Repositorio singleInstance;
    private User currentUser;

    public Repositorio() {
        users = new ArrayList<>();
        carros = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public static Repositorio getInstance() {
        if (singleInstance == null) {
            singleInstance = new Repositorio();
        }

        return singleInstance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
