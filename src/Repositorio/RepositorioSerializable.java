package Repositorio;

import Entidades.Carro;
import Entidades.Reserva;
import Entidades.User;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioSerializable {
    public static void writeUsers() {
        File file = new File("users.dat");
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(Repositorio.getInstance().getUsers());
            objOutput.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Houve um erro: " + e.getMessage());
        }
    }

    public static void writeCarros() {
        File file = new File("carros.dat");
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(Repositorio.getInstance().getCarros());
            objOutput.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Houve um erro: " + e.getMessage());
        }
    }

    public static void writeReservas() {
        File file = new File("reservas.dat");
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(Repositorio.getInstance().getReservas());
            objOutput.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Houve um erro: " + e.getMessage());
        }
    }

    public static void readBin() {
        readUsers();
        readCarros();
        readReservas();
    }

    public static void readUsers() {
        List<User> users = new ArrayList<>();
        try {
            File file = new File("users.dat");
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                users = (List<User>) objInput.readObject();
                objInput.close();
            }
        } catch (ClassNotFoundException | IOException erro2) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro2.getMessage());
            return;
        }
        Repositorio.getInstance().setUsers(users);
    }

    public static void readCarros() {
        List<Carro> carros = new ArrayList<>();
        try {
            File file = new File("carros.dat");
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                carros = (List<Carro>) objInput.readObject();
                objInput.close();
            }
        } catch (ClassNotFoundException | IOException erro2) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro2.getMessage());
            return;
        }
        Repositorio.getInstance().setCarros(carros);
    }

    public static void readReservas() {
        List<Reserva> reservas = new ArrayList<>();
        try {
            File file = new File("reservas.dat");
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                reservas = (List<Reserva>) objInput.readObject();
                objInput.close();
            }
        } catch (ClassNotFoundException | IOException erro2) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro2.getMessage());
            return;
        }
        Repositorio.getInstance().setReservas(reservas);
    }
}
