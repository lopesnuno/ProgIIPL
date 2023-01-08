package Repositorio;

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

    public static void readBin() {
        readUsers();
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
        } catch (ClassNotFoundException erro2) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro2.getMessage());
            return;
        }
        //
        catch (IOException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
            return;
        }
        Repositorio.getInstance().setUsers(users);
    }
}
