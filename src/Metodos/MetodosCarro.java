package Metodos;

import Entidades.Carro;
import Repositorio.Repositorio;

public class MetodosCarro {
    public static Carro selectCarroPorMatriucla(String matricula) {
        for (Carro c : Repositorio.getInstance().getCarros()) {
            if (c.getMatricula().equals(matricula)) {
                return c;
            }
        }

        return null;
    }
}
