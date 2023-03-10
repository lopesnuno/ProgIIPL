import Entidades.Admin;
import GUI.Login;
import Repositorio.*;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {

        Repositorio r = Repositorio.getInstance();
        RepositorioSerializable.readBin();
        if(r.getUsers().isEmpty()){
            r.getUsers().add(new Admin("admin","admin","Admin",0,0,
                    0,"Vila de Prado","Braga"));
            RepositorioSerializable.writeUsers();
        }

        JFrame frame = new JFrame("Gestão de Stand de Automóveis");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        new Login(frame);
    }
}